package com.test.bsecond.xunlianying.week05.springbean;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过dom4j读取相应的xml文件
 */
public class Main {

    public static void main(String[] args) throws Exception {

        String path = "E:\\week05\\springbean\\student.xml";

        //获取文档对象
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File(path));

        Element rootElement = doc.getRootElement();
        // 获取根元素
        System.out.println("根元素名称:" + rootElement.getName());


        List<Student> studentList = new ArrayList<>();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {

            String id = element.attribute("id").getValue();
            String name = element.elementTextTrim("name");
            String age = element.elementTextTrim("age");

            // 将属性填充的到相应的类中
            Student student = new Student();
            student.setId(Long.valueOf(id));
            student.setName(name);
            student.setAge(Integer.valueOf(age));
            studentList.add(student);
        }

        for (Student student : studentList) {
            System.out.println("通过XML装载的Student详情: "+student.toString());
        }
    }
}
