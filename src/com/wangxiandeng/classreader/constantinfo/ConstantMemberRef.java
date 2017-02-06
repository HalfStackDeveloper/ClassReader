package com.wangxiandeng.classreader.constantinfo;

import com.wangxiandeng.classreader.ConstantInfo;
import com.wangxiandeng.classreader.basictype.U2;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class ConstantMemberRef extends ConstantInfo{
    public int classIndex;
    public int nameAndTypeIndex;


    @Override
    public void read(InputStream inputStream) {
        classIndex= U2.read(inputStream);
        nameAndTypeIndex=U2.read(inputStream);
    }
}
