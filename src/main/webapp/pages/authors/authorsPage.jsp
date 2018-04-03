<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li class="active">Authors</li>
    </ol>
    <br>
    <br>
    <form action="/authors/create" class="form-horizontal" method="post">
        <%--accept-charset="UTF-8--%>">
        <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputName" placeholder="Name of books" name="name">
            </div>
        </div>
        <div class="form-group">
            <label for="inputGender" class="col-sm-2 control-label">Gender</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputGender" placeholder="Gender" name="gender">
            </div>
        </div>
        <div class="form-group">
            <label for="inputBorn" class="col-sm-2 control-label">Born</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="inputBorn" placeholder="Born" name="born">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Create</button>
            </div>
        </div>
    </form>
</div>

<jsp:include page="../templates/footer.jsp"/>