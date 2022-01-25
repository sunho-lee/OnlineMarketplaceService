package com.project.onlinemarketplaceservice.pagination;

import com.project.onlinemarketplaceservice.dto.BaseProductDto;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaginationProductListDto {

    private Integer totalRecordCount; //총 레코드 개수
    private Integer recordCountPerPage; //페이지 당 레코드 개수
    private Integer currentPageNum; // 페이지 번호
    private Integer firstPage; // 보여지는 페이지 중 첫번째 페이지 번호
    private Integer lastPage; // 보여지는 페이지 중 마지막 페이지 번호
    private Boolean isPreButton; //현재 페이지번호가 가장 첫번째일 경우
    private Boolean isNextButton; //현재 페이지가 가장 마지막일 경우
    private List<BaseProductDto> products; //상품 목록

    public PaginationProductListDto(Integer totalRecordCount, List<BaseProductDto> products,
            Integer recordCountPerPage, Integer currentPageNum) {

        final int sizeOfPage = 5; //네비게이션에 보여지는 페이지 번호 개수
        this.totalRecordCount = totalRecordCount;
        this.products = products;
        this.recordCountPerPage = recordCountPerPage;

        //총 페이지 수 = ((총 글 개수 - 1) / 페이지 당 글 개수) + 1
        int totalPageCount =
                ((this.totalRecordCount - 1) / recordCountPerPage) + 1;
        //현재 페이지 번호가 총 페이지 수를 넘을 경우 마지막 페이지 번호를 반환
        this.currentPageNum = (currentPageNum > totalPageCount) ? totalPageCount : currentPageNum;
        //좌측에 보이는 첫번째 페이지 번호 = ((현재 페이지 번호 - 1) / 보여지는 페이지 크기 ) * 보여지는 페이지 크기 + 1
        this.firstPage = ((this.currentPageNum - 1) / sizeOfPage) * sizeOfPage + 1;
        //우측에 보이는 마지막 페이지 번호 (좌측에 보이는 첫번째 페이지 + 보여지는 페이지 크기 - 1) or 총 페이지 수 중에 더 작은 것
        this.lastPage = Math.min((this.firstPage + sizeOfPage - 1), totalPageCount);

        this.isPreButton = this.currentPageNum != 1;
        this.isNextButton = this.lastPage < totalPageCount;

    }
}
