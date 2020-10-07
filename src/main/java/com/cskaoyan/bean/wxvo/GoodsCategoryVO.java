package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.shop.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCategoryVO {

    /**
     * currentCategory : {"picUrl":"http://yanxuan.nosdn.127.net/79275db76b5865e6167b0fbd141f2d7e.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":9,"name":"家饰","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1011004,"iconUrl":"http://yanxuan.nosdn.127.net/ab0df9445d985bf6719ac415313a8e88.png","desc":"装饰你的家"}
     * brotherCategory : [{"picUrl":"http://yanxuan.nosdn.127.net/81f671bd36bce05d5f57827e5c88dd1b.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":4,"name":"床品件套","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1008009,"iconUrl":"http://yanxuan.nosdn.127.net/243e5bf327a87217ad1f54592f0176ec.png","desc":"MUJI等品牌制造商出品"},{"picUrl":"http://yanxuan.nosdn.127.net/f702dc399d14d4e1509d5ed6e57acd19.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":8,"name":"灯具","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1008016,"iconUrl":"http://yanxuan.nosdn.127.net/c48e0d9dcfac01499a437774a915842b.png","desc":"一盏灯，温暖一个家"},{"picUrl":"http://yanxuan.nosdn.127.net/1611ef6458e244d1909218becfe87c4d.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":5,"name":"地垫","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1010003,"iconUrl":"http://yanxuan.nosdn.127.net/83d4c87f28c993af1aa8d3e4d30a2fa2.png","desc":"家里的第\u201c五\u201d面墙"},{"picUrl":"http://yanxuan.nosdn.127.net/d6e0e84961032fc70fd52a8d4d0fb514.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":3,"name":"床垫","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1011003,"iconUrl":"http://yanxuan.nosdn.127.net/316afeb3948b295dfe073e4c51f77a42.png","desc":"承托你的好时光"},{"picUrl":"http://yanxuan.nosdn.127.net/79275db76b5865e6167b0fbd141f2d7e.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":9,"name":"家饰","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1011004,"iconUrl":"http://yanxuan.nosdn.127.net/ab0df9445d985bf6719ac415313a8e88.png","desc":"装饰你的家"},{"picUrl":"http://yanxuan.nosdn.127.net/d5d41841136182bf49c1f99f5c452dd6.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":7,"name":"家具","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1015000,"iconUrl":"http://yanxuan.nosdn.127.net/4f00675caefd0d4177892ad18bfc2df6.png","desc":"大师级工艺"},{"picUrl":"http://yanxuan.nosdn.127.net/dae4d6e89ab8a0cd3e8da026e4660137.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":10,"name":"宠物","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1017000,"iconUrl":"http://yanxuan.nosdn.127.net/a0352c57c60ce4f68370ecdab6a30857.png","desc":"抑菌除味，打造宠物舒适空间"},{"picUrl":"http://yanxuan.nosdn.127.net/bd17c985bacb9b9ab1ab6e9d66ee343c.png","deleted":false,"keywords":"","addTime":"2018-02-01 00:00:00","level":"L2","sortOrder":1,"name":"夏凉","pid":1005000,"updateTime":"2018-02-01 00:00:00","id":1036000,"iconUrl":"http://yanxuan.nosdn.127.net/13ff4decdf38fe1a5bde34f0e0cc635a.png","desc":"夏凉床品，舒适一夏"},{"picUrl":"http://182.92.235.201:8083/wx/storage/fetch/i75gax65w6u07j153txv.jpg","deleted":false,"keywords":"bb","addTime":"2020-10-02 13:50:20","level":"L2","sortOrder":50,"name":"bb","pid":1005000,"updateTime":"2020-10-02 14:11:05","id":1036008,"iconUrl":"http://182.92.235.201:8083/wx/storage/fetch/116mqu47805pd2lsf61s.jpg","desc":"bbb"},{"picUrl":"","deleted":false,"keywords":"111","addTime":"2020-10-04 15:31:50","level":"L2","sortOrder":50,"name":"111","pid":1005000,"updateTime":"2020-10-04 15:31:50","id":1036033,"iconUrl":"","desc":"1111"},{"picUrl":"http://182.92.235.201:8083/wx/storage/fetch/xjbgjwmvzmowbzsp8p33.png","deleted":false,"keywords":"好","addTime":"2020-10-04 18:16:09","level":"L2","sortOrder":50,"name":"好東西","pid":1005000,"updateTime":"2020-10-04 18:16:09","id":1036036,"iconUrl":"http://182.92.235.201:8083/wx/storage/fetch/1w4op53fhi1thuf3o7gv.jpg","desc":"1"}]
     * parentCategory : {"picUrl":"http://yanxuan.nosdn.127.net/e8bf0cf08cf7eda21606ab191762e35c.png","deleted":false,"keywords":"沙发","addTime":"2018-02-01 00:00:00","level":"L1","sortOrder":2,"name":"居家","pid":0,"updateTime":"2020-10-04 18:14:47","id":1005000,"iconUrl":"http://yanxuan.nosdn.127.net/a45c2c262a476fea0b9fc684fed91ef5.png","desc":"回家，放松身心"}
     */
    private Category currentCategory;
    private List<Category> brotherCategory;
    private Category parentCategory;

}
