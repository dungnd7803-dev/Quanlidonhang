package com.example.Quanlydonhang.enums;

public enum EnumsMess {
    SUCCESS(00,"THÀNH CÔNG","THÀNH CÔNG","THÀNH CÔNG"),
    ERORR(100,"lỖI","lỖI","lỖI"),
    EMAIL(101,"lỖI","NHẬP EMAIL KHÔNG ĐÚNG ","VÍ DỤ : d123@gmail.com"),
    STRING_LENGTH_NAME(102,"LỖI","TÊN QUÁ DÀI","TÊN QUÁ DÀI" ),
    NOT_BLANK(103,"LỖI","KHÔNG ĐƯỢC BỎ TRỐNG","KHÔNG ĐƯỢC BỎ TRỐNG"),
    PHONE_NUMBER(104,"LỖI","NHẬP SAI SỐ ĐIỆN THOẠI","SAI SỐ ĐIỆN THOẠI"),
    PRODUCT_PRICE(105,"LỖI","GÍA SẢN PHẨM >1000","GÍA SẢN PHẨM >1000"),
    QUANTITY_PRODUCTS(106,"LỖI","SỐ LƯỢNG SẢN PHẨM > 1","SỐ LƯỢNG SẢN PHẨM > 1")
    ;
    private final int code;
   private final String status;
   private final String messerorr;
   private final String messFormat;

    EnumsMess(int code, String status, String messerorr, String messFormat) {
        this.code = code;
        this.status = status;
        this.messerorr = messerorr;
        this.messFormat = messFormat;
    }

    public String getMessWithFormat(Object... args) {
        return String.format(messFormat, args);
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMesserorr() {
        return messerorr;
    }

    public String getMessFormat() {
        return messFormat;
    }
}
