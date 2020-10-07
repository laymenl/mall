package com.cskaoyan.service.wx;


import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.wxvo.cart.*;
import com.cskaoyan.mapper.CartMapper;
import com.cskaoyan.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.math.BigDecimal;
import java.util.List;

@Service
public class WxCartServiceImpl implements WxCartService{

    @Autowired
    CartMapper cartMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public CartListBean index(String username) {
        Integer userId =getUserId(username);
        /*
        goodsCount: 42
        checkedGoodsCount: 42
        goodsAmount: 41258
        checkedGoodsAmount: 41258
        */
        CartTotal cartTotal = new CartTotal();
        cartTotal.setGoodsCount(cartMapper.getGoodsCount(userId));
        if (cartMapper.getCheckedGoodsCount(userId) != null) {
            cartTotal.setCheckedGoodsCount(cartMapper.getCheckedGoodsCount(userId));
        }else{
            cartTotal.setGoodsAmount(0);
        }
        cartTotal.setGoodsAmount(cartMapper.getGoodsAmount(userId));
        if (cartMapper.getCheckedGoodsAmount(userId) != null){
            cartTotal.setCheckedGoodsAmount(cartMapper.getCheckedGoodsAmount(userId));
        }else {
            cartTotal.setCheckedGoodsAmount(0);
        }

        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andUserIdEqualTo(userId);
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        CartListBean cartListBean = new CartListBean();

        cartListBean.setCartTotal(cartTotal);
        cartListBean.setCartList(carts);
        return cartListBean;
    }

    @Override
    public void update(Cart record) {
        Cart cart = cartMapper.selectByPrimaryKey(record.getId());
        //计算总价
        int price = cart.getPrice().intValue();
        short cartNum = cart.getNumber();
        short recNum = record.getNumber();
        BigDecimal finalPrice = BigDecimal.valueOf(price/cartNum*recNum);

        cart.setPrice(finalPrice);
        cart.setNumber(record.getNumber());
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andIdEqualTo(record.getId());
        cartMapper.updateByExampleSelective(cart,cartExample);
    }

    @Override
    public CartListBean checked(CartBO cartBO, String username) {
        Integer userId = getUserId(username);
        int isChecked = cartBO.getIsChecked();
        List<Integer> productIds = cartBO.getProductIds();
        for (Integer productId:productIds) {
            CartExample cartExample = new CartExample();
            cartExample.createCriteria().andUserIdEqualTo(userId).andProductIdEqualTo(productId);
            Cart record = new Cart();
            record.setChecked(isChecked == 1);
            cartMapper.updateByExampleSelective(record,cartExample);
        }
        return index(username);
    }

    @Override
    public CartListBean delete(CartBO cartBO, String username) {
        Integer userId = getUserId(username);
        List<Integer> productIds = cartBO.getProductIds();
        for (Integer productId:productIds) {
            CartExample cartExample = new CartExample();
            cartExample.createCriteria().andUserIdEqualTo(userId).andProductIdEqualTo(productId);
            cartMapper.deleteByExample(cartExample);
        }
        return index(username);
    }

    private Integer getUserId(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() >= 1 ? users.get(0).getId() : 0;
    }
}
