package com.lzh.domain.course;

import com.lzh.domain.base.QueryResponseResult;
import com.lzh.domain.base.ResultCode;

import java.util.List;

public class CourseResponseResult extends QueryResponseResult<Course> {
    public CourseResponseResult(ResultCode resultCode, List<Course> list, long total) {
        super(resultCode, list, total);
    }
}
