package com.wangxiandeng.classreader.basicinfo.attribute;

import com.wangxiandeng.classreader.ConstantPool;
import com.wangxiandeng.classreader.basicinfo.instruction.InstructionTable;
import com.wangxiandeng.classreader.basictype.U1;
import com.wangxiandeng.classreader.basictype.U2;
import com.wangxiandeng.classreader.basictype.U4;

import java.io.InputStream;

/**
 * Created by wangxiandeng on 2017/1/25.
 */
public class CodeAttribute extends AttributeInfo {
    public int maxStack;
    public int maxLocals;
    public int codeLength;
    public short[] code;
    public int excepetionTableLength;
    public ExceptionTable[] exceptionTable;
    public int attributes_count;
    public AttributeInfo[] attributes;


    public CodeAttribute(ConstantPool cp, int nameIndex) {
        super(cp, nameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        length = (int) U4.read(inputStream);
        maxStack = U2.read(inputStream);
        maxLocals = U2.read(inputStream);
        codeLength = (int) U4.read(inputStream);
        code = new short[codeLength];
        for (int i = 0; i < codeLength; i++) {
            code[i] = U1.read(inputStream);
        }
        excepetionTableLength = U2.read(inputStream);
        exceptionTable = new ExceptionTable[excepetionTableLength];
        for (int i = 0; i < excepetionTableLength; i++) {
            ExceptionTable exceTable = new ExceptionTable();
            exceTable.read(inputStream);
            exceptionTable[i] = exceTable;
        }
        attributes_count = U2.read(inputStream);
        attributes = new AttributeInfo[attributes_count];
        for (int i = 0; i < attributes_count; i++) {
            AttributeInfo attr = AttributeInfo.getAttribute(mCp, inputStream);
            attr.read(inputStream);
            attributes[i] = attr;
        }

    }
}
