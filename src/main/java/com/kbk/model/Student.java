package com.kbk.model;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Integer studentId;
    private Integer gender;
    private Date birthday;
    private long created_time;
    private long updated_time;
    public Student(){

    }

    public Student(Integer id, String name,Integer studentId,Integer gender,Date birthday,long created_time,long updated_time){
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.gender = gender;
        this.birthday = birthday;
        this.created_time = created_time;
        this.updated_time = updated_time;
    }

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public long getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(long updated_time) {
        this.updated_time = updated_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //    /**
//     * @Override 的作用是：如果想重写父类的方法，比如toString()方法的话，
//     * 在方法前面加上@Override 系统可以帮你检查方法的正确性。
//     *
//     *  toString 方法会返回一个“以文本方式表示”此对象的字符串。
//     * @return
//     */


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", created_time=" + created_time +
                ", updated_time=" + updated_time +
                '}';
    }

}
