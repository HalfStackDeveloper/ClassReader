package com.wangxiandeng.classreader.constantinfo;

import com.wangxiandeng.classreader.ConstantInfo;
import com.wangxiandeng.classreader.basictype.U2;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class ConstantClass extends ConstantInfo {
    public int nameIndex;

    @Override
    public void read(InputStream inputStream) {
        nameIndex = U2.read(inputStream);
    }
}
