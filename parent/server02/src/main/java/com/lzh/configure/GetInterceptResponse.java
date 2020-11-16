package com.lzh.configure;

/*@ControllerAdvice
public class GetInterceptResponse implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //ServerHttpRequest不是传统的request，需要强转成ServletServerHttpRequest，然后再取出HttpServletRequest
        ServletServerHttpRequest req=(ServletServerHttpRequest)request;
        HttpServletRequest servletRequest = req.getServletRequest();
        servletRequest.getServletContext().setAttribute("response",body);
        servletRequest.setAttribute("response", body);
        return body;
    }
}*/
