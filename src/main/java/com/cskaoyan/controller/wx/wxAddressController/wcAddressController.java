package com.cskaoyan.controller.wx.wxAddressController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.UserAddress;
import com.cskaoyan.bean.wxvo.AddressDeleteVO;
import com.cskaoyan.bean.wxvo.UserAddressDetailVO;
import com.cskaoyan.bean.wxvo.UserAddressVO;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/address")
public class wcAddressController {

    @Autowired
    UserService userService;

    @RequestMapping("list")
    public BaseRespVo list() {
        List<UserAddressVO> userAddressVO = userService.queryUserAddress();
        System.out.println(userAddressVO);
        return BaseRespVo.ok(userAddressVO);
    }

    @RequestMapping("detail")
        public BaseRespVo detail(Integer id) {
            UserAddressDetailVO userAddressDetailVOVO = userService.queryUserAddressDetail(id);
            return BaseRespVo.ok(userAddressDetailVOVO);
        }

    @RequestMapping("save")
        public BaseRespVo save(@RequestBody UserAddress userAddress) {
            Integer id = userService.saveUserAddress(userAddress);
            return BaseRespVo.ok(id);
        }

    @RequestMapping("delete")
        public AddressDeleteVO delete(@RequestBody HashMap map) {
        Integer i = userService.deleteUserAddress(map);
        AddressDeleteVO addressDeleteVO = new AddressDeleteVO();
        return addressDeleteVO;
        }


}
