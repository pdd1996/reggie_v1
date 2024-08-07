package com.reggie.common.domain.resp;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {

    private List<T> records;

    private Long total;

    private Integer page;

    private Integer pageSize;

}
