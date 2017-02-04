package com.shan.xmldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.shan.xmldemo.bean.Student;
import com.shan.xmldemo.xmllibrary.pull.PullXml;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = ReadUtils.readIsAssets("xmlfile.xml");
        /*try {
            List<Student> list = DomXML.dom2xml(is);
            for (int i = 0; i < list.size(); i++) {
                Log.i("MainActivity", "onCreate: " + list.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*try {
            List<Student> list = SaxXml.sax2xml(is);
            for (int i = 0; i < list.size(); i++) {
                Log.i("MainActivity", "onCreate: " + list.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            List<Student> list = PullXml.pull2xml(is);
            for (int i = 0; i < list.size(); i++) {
                Log.i("MainActivity", "onCreate: " + list.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
