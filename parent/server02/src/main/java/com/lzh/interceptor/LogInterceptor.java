package com.lzh.interceptor;

import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class LogInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 方法前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration em = request.getParameterNames();
        //开始打印request数据
        logger.info("----------------RequestBegin----------------");
        //1打印请求 url
        logger.info("请求URL  :"+request.getRequestURL());
        //2打印 Http method
        logger.info("请求方式 :"+request.getMethod());
        //3打印 ip
        logger.info("IP       :"+request.getRemoteAddr());
        //4打印请求参数
        JSONObject data = new JSONObject();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            data.put(name,value);
        }
        logger.info("请求参数 :"+data);
        logger.info("----------------RequestEnd----------------");

        return true;
    }

    /**
     * 方法后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object resp_data = request.getServletContext().getAttribute("response");
        logger.info("<<<<<<<<<<<<<<< ResponseBegin >>>>>>>>>>>>>>>");
        logger.info("返回参数 :"+ JSON.toJSONString(resp_data));
        logger.info("<<<<<<<<<<<<<<< ResponseEnd >>>>>>>>>>>>>>>");
//        PrintWriter writer = response.getWriter();
//        System.out.println(writer);
    }

    /**
     * 视图后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
