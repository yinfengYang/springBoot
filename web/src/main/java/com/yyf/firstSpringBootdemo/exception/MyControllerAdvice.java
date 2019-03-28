package com.yyf.firstSpringBootdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局异常捕获
     * @param e
     * @return
     */

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception e){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",-1);
        map.put("msg",e.getMessage());
        return map;
    }

    /**
     * 自定义异常模块
     * @param e
     * @return
     */

    @ResponseBody
    @ExceptionHandler(value = StudentException.class)
    public Map<String,Object> errorHandler(StudentException e){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        return map;
    }

}
