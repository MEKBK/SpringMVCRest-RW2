package com.kbk.controller;


import com.kbk.model.Student;
import com.kbk.rest.Restful;
import com.kbk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping是一个用来处理请求地址映射的注解，可用于类或者方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
@RequestMapping("Student")
public class StudentController {
    //@Autowired注解是按照类型（byType）装配依赖对象，默认情况下它要求依赖对象必须存在，如果允许null值，可以设置它的required属性为false。
    @Autowired
    private StudentService studentService;
    @Autowired
    private MessageSource messageSource;

    /**
     * post接口
     *
     * @param student
     * @return
     */

//    value:  指定请求的实际地址， 比如 /action/info之类。
//    method：  指定请求的method类型， GET、POST、PUT、DELETE等
//    consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
//    produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
//    params： 指定request中必须包含某些参数值是，才让该方法处理
//    headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求
    @RequestMapping(value = "/POSTStudent", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    //告诉spring-mvc框架  不进行视图跳转（不用跳到jsp去）   直接进行数据响应（直接返回当前数据）
    Map<String, Object> post(@RequestBody Student student) {
        //判断学生姓名是否为空
        if (student.getName().equals("")) {
            return Restful.set(404, messageSource.getMessage("name.null", null, null));
        } else {
            studentService.insertStudent(student);
            return Restful.set(200, "添加成功", student);
        }

    }

    /**
     * get接口
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/GETStudent/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> get(@PathVariable Integer id) {
        //判断学生是否存在
        Student student = studentService.selectById(id);
        if (null == student) {
            System.out.println("况博凯");
            return Restful.set(404, messageSource.getMessage("id.null", null, null));
        } else {
            System.out.println("魏思静");
            return Restful.set(200, "查找学生成功", student);
        }

    }

    /**
     * put接口
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/PUTStudent", method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody
    Map<String, Object> put(@RequestBody Student student) {
        //判断要更新的学生是否存在，存在就更新
        if (null == studentService.selectById(student.getId())) {
            return Restful.set(404, messageSource.getMessage("id.null", null, null));
        } else {
            studentService.updateById(student);
            return Restful.set(200, "更新数据成功");
        }
    }

    /**
     * delete接口
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/DELETEStudent/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public @ResponseBody
    Map<String, Object> delete(@PathVariable("id") int id) {
        //
        if (null == studentService.selectById(id)) {
            System.out.println("NULL");
            return Restful.set(404, messageSource.getMessage("delete.null", null, null));
        } else {
            Student student = new Student();
            student.setId(id);
            studentService.deleteById(student);
            return Restful.set(200, "删除数据成功");
        }
    }

    /**
     * 测试json传入数据
     */
    @RequestMapping(value = "/GETJsonTest", method = RequestMethod.GET)
    public ModelAndView jsonTest(ModelAndView mav) {
        List<Student> list = studentService.findStudentByIdList(Arrays.asList(1,4,5));
        System.out.println("==========================");
        System.out.println(list);
        System.out.println("==========================");
        //相当于request的setAttribut,在JSP页面中通过studentService.getAllStudent()获取数据。
        mav.addObject("students", list);
        //指定视图的位置
        mav.setViewName("JsonDisplay");
        return mav;
    }
}
