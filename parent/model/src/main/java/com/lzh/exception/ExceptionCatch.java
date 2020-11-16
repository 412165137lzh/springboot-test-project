package com.lzh.exception;

import com.lzh.domain.base.CommonCode;
import com.lzh.domain.base.ResponseResult;
import com.lzh.domain.base.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionCatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //捕获MyException异常
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResponseResult myException(MyException e) {
        LOGGER.error("catch exception : {}\r\n exception: ", e.getMessage(), e);
        ResultCode resultCode = e.getResultCode();
        ResponseResult responseResult = new ResponseResult(resultCode);
        return responseResult;
    }

    //捕获所有其他Exception异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult allException(Exception e) {
        LOGGER.error("catch exception : {}\r\n exception: ", e.getMessage(), e);
        ResponseResult responseResult = new ResponseResult(CommonCode.FAIL);
        responseResult.setMessage(e.getMessage());
        return responseResult;
    }

}
