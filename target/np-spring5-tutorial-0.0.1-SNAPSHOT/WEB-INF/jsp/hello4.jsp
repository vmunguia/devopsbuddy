<%-- 
    Document   : hello2
    Created on : 19/05/2018, 10:17:03 PM
    Author     : lmung
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1><spring:message code="hello"/>, ${name}!</h1>

<h2>This page was called returning the <I>ModelAndView</I> class in the controller.
<%@include file="includes/footer.jsp"%>
