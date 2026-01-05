package com.example.Quanlydonhang.dto.response;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse <T>{
    private List<T> result;
    private int size;
    private int page;
    private long totalItem;
    private long totalPage;

}
