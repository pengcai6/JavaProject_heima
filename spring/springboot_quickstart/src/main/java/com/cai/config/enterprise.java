package com.cai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
@ConfigurationProperties(prefix = "enterprise")
public class enterprise {
private String name;
private Integer age;
private String[]  subjects;

    @Override
    public String toString() {
        return "enterprise{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subjects=" + Arrays.toString(subjects) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
