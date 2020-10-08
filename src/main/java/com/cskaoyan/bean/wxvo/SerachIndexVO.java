package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.shop.keyword.Keyword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerachIndexVO {

    private Keyword defaultKeyword;
    private List<Keyword> hotKeywordList;
    private List<String> historyKeywordList;

}
