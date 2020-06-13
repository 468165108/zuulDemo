package com.example.zuul.filtter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sun.deploy.net.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParser;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Slf4j
@Component
public class LoggerEndFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return  FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String method = request.getMethod();//氢气的类型，post get ..
        Map<String, String> params = getParameterMap(request);
        log.info("请求参数{}", JSON.toJSON(params));
        String paramsStr = params.toString();//请求的参数
        long statrtTime = (long) context.get("startTime");//请求的开始时间
        Throwable throwable = context.getThrowable();//请求的异常，如果有的话
        request.getRequestURI();//请求的uri
        //HttpUtils.getIpAddress(request);//请求的iP地址
        context.getResponseStatusCode();//请求的状态
        long duration=System.currentTimeMillis() - statrtTime;//请求耗时
        log.info("thread+duration：请求耗时{}",duration);
        return null;
    }


    private Map<String, String> getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map<?, ?> properties = request.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<String, String>();
        Iterator<?> entries = properties.entrySet().iterator();

        Map.Entry<String, Object> entry;
        String name = "";
        String value = "";
        Object valueObj =null;
        while (entries.hasNext()) {
            entry = (Map.Entry<String, Object>) entries.next();
            name = (String) entry.getKey();
            valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

}
