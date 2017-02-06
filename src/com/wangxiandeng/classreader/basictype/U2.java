package com.wangxiandeng.classreader.basictype;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wanginbeijing on 2017/1/24.
 */
public class U2 {
    public static int read(InputStream inputStream) {
        byte[] bytes = new byte[2];
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num = 0;
        for (int i= 0; i < bytes.length; i++) {
            num <<= 8;
            num |= (bytes[i] & 0xff);
        }
        return num;
    }
}
