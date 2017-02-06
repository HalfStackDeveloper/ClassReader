package com.wangxiandeng.classreader;

import com.wangxiandeng.classreader.basictype.U1;

import java.io.InputStream;

/**
 * Created by wanginbeijing on 2017/1/24.
 */
public class ConstantPool {
    public int constant_pool_count;
    public ConstantInfo[] cpInfo;

    public ConstantPool(int count) {
        constant_pool_count = count;
        cpInfo = new ConstantInfo[constant_pool_count];
    }

    public void read(InputStream inputStream) {
        for (int i = 1; i < constant_pool_count; i++) {
            short tag = U1.read(inputStream);
            ConstantInfo constantInfo = ConstantInfo.getConstantInfo(tag);
            constantInfo.read(inputStream);
            cpInfo[i] = constantInfo;
            if (tag == ConstantInfo.CONSTANT_Double || tag == ConstantInfo.CONSTANT_Long) {
                i++;
            }
        }
    }
}
