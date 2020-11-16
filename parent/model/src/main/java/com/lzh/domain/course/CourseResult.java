package com.lzh.domain.course;

import com.lzh.domain.base.ResponseResult;
import com.lzh.domain.base.ResultCode;

public class CourseResult extends ResponseResult<Course> {

    public CourseResult(ResultCode resultCode) {
        super(resultCode);
    }

    public CourseResult(ResultCode resultCode, Course javaBean) {
        super(resultCode, javaBean);
    }
}
