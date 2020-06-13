package com.example.admin.server;


import com.alibaba.fastjson.JSON;
import org.apache.http.client.utils.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class TestWebController {

    @GetMapping("/api")
    public  Map test(){
        Map map=new HashMap<String,String>();
        map.put("1","2");
        return map;
    }

    @GetMapping("/queryTime")
    public  String queryTime(){
        String nowDate = DateUtils.formatDate(new Date(), DateUtils.PATTERN_ASCTIME);
        return JSON.toJSONString(nowDate);
    }


}
