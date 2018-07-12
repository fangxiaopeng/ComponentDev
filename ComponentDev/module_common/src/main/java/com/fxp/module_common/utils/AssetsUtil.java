package com.fxp.module_common.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Title:       AssetsUtil
 * <p>
 * Package:     com.fxp.module_common.utils
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/11 下午7:35
 * <p>
 * Description: 操作assets目录下文件
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/11    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class AssetsUtil {

    /**
     * 读取assets目录下文件
     *
     * @param context
     * @param filePath 带后缀
     * @return
     */
    public static String readFile(Context context, String filePath) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getResources().getAssets();
        //使用IO流读取json文件内容
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath), "utf-8"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }

    /**
     * 读取assets目录下文件
     *
     * @param context
     * @param filePath 带后缀
     * @return
     */
    public static String getFile(Context context, String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获得assets资源管理器
            AssetManager assetManager = context.getResources().getAssets();
            //使用IO流读取json文件内容
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(filePath), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 加载assets目录下的图片资源
     *
     * @param context
     * @param fileName 带后缀
     * @return
     */
    public static Bitmap getBitmap(Context context, String fileName) {
        InputStream is = null;
        try {
            is = context.getResources().getAssets().open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        return bitmap;
    }

    /**
     * 加载assets目录下音乐
     *
     * @param context
     * @param musicFileName 带后缀
     */
    public static void openMusic(Context context, String musicFileName) {
        AssetFileDescriptor afd = null;
        MediaPlayer mPlayer = new MediaPlayer();
        try {
            // 打开指定音乐文件,获取assets目录下指定文件的AssetFileDescriptor对象
            afd = context.getResources().getAssets().openFd(musicFileName);

            mPlayer.reset();
            // 使用MediaPlayer加载指定的声音文件。
            mPlayer.setDataSource(afd.getFileDescriptor(),
                    afd.getStartOffset(), afd.getLength());
            // 准备声音
            mPlayer.prepare();
            // 播放
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从assets目录中复制整个文件夹内容
     *
     * @param context Context
     * @param currentPath String  原文件路径
     * @param targetPath String  目标路径
     */
    public static void copyFilesFromAssets(Context context, String currentPath, String targetPath) {
        try {
            //获取assets目录下的所有文件及目录名
            String fileNames[] = context.getResources().getAssets().list(currentPath);
            if (fileNames.length > 0) {
                //如果是目录
                File file = new File(targetPath);
                file.mkdirs();
                //如果文件夹不存在，则递归
                for (String fileName : fileNames) {
                    copyFilesFromAssets(context, currentPath + "/" + fileName, targetPath + "/" + fileName);
                }
            } else {
                //如果是文件
                InputStream is = context.getResources().getAssets().open(currentPath);
                FileOutputStream fos = new FileOutputStream(new File(targetPath));
                byte[] buffer = new byte[1024];
                int byteCount = 0;
                //循环从输入流读取 buffer字节
                while ((byteCount = is.read(buffer)) != -1) {
                    //将读取的输入流写入到输出流
                    fos.write(buffer, 0, byteCount);
                }
                //刷新缓冲区
                fos.flush();
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param context
     * @param path    路径
     * @param extName 扩展名  "*"  表示返回所有
     * @return
     */
    public static ArrayList<File> getFileList(Context context, String path, String extName) {
        ArrayList<File> mFileList = new ArrayList<>();
        String[] fileNames;
        try {
            fileNames = context.getResources().getAssets().list(path);
            for (int i = 0; i < fileNames.length; i++) {
                if (fileNames[i].toLowerCase().endsWith(extName) || extName.equals("*")) {
                    File file = new File(fileNames[i]);
                    mFileList.add(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mFileList;
    }

}
