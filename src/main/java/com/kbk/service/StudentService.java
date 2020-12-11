package com.kbk.service;

import com.kbk.model.Student;

import java.util.List;

/**
 * service层
 */

public interface StudentService {

    /**
     * 根据传入参数条件
     * @param student 查询的条件：有可能有ID，有可能有Name，也有可能有学号，还有可能是都有
     * @return
     */
    List<Student> findStudentByCondition(Student student);


    /**
     * 遍历结果集
     * @param idList
     * @return
     */
    List<Student> findStudentByIdList(List<Integer> idList);

    /**
     * 根据id查找学生
     * @param id
     * @return
     **/
    Student selectById(int id);


    /**
     *
     *
     * @Title: selectStudentByIdOrName
     *
     * @Description: 根据用户id或者用户名查询用户
     *
     * @param student
     * @return
     *
     */
    List<Student> selectStudentByIdOrName(Student student);


    /**
     *
     *
     * @Title: updateById
     *
     * @Description: 根据主键更新student
     *
     * @param student
     * @return
     *
     */
    boolean updateById(Student student);


    /**
     *
     *
     * @Title: insertStudent
     *
     * @Description: 插入学生
     *
     * @param student
     * @return int
     **/
    int insertStudent(Student student);


    /**
     *
     *
     * @Title: deleteById
     *
     * @Description: 根据id删除学生
     *
     * @param student
     * @return boolean
     **/
    boolean deleteById(Student student);


}
