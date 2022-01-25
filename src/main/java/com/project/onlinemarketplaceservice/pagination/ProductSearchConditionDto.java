package com.project.onlinemarketplaceservice.pagination;

import lombok.Getter;

@Getter
public class ProductSearchConditionDto {

    private final Integer categoryId;
    private final String searchKeyword;
    private final String sort;
    private final Integer currentPageNum;
    private final Integer recordCountPerPage;
    private final Integer offsetNum;

    public ProductSearchConditionDto(Integer categoryId, String searchKeyword, String sort,
            int currentPageNum,
            int recordCountPerPage) {
        this.categoryId = categoryId;
        this.searchKeyword = searchKeyword;

        if (!sort.equals("date") && !sort.equals("price_asc") && !sort.equals("price_desc")) {
            this.sort = "date";
        } else {
            this.sort = sort;
        }

        if (currentPageNum < 1) {
            currentPageNum = 1;
        }

        if (recordCountPerPage != 20 && recordCountPerPage != 40 && recordCountPerPage != 60
                && recordCountPerPage != 80) {
            this.recordCountPerPage = 40;
        } else {
            this.recordCountPerPage = recordCountPerPage;
        }
        this.currentPageNum = currentPageNum;

        offsetNum = (currentPageNum - 1) * recordCountPerPage;
    }
}