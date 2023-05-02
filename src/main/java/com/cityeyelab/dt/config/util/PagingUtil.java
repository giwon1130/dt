package com.cityeyelab.dt.config.util;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class PagingUtil {

    public static void paging(Page<?> list, Model model, int limit) {

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = ((nowPage-1) / 9) * 9 + 1;
        int totalPage = Math.max(list.getTotalPages(), 1);
        int endPage = Math.min( (((nowPage-1) / 9) + 1) * 9, totalPage);

        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("limit", limit);
        model.addAttribute("totalPage", totalPage);
    }
}
