package com.zhou.index.comm.util;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-13 11:06
 **/
public class FileHelper {

    //输出流
    public static boolean fileOutputStreamFunc(String filePath,String str){
        OutputStreamWriter osr = null;
        OutputStream out = null;
        try {
            File f = mkdirParentFile(filePath);
            out = new FileOutputStream(f);
            //输出
            osr = new OutputStreamWriter(out);
            osr.write(str);
            osr.flush();
            osr.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (osr != null) {
                    osr.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //输入流
    public static String fileInputStreamFunc(String filePath){
        File file = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String line = "";
        String str = "";
        try {
            file = new File(filePath);
            isr = new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8"));
            br = new BufferedReader(isr);
            String[] array = null;
            while ((line = br.readLine()) != null) {
                str += line+"\n";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
    //获取文件后缀名
    public static String getFileSuffix(String fileName){
        String split[] = fileName.split("\\.",-1);
        String suffix = split[split.length-1];
        return suffix;
    }

    //去除文件后缀名
    public static String removeFileSuffix(String fileName){
        String split[] = fileName.split("\\.",-1);
        String suffix = split[split.length-1];
        return fileName.split("."+suffix,-1)[0];
    }

    //创建一个文件  若其父目录不存在 则创建
    public static File mkdirParentFile(String filePath){
        File f = new File(filePath);
        //判断父目录路径是否存在，即test.txt前的I:\a\b\
        if (!f.getParentFile().exists()) {
            try {
                //不存在则创建父目录
                f.getParentFile().mkdirs();
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;
    }

    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir
     *            要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            System.out.println("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            System.out.println("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

    //删除文件或者文件名
    public static boolean deleteFileOrDirectory(String filePath){
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + filePath + "不存在！");
        }else {
            if (file.isFile())
                return FileHelper.deleteFile(filePath);
            else
                return FileHelper.deleteDirectory(filePath);
        }
        return false;
    }

    //删除文件或者文件名
    public static boolean fileRename(String filePath,String newName){
        try {
            File oldFile = new File(filePath);
            if(!oldFile.exists())
            {
                oldFile.createNewFile();
            }
            System.out.println("修改前文件名称是："+oldFile.getName());
            String rootPath = oldFile.getParent();
            System.out.println("根路径是："+rootPath);
            File newFile = new File(rootPath + "/" + newName);
            System.out.println("修改后文件名称是："+newFile.getName());
            boolean flag = oldFile.renameTo(newFile);
            if(flag){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
            return flag;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
