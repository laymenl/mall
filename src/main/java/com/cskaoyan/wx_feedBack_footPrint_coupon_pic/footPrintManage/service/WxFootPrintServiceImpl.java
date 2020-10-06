package com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.service;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.GoodsExample;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.feedback.UserFeedback;
import com.cskaoyan.bean.footprint.UserFootPrint;
import com.cskaoyan.bean.footprint.UserFootPrintExample;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.UserFeedbackMapper;
import com.cskaoyan.mapper.UserFootPrintMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.bean.wxvo.UserInfoVO;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.feedBackManage.service.WxFeedBackService;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.bean.ListBean;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.bean.WxFootprintVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WxFootPrintServiceImpl implements WxFootPrintService {

    @Resource
    UserFootPrintMapper userFootPrintMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    GoodsMapper goodsMapper;


    @SneakyThrows
    @Override
    public ListBean list(Integer page, Integer size) {

        PageHelper.startPage(page, size);
        List<WxFootprintVo> wxFootprintVoList = new ArrayList<>();

        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);

        UserFootPrintExample userFootPrintExample = new UserFootPrintExample();
        userFootPrintExample.createCriteria().andUserIdEqualTo(user.getId());
        List<UserFootPrint> userFootPrints = userFootPrintMapper.selectByExample(userFootPrintExample);

        for (UserFootPrint userFootPrint : userFootPrints) {
            Goods goods = goodsMapper.selectByPrimaryKey(userFootPrint.getGoodsId());
            WxFootprintVo wxFootprintVo = new WxFootprintVo(goods.getBrief(), goods.getPicUrl(), userFootPrint.getAddTime(),
                    userFootPrint.getGoodsId(), goods.getName(), userFootPrint.getId(),
                    goods.getRetailPrice());
            wxFootprintVoList.add(wxFootprintVo);
        }


        PageInfo pageInfo = new PageInfo(wxFootprintVoList);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setFootprintList(wxFootprintVoList);
        listBean.setTotalPages(total);
        return listBean;
    }

    @Override
    public int delete(Integer id) {
        int deleteStatus = userFootPrintMapper.deleteByPrimaryKey(id);
        return deleteStatus;
    }
}
