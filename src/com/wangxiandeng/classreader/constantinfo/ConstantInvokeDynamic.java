package com.wangxiandeng.classreader.constantinfo;

import com.wangxiandeng.classreader.ConstantInfo;
import com.wangxiandeng.classreader.basictype.U2;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class ConstantInvokeDynamic extends ConstantInfo {
    public int bootstrapMethodAttrIndex;
    public int nameAndTypeIndex;

    @Override
    public void read(InputStream inputStream) {
        bootstrapMethodAttrIndex = U2.read(inputStream);
        nameAndTypeIndex = U2.read(inputStream);
    }
}
