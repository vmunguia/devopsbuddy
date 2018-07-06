<%-- 
    Document   : signup
    Created on : 24/05/2018, 10:31:12 PM
    Author     : lmung
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="card">
    <div class="card-header text-white bg-primary">
        Please signup
    </div>
    <div class="card-body">

        <form method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Name</label>
                <input name="name" type="text" class="form-control" id="exampleInputName1" aria-describedby="nameHelp" placeholder="Enter name">
            </div>

            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password" type="password" class="form-control" id="exampleInputPassword1" aria-describedby="PasswordHelp" placeholder="Enter password">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

<%@include file="includes/footer.jsp"%>

