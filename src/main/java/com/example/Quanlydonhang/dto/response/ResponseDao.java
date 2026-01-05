package com.example.Quanlydonhang.dto.response;

import com.example.Quanlydonhang.enums.EnumsMess;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDao<T> {
   private String status;
    private int code;
   private String error;
   private String fomart;
   private T value;

    public static ResponseDao<?> ok() {
        return ResponseDao.builder()
                .status(EnumsMess.SUCCESS.getStatus())
                .code(EnumsMess.SUCCESS.getCode())
                .error("")
                .value(null)
                        .fomart(null).
                build();
    }
    public static <T> ResponseDao<?> ok(T obj){
        return ResponseDao.builder()
                .status(EnumsMess.SUCCESS.getStatus())
                .code(EnumsMess.SUCCESS.getCode())
                .error(null)
                .value(obj)
                .fomart(EnumsMess.SUCCESS.getMessFormat())
                .build();
    }
    public static <T> ResponseDao<?> erorr(){
        return ResponseDao.builder()
                .status(EnumsMess.ERORR.getStatus())
                .code(EnumsMess.ERORR.getCode())
                .error(EnumsMess.ERORR.getMesserorr())
                .value(null)
                .build();
    }
    public static <T> ResponseDao<?> erorr1(EnumsMess enumsMess){
        return ResponseDao.builder()
                .status(enumsMess.getStatus())
                .code(enumsMess.getCode())
                .error(enumsMess.getMesserorr())
                .fomart(enumsMess.getMessFormat())
                .build();
    }
}

