package com.wangxiandeng.classreader.basicinfo.attribute;

import com.wangxiandeng.classreader.basictype.U2;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/26.
 */
public class ExceptionTable {
    public int startPc;
    public int endPc;
    public int handlerPc;
    public int catchType;

    public void read(InputStream inputStream) {
        startPc = U2.read(inputStream);
        endPc = U2.read(inputStream);
        handlerPc = U2.read(inputStream);
        catchType = U2.read(inputStream);
    }
}
