package com.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class kettleTaskJob {
    private static Logger LOGGER = LogManager.getLogger(kettleTaskJob.class.getName());

    public void run() throws Exception {
        LOGGER.info("*****kettle定时任务运行开始******");
        /**
         * resources template/1111.ktr
         */
        String transFileName = "E:\\data-integration\\samples\\transformations\\meta-inject\\1111.ktr";
        KettleUtil.callNativeTrans(transFileName);
        LOGGER.info("*****kettle定时任务运行结束******");
    }

    public static void main(String[] args) throws Exception {
        kettleTaskJob job = new kettleTaskJob();
        job.run();
    }
}
