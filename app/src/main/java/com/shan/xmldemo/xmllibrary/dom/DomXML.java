package com.shan.xmldemo.xmllibrary.dom;

import com.shan.xmldemo.bean.Student;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by root on 17-2-4.
 */

public class DomXML {

    public static List<Student> dom2xml(InputStream is) throws Exception {
        List<Student> list = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        NodeList nodelist = document.getElementsByTagName("student");
        for (int i = 0; i < nodelist.getLength(); i++) {
            Node node_student = nodelist.item(i);
            NodeList childNodes = node_student.getChildNodes();
            Student student = new Student();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                if ("name".equals(childNode.getNodeName())) {
                    String name = childNode.getNodeName();
                    student.setName(name);
                    NamedNodeMap map = childNode.getAttributes();
                    Node n = map.item(0);
                    student.setSex(n.getTextContent());
                } else if ("nickName".equals(childNode.getNodeName())) {
                    String nickName = childNode.getTextContent();
                    student.setNickName(nickName);
                }
            }
            list.add(student);
        }

        return list;
    }
}
