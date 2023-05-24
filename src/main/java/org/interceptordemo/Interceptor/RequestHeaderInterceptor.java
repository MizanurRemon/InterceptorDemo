package org.interceptordemo.Interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.interceptordemo.Handler.InvalidHeaderFieldException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//@Component
//public class RequestHeaderInterceptor extends WebRequestHandlerInterceptorAdapter {
//    public RequestHeaderInterceptor(WebRequestInterceptor requestInterceptor) {
//        super(requestInterceptor);
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return super.preHandle(request, response, handler);
//    }
//}

@Component
public class RequestHeaderInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(RequestHeaderInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getHeader("auth-key") == null) {
            throw new InvalidHeaderFieldException("invalid request", HttpStatus.FORBIDDEN);
        } else {

            String header = request.getHeader("auth-key");
            if(header.length()<6){
                throw new InvalidHeaderFieldException("invalid header", HttpStatus.FORBIDDEN);
            }else {
                logger.info("preHandle");
            }

        }
        return HandlerInterceptor.super.preHandle(request, response, handler);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //
        logger.info("postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //
        logger.info("aftercompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
