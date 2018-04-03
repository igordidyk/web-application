<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li><a href="/authors">Authors</a></li>
        <li class="active">Editing authors</li>
    </ol>
    <br>
    <br>

    <form action="/authors/update" class="form-horizontal" method="post" >
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Name of books" name="name"  value="${authorsInfo.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-2 control-label">Gender</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gender" placeholder="Gender" name="gender" value="${authorsInfo.gender}" >
            </div>
        </div>
        <div class="form-group">
            <label for="born" class="col-sm-2 control-label">Born</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="born" placeholder="Born" name="born" value="${authorsInfo.born}">
            </div>
        </div>
        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">Born</label>
            <div class="col-sm-10">
                <input type="hidden" class="form-control" id="id" placeholder="Born" name="id" value="${authorsInfo.id}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Update</button>
            </div>
        </div>
    </form>
</div>

<jsp:include page="../templates/footer.jsp"/>