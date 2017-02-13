package com.Test.JavaConfig.ConfigAssert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by han on 2016/12/18.
 */
public class ATask implements iATask {


    public void aTask() {

    }
    private static final Logger LOG = LoggerFactory.getLogger(ATask.class);

    public void execute( ) {

        if (LOG.isInfoEnabled()) {
            LOG.info("正午12点...");
        }
    }


}
