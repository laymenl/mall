package com.cskaoyan.service.wx;


import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.wxvo.cart.Cart;
import com.cskaoyan.bean.wxvo.cart.CartExample;
import com.cskaoyan.bean.wxvo.cart.CartListBean;
import com.cskaoyan.bean.wxvo.cart.CartTotal;
import com.cskaoyan.mapper.CartMapper;
import com.cskaoyan.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
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
        cartTotal.setCheckedGoodsCount(cartMapper.getCheckedGoodsCount(userId));
        cartTotal.setGoodsAmount(cartMapper.getGoodsAmount(userId));
        cartTotal.setCheckedGoodsAmount(cartMapper.getCheckedGoodsAmount(userId));

        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andUserIdEqualTo(userId);
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        CartListBean cartListBean = new CartListBean();

        cartListBean.setCartTotal(cartTotal);
        cartListBean.setCartList(carts);
        return cartListBean;
    }

    private Integer getUserId(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() >= 1 ? users.get(0).getId() : 0;
    }
}
