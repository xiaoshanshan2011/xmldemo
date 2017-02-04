package com.shan.xmldemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取文件工具类
 * Created by 陈俊山 on 16-10-13.
 */

public class ReadUtils {

    public static Bitmap readAssets(String name) {
        try {
            InputStream is2 = MyApp.getInstance().getResources().getAssets().open(name);
            return BitmapFactory.decodeStream(is2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject readJsonAssets(String name) throws Exception {
        InputStream is = MyApp.getInstance().getResources().getAssets().open(name);
        StringBuffer buffer = new StringBuffer();
        byte[] b = new byte[1024];
        int n;
        while ((n = is.read(b)) != -1) {
            buffer.append(new String(b, 0, n));
        }
        JSONObject jsonObject = new JSONObject(buffer.toString());
        return jsonObject;
    }

    public static InputStream readIsAssets(String name) {
        try {
            InputStream is = MyApp.getInstance().getResources().getAssets().open(name);
            return is;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
