package com.wangxiandeng.classreader.basicinfo.attribute;

import com.wangxiandeng.classreader.ConstantPool;
import com.wangxiandeng.classreader.basicinfo.BasicInfo;
import com.wangxiandeng.classreader.basictype.U1;
import com.wangxiandeng.classreader.basictype.U2;
import com.wangxiandeng.classreader.basictype.U4;
import com.wangxiandeng.classreader.constantinfo.ConstantUtf8;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class AttributeInfo extends BasicInfo {
    public int nameIndex;
    public int length;
    public short[] info;

    public static final String CODE = "Code";

    public AttributeInfo(ConstantPool cp, int nameIndex) {
    	
        super(cp);
        this.nameIndex = nameIndex;
    }

    @Override
    public void read(InputStream inputStream) {
        length = (int) U4.read(inputStream);
        info = new short[length];
        for (int i = 0; i < length; i++) {
            info[i] = U1.read(inputStream);
        }
    }

    public static AttributeInfo getAttribute(ConstantPool cp, InputStream inputStream) {
        int nameIndex = U2.read(inputStream);
        String name = ((ConstantUtf8) cp.cpInfo[nameIndex]).value;
        switch (name) {
            case CODE:
                return new CodeAttribute(cp, nameIndex);
        }
        return new AttributeInfo(cp, nameIndex);

    }
}
