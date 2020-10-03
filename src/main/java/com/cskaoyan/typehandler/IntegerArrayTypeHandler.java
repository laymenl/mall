package com.cskaoyan.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Integer[].class)
public class IntegerArrayTypeHandler extends BaseTypeHandler<Integer[]> {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int index, Integer[] integers, JdbcType jdbcType) throws SQLException {
        String value = null;
        try {
            value = objectMapper.writeValueAsString(integers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        preparedStatement.setString(index,value);
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String value = resultSet.getString(columnName);
        //Integer[] integers = objectMapper.readValue(value, Integer[].class);
        return transfer(value);
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int index) throws SQLException {
        String value = resultSet.getString(index);
        return transfer(value);
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int index) throws SQLException {
        String value = callableStatement.getString(index);
        return transfer(value);
    }

    private Integer[] transfer(String value){
        Integer[] integers = new Integer[0];
        if (value == null || "".equals(value)){
            return integers;
        }
        try {
            integers = objectMapper.readValue(value, Integer[].class);
        } catch (JsonProcessingException e) {
            return integers;
            //e.printStackTrace();
        }
        return integers;
    }
}
