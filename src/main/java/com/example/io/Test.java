package com.example.io;

import java.io.IOException;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/23 9:07
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("参数错误");
            System.exit(0);
        }

        String sourcePath = args[0];
        String targetPath = args[1];

        try {
            CopyUtil.handleCopy(sourcePath, targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
