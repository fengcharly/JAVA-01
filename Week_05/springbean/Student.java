package com.test.bsecond.xunlianying.week05.springbean;

import lombok.Data;
import lombok.ToString;

/**
 * 学生相关属性类
 */
@Data
@ToString
public class Student {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;


}
