package com.util.file;


public class kettleTaskJob {

    public void run() throws Exception {

        /**
         * resources template/1111.ktr
         */
        String transFileName = "E:\\data-integration\\FileStyle\\数据批量处理转换.ktr";
        KettleUtil.callNativeTrans(transFileName);
    }

    public static void main(String[] args) throws Exception {
        kettleTaskJob job = new kettleTaskJob();
        job.run();
    }
}
