package com.home.shardingjdbcdemo.controller;

import com.home.shardingjdbcdemo.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
  private   OrderDao orderDao;
    @RequestMapping("/test")
    public void testInsert001(){
        orderDao.insertOrder(new BigDecimal(3),3L,"SUCCESS");
    }

    @RequestMapping("/query")
    public void query(){
        List<Long> ids = new ArrayList<>();
        ids.add(461245936329293824L);
        List<Map> maps = orderDao.selectOrderbyIds(ids);
        System.out.println(maps);
    }
}
