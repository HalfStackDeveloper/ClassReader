package com.wangxiandeng.classreader.basicinfo.instruction;

import java.io.*;
import java.util.HashMap;

/**
 * Created by wangxiandeng on 2017/1/26.
 */
public class InstructionTable {
    public static HashMap<Integer, String> mMap;


    public static String getInstruction(int bytecode) {
        if (mMap == null) {
            buildMap();
        }
        return mMap.get(bytecode);
    }

    public static void buildMap() {
        mMap = new HashMap<>();
        try {
            File file = new File("ins.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int i = 0;
            String line;
            Integer ins = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (i % 2 == 0) {
                    ins = Integer.parseInt(line.substring(2, 4), 16);
                } else if (i % 2 == 1) {
                    mMap.put(ins, line);
                }
                i++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
