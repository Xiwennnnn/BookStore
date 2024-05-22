package com.xiwen.utils;

public class SnowFlakeUtil {
    /**
     * 起始时间戳
     */
    private static long startTimeStamp;
    /**
     * 机器ID
     */
    private static long workID;
    /**
     * 数据中心ID
     */
    private static long dataCenterID;
    /**
     * 序列号
     */
    private static long sequence;
    /**
     * 数据中心ID移动位数
     */
    private static long dataCenterIndex;
    /**
     * 机器ID移动位数
     */
    private static long workIDIndex;
    /**
     * 时间戳移动位数
     */
    private static long timeStampIndex;
    /**
     * 记录上一次时间戳
     */
    private static long lastTimeStamp;
    /**
     * 序列号掩码
     */
    private static long sequenceMask;
    /**
     * 序列号长度12位
     */
    private static long sequenceLength;

    //初始化数据
    static{
        startTimeStamp = 1716205876912L;
        workID = 1L;
        dataCenterID = 1L;
        sequence = 0L;
        dataCenterIndex = 12L;
        workIDIndex = 17L;
        timeStampIndex = 22L;
        lastTimeStamp = -1L;
        sequenceLength = 12L;
        sequenceMask = (1L << sequenceLength) - 1L;
    }

    /**
     * 根据雪花算法获取ID
     * @return 返回long类型的唯一序列
     */
    public synchronized static long getID(){
        //获取当前时间
        long nowTimeStamp = System.currentTimeMillis();
        //预防时钟回拨，当前时间小于上一次记录时间
        if(nowTimeStamp < lastTimeStamp){
            throw new RuntimeException();
        }
        //相同时间的话 要序列号进制增量
        if(nowTimeStamp == lastTimeStamp){
            //防止溢出
            sequence = (sequence + 1) & sequenceMask;
            if(sequence == 0L){
                //溢出处理
                try{
                    Thread.sleep(1L);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
                //获取下一毫秒时间（有锁）
                nowTimeStamp = System.currentTimeMillis();
            }
        }else{
            //置0 之前序列号同一时间并发后自增 到这里说明时间不同了 序列号所以置0
            sequence = 0L;
        }
        //将当前的时间戳
        lastTimeStamp = nowTimeStamp;
        //当前时间和起始时间插值 左移22位
        long handleTimeStamp = (nowTimeStamp - startTimeStamp) << timeStampIndex;
        //数据中心数值 左移动 12位
        long handleDataCenterID = dataCenterID << dataCenterIndex;
        //机器ID数值 左移动17位 并且按位或
        long handleWorkID = workID << workIDIndex;
        long handleInstanceID = handleDataCenterID | handleWorkID;
        long ID = handleInstanceID | sequence | handleTimeStamp;
        return ID;
    }
}
