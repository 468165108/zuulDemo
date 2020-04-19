package com.example.admin.server;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
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
}
