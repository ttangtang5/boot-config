package com.example.io;

import java.io.*;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/23 9:07
 * @Version 1.0
 **/
public class CopyUtil {

    /**
     * 判断文件是否存在
     *
     * @param path 文件路径
     * @return 源文件存返回true 否则false
     */
    public static boolean pathExist(String path) {
        if (new File(path).exists()) {
            return true;
        }

        return false;
    }

    /**
     * 判断文件父路径是否存在
     *
     * @param path 文件路径
     */
    public static void parentPathExist(String path) {
        File parentFile = new File(path).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    /**
     * 文件复制
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     * @throws IOException
     */
    public static void handleCopy(String sourcePath, String targetPath) throws IOException {
        if (!pathExist(sourcePath)) {
            throw new IOException("源文件不存在");
        }

        parentPathExist(targetPath);

        copy(sourcePath, targetPath);
    }

    /**
     * 将sourcePath路径的文件复制至到targetFile路径上
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copy(String sourcePath, String targetPath) {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        copy(sourceFile, targetFile);
    }

    /**
     * 将sourceFile复制至到targetFile
     *
     * @param sourcePath 源文件
     * @param targetFile 目标文件
     */
    public static void copy(File sourcePath, File targetFile) {
        InputStream is = null;
        OutputStream os = null;
        try {
            long startTime = System.currentTimeMillis();

            is = new FileInputStream(sourcePath);
            os = new FileOutputStream(targetFile);

            byte[] data = new byte[2048];
            int len = 0;
            while ((len = is.read(data)) != -1) {
                os.write(data, 0, len);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("复制时间花费：" + (endTime - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
