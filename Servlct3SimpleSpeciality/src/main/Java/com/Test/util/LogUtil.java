package com.Test.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * Created by han on 2016/12/12.
 */
public class LogUtil {


    public static void main(String[] args) {
       Logger logger=LoggerFactory.getLogger(LogUtil.class);
        int [] array={1,2,3,4,5,6,7,8,9};
        int count=1;
         LogUtil.info(logger,()->"测试Log");

        logger.error("will not have something");
    }


    public static void info(Logger logger, Supplier<String> message) {
        if (logger.isInfoEnabled()) {
            logger.info(message.get());
        }
    }

    public static void infoIf(Logger logger, Supplier<Boolean> condition, Supplier<String> message) {
        if (condition.get()) {
            logger.info(message.get());
        }
    }

}
