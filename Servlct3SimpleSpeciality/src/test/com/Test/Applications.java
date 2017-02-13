package com.Test;

import com.Test.AsyncTest.AsyncConfig;
import com.Test.AsyncTest.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by han on 2016/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AsyncConfig.class)
public class Applications {

    @Autowired
    Task task;


    @Test
    public void test() throws Exception{
        long start =System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while (true){
            if(task1.isDone() && task2.isDone() &&task3.isDone()){
                break;
            }
            Thread.sleep(1000);
        }
        long end=System.currentTimeMillis();
        System.out.println("任务全部完成 总耗时"+(end-start));


    }
}
