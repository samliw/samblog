package com.sam.blog.component.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "page vo")
public class PageCommonVo {

    @ApiModelProperty(value = "页码")
    private Integer pageNumber;
    @ApiModelProperty(value = "页数")
    private Integer pageSize;
    @ApiModelProperty(value = "搜索名称")
    private String searchName;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
}
