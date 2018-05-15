package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul 简单的过滤器，实现了在请求路由之前检查 HttpServletRequest 中是否有 accessToken 参数。
 *
 * @author huangfl
 * @since 2018/5/15
 */
public class AccessFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要被执行。实际应用时可利用该函数来指定过滤器的有效范围。
     *
     * @return 结果
     */
    @Override
    public boolean shouldFilter() {
        // false 不启用过滤
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        String accessToken = request.getParameter("accessToken");

        if (StringUtils.isBlank(accessToken)) {
            LOGGER.warn("access token is empty");
            // 令zuul过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        LOGGER.info("access token ok");
        return null;
    }
}
