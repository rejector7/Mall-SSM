package cn.jtruan.mallssm.component;

import cn.hutool.json.JSONUtil;

import cn.jtruan.mallssm.common.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当未登录或者token失效访问接口时，自定义的返回结果
 * Created by macro on 2018/5/14.
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        LOGGER.info("entry point: {}", authException.getMessage());
        response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}
