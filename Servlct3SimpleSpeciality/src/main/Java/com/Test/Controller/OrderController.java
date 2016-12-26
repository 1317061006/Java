package com.Test.Controller;

import com.Test.Dao.NOSQL.Redis.RedisRepository;
import com.Test.Exception.OrderNotFoundException;
import com.Test.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by han on 2016/12/21.
 */
@RestController
@RequestMapping("order-api")
public class OrderController {

    @Autowired
    RedisRepository redis;

    @RequestMapping(value = "preVersionOrder/{id}")
    public ResponseEntity<Order> countyResponse(@PathVariable String id) {
        Order order = redis.find(id);
        HttpStatus status = order != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Order>(order,status);
    }


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    Order orderResponse(@PathVariable String id) throws OrderNotFoundException {
        Order order = redis.find(id);
        if(order==null) throw new OrderNotFoundException(id);
        return order;
    }



    @RequestMapping(value = "/saveorder",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Order> saveOrder(  Order o,UriComponentsBuilder
            ucb) {
        Order order= redis.save(o);
        HttpHeaders headers = new HttpHeaders();
        System.out.println("saveOrder......");
        URI locationUrl = ucb.path(String.valueOf(o.getId())).
                build().toUri();
        headers.setLocation(locationUrl);
        return new ResponseEntity<Order>(order
                ,headers,HttpStatus.CREATED);
    }




}
