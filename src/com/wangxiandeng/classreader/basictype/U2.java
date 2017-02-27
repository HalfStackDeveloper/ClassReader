package com.wangxiandeng.classreader.basictype;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wanginbeijing on 2017/1/24.
 */
public class U2 {
    public static int read(InputStream inputStream) {
    	
    	//bytes作为缓冲数组存储两个字节
    	//class文件中字符以U-16编码
        byte[] bytes = new byte[2];
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将缓冲数组中的两个字节解析成字符。
        int num = 0;
        for (int i= 0; i < bytes.length; i++) {
        	
            num <<= 8;   //num=num*2^8,左位移表示乘，右位移表示/,>>>表示无符号右移
            num |= (bytes[i] & 0xff);   // | 表示按位或运算    &表示按位与运算   
        }
        return num;
    }
}
