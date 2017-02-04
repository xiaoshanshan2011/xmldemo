package com.shan.xmldemo.xmllibrary.pull;

import android.util.Xml;

import com.shan.xmldemo.bean.Student;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-2-4.
 */

public class PullXml {
    public static List<Student> pull2xml(InputStream is) throws Exception {
        List<Student> list = null;
        Student student = null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is, "utf-8");
        int type = parser.getEventType();

        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                case XmlPullParser.START_TAG:
                    if ("students".equals(parser.getName())) {
                        list = new ArrayList<>();
                    } else if ("student".equals(parser.getName())) {
                        student = new Student();
                    } else if ("name".equals(parser.getName())) {
                        String sex = parser.getAttributeValue(null, "sex");
                        student.setSex(sex);
                        String name = parser.nextText();
                        student.setName(name);
                    } else if ("nickName".equals(parser.getName())) {
                        String nickName = parser.nextText();
                        student.setNickName(nickName);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("student".equals(parser.getName())) {
                        list.add(student);
                    }
                    break;
            }
            type = parser.next();
        }
        return list;
    }
}
