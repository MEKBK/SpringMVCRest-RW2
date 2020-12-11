package com.kbk.service;

import com.kbk.model.Student;
import com.kbk.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

// 让测试运行于spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 指定 Spring 配置文件所在的位置
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class StudentServiceTest {

    // 也可用 @Autowired
    @Resource
    private StudentServiceImpl studentService;

    /**
     *  查询的条件：有可能有ID，有可能有Name，也有可能有学号，还有可能是都有
     */
    @Test
    public void testFindStudentById() throws Exception {
        Student s = new Student();
        s.setId(1);
   //     s.setName("静夜思");
        System.out.println(studentService.findStudentByCondition(s));
    }

    /**
     *  根据id遍历结果集
     */
    @Test
    public void testFindStudentByIdList() throws Exception {
        List<Student> list = studentService.findStudentByIdList(Arrays.asList(1,4,5));

        for(Student student : list){
            System.out.println(student);
            System.out.println("---------");
        }
    }


    /**
     *
     *     当参数id有值时优先使用id查询
     *     当没有id时就去判断用户名是否有值，如果有值就根据用户名全配
     *     如果用户名也没有值，就是sql查询为空
     *
     */
    @Test
    public void testSelectStudentByIdOrName(){

        Student s = new Student();
        // s.setId(8);
        //  s.setName("孙悟空");
        List<Student> Students = studentService.selectStudentByIdOrName(s);
        for(Student student : Students){
            System.out.println(student);

        }
    }

    /**
     * 根据主键更新student
     */
    @Test
    public void testUpdateById() throws Exception {

        Student student = new Student();
        student.setId(6);
        student.setStudentId(20);
        student.setName("静夜思");
        student.setGender(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        student.setBirthday(sdf.parse("2008-01-08"));
        student.setCreated_time(System.currentTimeMillis());
        student.setUpdated_time(System.currentTimeMillis());
        boolean a =studentService.updateById(student);
        //输出用户信息
        System.out.println("是否成功修改:"+a);
        System.out.println(student);

    }

    /**
     *  添加用户
     */
    @Test
    public void testInsertStudent() throws Exception {

        Student student = new Student();
        student.setId(7);
        student.setStudentId(31);
        student.setName("任逍遥");
        student.setGender(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        student.setBirthday(sdf.parse("1995-08-15"));
        student.setCreated_time(System.currentTimeMillis());
        student.setUpdated_time(System.currentTimeMillis());
        studentService.insertStudent(student);
        // 得到插入数据的主键并将其打印出来
        System.out.println("index: "+student.getId());
    }

    /**
     *  删
     */
    @Test
    public void testDeleteId() throws Exception {

        Student student = new Student();
        student.setId(6);
        boolean a =studentService.deleteById(student);
        //输出用户信息
        System.out.println("是否成功删除："+a);
        System.out.println("删除" + student.getId() + "的数据");
    }

}
