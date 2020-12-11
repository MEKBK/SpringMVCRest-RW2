package com.kbk.service.impl;
import com.kbk.dao.StudentDao;
import com.kbk.model.Student;
import com.kbk.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * service实现类
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> findStudentByCondition(Student student){
        return studentDao.findStudentByCondition(student);
    }

    @Override
    public Student selectById(int id){
        return studentDao.selectById(id);
    }

    @Override
    public List<Student> findStudentByIdList(List<Integer> idList){
        return studentDao.findStudentByIdList(idList);
    }

    @Override
    public List<Student> selectStudentByIdOrName(Student student){
        return studentDao.selectStudentByIdOrName(student);
    }

    @Override
    public boolean updateById(Student student){
        return studentDao.updateById(student);
    }

    @Override
    public int insertStudent(Student student){
        return studentDao.insertStudent(student);
    }

    @Override
    public boolean deleteById(Student student){
        return studentDao.deleteById(student);
    }
}
