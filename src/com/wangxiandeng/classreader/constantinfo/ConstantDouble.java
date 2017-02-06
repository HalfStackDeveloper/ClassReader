package com.wangxiandeng.classreader.constantinfo;

import com.wangxiandeng.classreader.ConstantInfo;
import com.wangxiandeng.classreader.basictype.U4;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class ConstantDouble extends ConstantInfo {
    public long highValue;
    public long lowValue;

    @Override
    public void read(InputStream inputStream) {
        highValue = U4.read(inputStream);
        lowValue = U4.read(inputStream);
    }
}
