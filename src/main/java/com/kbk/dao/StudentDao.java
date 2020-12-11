package com.kbk.dao;


import com.kbk.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @Company
 *
 * 用户的持久层接口
 */
public interface StudentDao {
    /**
     * 根据传入参数条件
     * @param student 查询的条件：有可能有ID，有可能有Name，也有可能有学号，还有可能是都有
     * @return
     */
    List<Student> findStudentByCondition(Student student);


    /**
     * 根据传入参数条件
     * @param idList 查询的条件：有可能有ID，有可能有Name，也有可能有学号，还有可能是都有
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