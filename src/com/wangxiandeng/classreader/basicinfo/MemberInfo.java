package com.wangxiandeng.classreader.basicinfo;

import com.wangxiandeng.classreader.ConstantPool;
import com.wangxiandeng.classreader.basicinfo.attribute.AttributeInfo;
import com.wangxiandeng.classreader.basictype.U2;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class MemberInfo extends BasicInfo {
    public int accessFlags;
    public int nameIndex;
    public int descriptorIndex;
    public int attributesCount;
    public AttributeInfo[] attributes;

    public MemberInfo(ConstantPool cp) {
        super(cp);
    }

    @Override
    public void read(InputStream inputStream) {
        accessFlags = U2.read(inputStream);
        nameIndex = U2.read(inputStream);
        descriptorIndex = U2.read(inputStream);
        attributesCount = U2.read(inputStream);
        attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            AttributeInfo attributeInfo = AttributeInfo.getAttribute(mCp, inputStream);
            attributeInfo.read(inputStream);
            attributes[i] = attributeInfo;
        }
    }
}
