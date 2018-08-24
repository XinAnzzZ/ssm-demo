package com.alibaba.xinan.common.handle;

import com.alibaba.xinan.common.enums.ResponseEnum;
import com.alibaba.xinan.common.util.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XinAnzzZ
 * @date 2018/8/21 11:47
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ModelAndView handleUnauthorizedException(UnauthorizedException e) {
        log.info("当前用户没有权限：" + e);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String asyncHeader = "X-Requested-With";
        String asyncValue = "XMLHttpRequest";
        ModelAndView modelAndView;
        if (asyncValue.equalsIgnoreCase(request.getHeader(asyncHeader))) {
            // 说明是异步请求，返回json数据
            modelAndView = new ModelAndView();
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            Map<String, Object> attributes = new HashMap<>(2);
            attributes.put("code", ResponseEnum.UNAUTHORIZED.getCode());
            attributes.put("msg", ResponseEnum.UNAUTHORIZED.getMsg());
            view.setAttributesMap(attributes);
            modelAndView.setView(view);
        } else {
            modelAndView = new ModelAndView("redirect: /common/unauthorized");
        }
        return modelAndView;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseJson handleRuntimeException(UnauthorizedException e) {
        log.info("未知异常：" + e);
        return ResponseJson.fail(ResponseEnum.UNKNOWN_ERROR);
    }
}
