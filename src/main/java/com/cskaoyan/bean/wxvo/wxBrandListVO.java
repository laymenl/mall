package com.cskaoyan.bean.wxvo;

import lombok.Data;

import java.util.List;

@Data
public class wxBrandListVO {

        /**
         * totalPages : 6
         * brandList : [{"id":1046032,"name":"黑个","desc":"222","picUrl":"http://182.92.235.201:8083/wx/storage/fetch/gmenyi9n9fxpqikfng9m.jpg","floorPrice":7777},{"id":1046031,"name":"12313","desc":"132","picUrl":"","floorPrice":12331},{"id":1046029,"name":"夜行虎","desc":"抽2张牌","picUrl":"http://182.92.235.201:8083/wx/storage/fetch/5eczbg682pdlsz3moaao.jpg","floorPrice":6},{"id":1046028,"name":"小黑","desc":"11","picUrl":"","floorPrice":222},{"id":1046025,"name":"老婆","desc":"新垣结衣","picUrl":"http://182.92.235.201:8083/wx/storage/fetch/oz6quso6oso2vsxw1b8e.jpg","floorPrice":8.0E7},{"id":1046021,"name":"1","desc":"1","picUrl":"","floorPrice":1},{"id":1024000,"name":"WMF制造商","desc":"严选找寻德国百年高端厨具WMF的制造商，\n选择拥有14年经验的不锈钢生产工厂，\n为你甄选事半功倍的优质厨具。","picUrl":"http://yanxuan.nosdn.127.net/2018e9ac91ec37d9aaf437a1fd5d7070.png","floorPrice":9.9},{"id":1024001,"name":"OBH制造商","desc":"严选寻找OBH品牌的制造商，打造精致厨具，\n韩国独资工厂制造，严格质检，品质雕琢\n力求为消费者带来全新的烹饪体验。","picUrl":"http://yanxuan.nosdn.127.net/bf3499ac17a11ffb9bb7caa47ebef2dd.png","floorPrice":39},{"id":1024003,"name":"Stoneline制造商","desc":"严选找寻德国经典品牌Stoneline的制造商，\n追踪工艺，考量细节，亲自试用，\n为你甄选出最合心意的锅具和陶瓷刀，下厨如神。","picUrl":"http://yanxuan.nosdn.127.net/3a44ae7db86f3f9b6e542720c54cc349.png","floorPrice":9.9},{"id":1024006,"name":"KitchenAid制造商","desc":"严选寻访KitchenAid品牌的制造商，\n采用德国LFGB认证食品级专用不锈钢，\n欧式简约设计，可靠安心，尽享下厨乐趣。","picUrl":"http://yanxuan.nosdn.127.net/e11385bf29d1b3949435b80fcd000948.png","floorPrice":98}]
         */
        private long totalPages;
        private List<wxBrandList> brandList;

}
