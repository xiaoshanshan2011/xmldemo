package com.shan.xmldemo.xmllibrary.sax;

import com.shan.xmldemo.bean.Student;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-2-4.
 */

public class SaxHandler extends DefaultHandler {
    private List<Student> mList;
    private Student mStudent;
    private String tempS;

    @Override
    public void startDocument() throws SAXException {
        mList = new ArrayList<>();
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("student".equals(qName)) {
            mStudent = new Student();
        } else if ("name".equals(qName)) {
            String sex = attributes.getValue("sex");
            mStudent.setSex(sex);
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("student".equals(qName)) {
            mList.add(mStudent);
        } else if ("name".equals(qName)) {
            mStudent.setName(tempS);
        } else if ("nickName".equals(qName)) {
            mStudent.setNickName(tempS);
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempS = new String(ch,start,length);
        super.characters(ch, start, length);
    }

    public List<Student> getList(){
        return mList;
    }

}
