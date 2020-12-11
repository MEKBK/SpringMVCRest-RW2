<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2020/12/5
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>

    <json:array name="items" var="student" items="${students}">
        <json:object>
    <json:property name="id" value="${student.id}"/>
    <json:property name="name" value="${student.name}"/>
    <json:property name="studentId" value="${student.studentId}"/>
    <json:property name="gender" value="${student.gender}"/>
    <json:property name="birthday" value="${student.birthday}"/>
    <json:property name="created_time" value="${student.created_time}"/>
    <json:property name="updated_time" value="${student.updated_time}"/>
        </json:object>
    </json:array>

</json:object>
