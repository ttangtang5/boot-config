package com.example.exceptiondemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description stopWatch计时器
 * @Author RLY
 * @Date 2019/5/20 17:06
 * @Version 1.0
 **/
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public StopWatch stopWatch;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        stopWatch = new StopWatch();
        stopWatch.start("handler");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        stopWatch.stop();
        stopWatch.start("viewResolver");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        stopWatch.stop();
        // stopWatch.getLastTaskTimeMillis() 获取最后一个计时任务的时间
        log.info("方法处理耗时：{}ms,视图解析耗时：{}ms", stopWatch.getTaskInfo()[0].getTimeMillis(), stopWatch.getTaskInfo()[1].getTimeMillis());
    }
}
