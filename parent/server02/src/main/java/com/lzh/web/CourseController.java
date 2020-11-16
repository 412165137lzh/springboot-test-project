package com.lzh.web;

import com.lzh.domain.base.CommonCode;
import com.lzh.domain.base.ResponseResult;
import com.lzh.domain.course.Course;
import com.lzh.domain.user.UserResult;
import com.lzh.exception.MyException;
import com.lzh.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("course")
@Api(value="course课程的相关文档",description="该页面管理接口，提供页面的增、删、改、查")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("getUser/{id}")
    @ResponseBody
    @ApiOperation("根据id获取user对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键id",required=true,paramType="path",dataType="String"),
    })
    public UserResult getUserById(@PathVariable String id){
        return courseService.getUserById(id);
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public Course getCourseById(@PathVariable Integer id){
//        int i = 1/0;
        Course course = courseService.getCourseById(id);
        return course;
    }

    @GetMapping("getCourseAndUser")
    @ResponseBody
    public ResponseResult getCourseAndUser(){
        Map map = courseService.getCourseAndUser4();
        ResponseResult<Map> mapResponseResult = new ResponseResult<>(CommonCode.SUCCESS,map);
        return mapResponseResult;
    }

    @GetMapping("getPic")
    public void getPic(HttpServletResponse response){
//        String java_version = System.getProperty("java.version");
//        String server_port = System.getProperty("server.port");
        File file = new File("test.png");
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("saveCourse")
    @ResponseBody
    public ResponseResult saveOrUpdateCourse(@RequestBody Course course) throws MyException {
        /*if (true){
            throw new MyException(CommonCode.FAIL_SUBMIT);
        }*/
//        int a = 1/0;
        courseService.saveOrUpdateCourse(course);
        ResponseResult responseResult = new ResponseResult<>(CommonCode.SUCCESS);
        return responseResult;
    }


    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "hahahahah";
    }

}
