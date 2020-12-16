package edu.gdut.togethertime.filter;

import edu.gdut.togethertime.exception.ExceptionEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "userFilter", urlPatterns = {"/*"}, asyncSupported = true)
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getRequestURI().equals("/user/login")) {
            doFilter(request, response, chain);
        }
        String authorization = httpServletRequest.getHeader("Authorization");

        if (authorization == null) {
            throw ExceptionEnum.exception(ExceptionEnum.AUTH_ERROR);
        }
        //GDUT ToGetherTime name,userId
        Pattern pattern = Pattern.compile("^(GDUT){1} (ToGetherTime){1} .+");
        Matcher matcher = pattern.matcher(authorization);
        if (!matcher.matches()) {
            throw ExceptionEnum.exception(ExceptionEnum.AUTH_ERROR);
        }
        String attr = authorization.substring(18);

        int position = attr.indexOf(".");
        String username = attr.substring(0, position);
        String userId = attr.substring(position + 1);

        httpServletRequest.setAttribute("userId", userId);
        httpServletRequest.setAttribute("username", username);
        doFilter(request, response, chain);
    }
}
