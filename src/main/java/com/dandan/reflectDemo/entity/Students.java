package com.dandan.reflectDemo.entity;

import java.util.Objects;

/**
 * 学生类
 */
public class Students {
    private String studentName;
    private Integer studentAge;
    private Integer sex;
    private  String hobby;

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public  String addr;

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public Integer getSex() {
        return sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Students(String studentName, Integer studentAge, Integer sex, String hobby) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.sex = sex;
        this.hobby = hobby;
    }
    Students(String studentName, Integer studentAge, Integer sex) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.sex = sex;
    }
    protected Students(String studentName, Integer studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public Students(String studentName) {
        this.studentName = studentName;
    }

    public Students() {
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", sex=" + sex +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    private String sayHi(String str){
        System.out.println("调用了私有有参方法："+str);
        return "xxx";
    }

    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }

    public static void main(String[] args) {
        System.out.println("调用了main方法");
    }

}
