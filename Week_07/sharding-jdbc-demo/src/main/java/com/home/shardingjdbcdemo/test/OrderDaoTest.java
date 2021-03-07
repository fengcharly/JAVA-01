package com.home.shardingjdbcdemo.test;

import com.home.shardingjdbcdemo.ShardingJdbcDemoApplication;
import com.home.shardingjdbcdemo.dao.OrderDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcDemoApplication.class)
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;
    @Test
    public void testInsert001(){
        orderDao.insertOrder(new BigDecimal(1),3L,"SUCCESS");
    }

    @Test
    public void testInsertOrder(){
        for(int i=1;i<11;i++){
            orderDao.insertOrder(new BigDecimal(i),3L,"SUCCESS");
        }
        for(int i=1;i<11;i++){
            orderDao.insertOrder(new BigDecimal(i),4L,"SUCCESS");
        }
    }
    @Test
    public void testSelectOrderbyIds(){
        List<Long> ids = new ArrayList<>();
        ids.add(373771636085620736L);
        ids.add(373771635804602369L);
        List<Map> maps = orderDao.selectOrderbyIds(ids);
        System.out.println(maps);
    }
}
