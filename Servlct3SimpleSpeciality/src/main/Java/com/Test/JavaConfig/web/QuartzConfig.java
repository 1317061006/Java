package com.Test.JavaConfig.web;

import com.Test.JavaConfig.ConfigAssert.ATask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


/**
 * Created by han on 2016/12/18.
 */
@Configuration
@EnableScheduling
public class QuartzConfig {

      @Bean
      public ATask job() {
        return new ATask();
     }


     //这里可以用通用方法接口加上泛型约束
    @Bean
    public MethodInvokingJobDetailFactoryBean jobDetail(ATask job) {
        MethodInvokingJobDetailFactoryBean m = new MethodInvokingJobDetailFactoryBean();
        m.setGroup("joy_work");
        m.setName("job_work_name");
        m.setConcurrent(false);
        m.setTargetObject(job);
        m.setTargetMethod("execute");
        return m;
    }


    @Bean
    public CronTriggerFactoryBean myTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setName("work_default");
        factoryBean.setGroup("work_group");
        factoryBean.setJobDetail(jobDetail.getObject());
        factoryBean.setCronExpression("0 0 12 * * ?");
        return factoryBean;
     }



      @Bean
    public SchedulerFactoryBean scheduler(CronTriggerFactoryBean myTrigger){
        SchedulerFactoryBean sched=new SchedulerFactoryBean();
        sched.setTriggers(myTrigger.getObject());
        return sched;
    }


}
