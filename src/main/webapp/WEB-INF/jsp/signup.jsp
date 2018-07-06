<%-- 
    Document   : signup
    Created on : 24/05/2018, 10:31:12 PM
    Author     : lmung
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="card">
    <div class="card-header text-white bg-primary">
        Please signup
    </div>
    <div class="card-body">

        <!-- form:form modelAttribute="userCommand" -->
        <!-- esto es igual al anterior cuando se le asigna un nombre al parametro
        del modelo en la clase controladora -->
        <form:form modelAttribute="user">

            <form:errors cssClass="error"/>

            <div class="form-group">
                <form:label path="email">Email address</form:label>
                <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
                <form:errors path="email" cssClass="error" />
            </div>

            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" type="text" class="form-control" id="exampleInputName1" aria-describedby="nameHelp" placeholder="Enter name" />
                <form:errors path="name" cssClass="error" />
            </div>

            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" aria-describedby="PasswordHelp" placeholder="Enter password" />
                <form:errors path="password" cssClass="error" />
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>

<%@include file="includes/footer.jsp"%>

