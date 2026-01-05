package com.example.Quanlydonhang.config;

import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.enums.EnumsMess;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Max;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static io.swagger.v3.core.util.AnnotationsUtils.getAnnotation;

@Slf4j
@ControllerAdvice
public class ExceptionGlobal {

 @ExceptionHandler(RuntimeException.class)
 public ResponseEntity<?> faik(RuntimeException run){
    String a = run.getMessage();
    log.error("================> RuntimeException");
     return  new ResponseEntity<>(a,HttpStatus.BAD_REQUEST);
 }

 @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ResponseDao<?>> exc (MethodArgumentNotValidException MAV){
        FieldError fieldError = MAV.getBindingResult().getFieldError();
       String enumss= fieldError.getDefaultMessage();
        EnumsMess e = EnumsMess.valueOf(enumss);
        ResponseDao<?> err = ResponseDao.erorr1(e);
        log.error("=================>MethodArgumentNotValidException");
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
 }

}

