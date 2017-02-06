package com.wangxiandeng.classreader.constantinfo;

import com.wangxiandeng.classreader.ConstantInfo;
import com.wangxiandeng.classreader.basictype.U2;
import com.wangxiandeng.classreader.basictype.U4;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class ConstantFloat extends ConstantInfo {
    public long value;

    @Override
    public void read(InputStream inputStream) {
        value = U4.read(inputStream);
    }
}
