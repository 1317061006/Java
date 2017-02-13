package com.Test.Controller;

import com.Test.entity.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**模仿JS客户端 使用REST请求  只能一部分进行测试("其他部分未编写，并且由于CSRF保护 只能使用GET操作")
 *  做为Demo示例
 * Created by han on 2016/12/20.
 */
public class RestTest {

    private Profile fetchFacebookProfile(String id) {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://graph.facebook.com/{id}", Profile.class, id);
    }


    private Profile fetchFacebookProfile2(String id) {
        Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("id", id);
        RestTemplate rest = new RestTemplate();

        return rest.getForObject("http://graph.facebook.com/{id}", Profile.class, urlVariables);
    }


    private Order fetchOrder(String id) throws Exception {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Order> response = rest.getForEntity(
                "http://localhost:8080/order-api/{id}", Order.class, id);
        if (response.getStatusCode() == HttpStatus.NOT_MODIFIED) {
            throw new Exception("not modifiedException");
        }
        return response.getBody();
    }


    private void updateOrder(Order order) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/order-api/update" + order.getId();
        rest.put(URI.create(url), order);
    }

    private void updateOrder2(Order order) {
        RestTemplate rest = new RestTemplate();
        rest.put("http://localhost:8080/order-api/update/{id}", order, order.getId());
    }

    private void updateOrder3(Order order) {
        RestTemplate rest = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("id", order.getId());
        rest.put("http://localhost:8080/order-api/update/{id}", order, params);
    }


    private void delete(long id) {
        RestTemplate rest = new RestTemplate();
        rest.delete("http://localhost:8080/order-api/delete/{id}", id);
    }


    private Order postOrderForObject(Order order) {
        RestTemplate rest = new RestTemplate();
        return rest.postForObject("http://localhost:8080/order-api/saveorder", order, Order.class);
    }


    private Order postOrderForEntity(Order order) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Order> response = rest.postForEntity(
                "http://localhost:8080/order-api/saveorder", order, Order.class);
        Order order1 = response.getBody();
        URI url = response.getHeaders().getLocation();
        System.out.println(url);
        return order1;
    }

    private String postOrder(Order order) {
        RestTemplate rest = new RestTemplate();
        return rest.postForLocation("http://localhost:8080/order-api/saveorder", order).toString();
    }

    private void exchange(Order order) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Order> respons = rest.exchange("http://localhost:8080/order-api/{id}"
                , HttpMethod.GET, null, Order.class, order.getId());
        Order order1 = respons.getBody();
    }


    private void exchange2(Order order) {
        RestTemplate rest = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
        ResponseEntity<Order> orderResponseEntity= rest.exchange("http://localhost:8080/order-api/saveorder",
                HttpMethod.POST, requestEntity, Order.class);
        Order order1 = orderResponseEntity.getBody();
        System.out.println(order1);
    }


    private static void main(String[] args) throws Exception {
        RestTest restTest = new RestTest();
        Order order = restTest.fetchOrder("username");
        System.out.println(order);

     }
}
