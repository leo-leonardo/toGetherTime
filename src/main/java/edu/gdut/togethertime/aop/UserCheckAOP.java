package edu.gdut.togethertime.aop;

import edu.gdut.togethertime.exception.ExceptionEnum;
import edu.gdut.togethertime.model.query.BaseQueryCheck;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Order(1)
public class UserCheckAOP {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCheckAOP.class);

    @Pointcut("execution(* edu.gdut.togethertime.controller.*.*(*)) && args(query)")
    public void userPointcut(BaseQueryCheck query) {
    }

    @Before(value = "userPointcut(query)", argNames = "query")
    public void userCheck(BaseQueryCheck query) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ServletWebRequest servletWebRequest = new ServletWebRequest(httpServletRequest);

        //在filter中设置请求的用户信息，此处检查
//        Long userId = (Long) servletWebRequest.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);
//        String username = (String) servletWebRequest.getAttribute("username", RequestAttributes.SCOPE_REQUEST);

        String log = "接受请求：\n" +
                "\t请求地址：\n\t\t" + httpServletRequest.getRemoteHost() + "/" + httpServletRequest.getRemoteAddr() + "\n" +
                "\t请求目标：\n\t\t" + httpServletRequest.getRequestURI() + "\n" +
                "\t请求方式：\n\t\t" + httpServletRequest.getMethod() + "\n" +
                "\t请求协议：\n\t\t" + httpServletRequest.getProtocol();
        LOGGER.info(log);

//        if (userId == null) {
//            throw ExceptionEnum.exception(ExceptionEnum.AUTH_ERROR);
//        }
//        if (username == null) {
//            throw ExceptionEnum.exception(ExceptionEnum.AUTH_ERROR);
//        }
//
//        query.setUserId(userId);
//        query.setUsername(username);
    }
}
