package com.shan.xmldemo.xmllibrary.sax;

import com.shan.xmldemo.bean.Student;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by root on 17-2-4.
 */

public class SaxXml {
    public static List<Student> sax2xml(InputStream is) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        SaxHandler saxHandler = new SaxHandler();
        sp.parse(is, saxHandler);
        return saxHandler.getList();
    }
}
