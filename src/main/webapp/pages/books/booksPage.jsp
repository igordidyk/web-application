<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li class="active">Books</li>
    </ol>
    <br>
    <br>
    <form action="/books/create" class="form-horizontal" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Name of books" name="name">
            </div>
        </div>
        <div class="form-group">
            <label for="published" class="col-sm-2 control-label">Published</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="published" placeholder="published" name="published">
            </div>
        </div>
        <div class="form-group">
            <label for="genre" class="col-sm-2 control-label">Genre</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="genre" placeholder="genre" name="genre">
            </div>
        </div>
        <div class="form-group">
            <label for="rating" class="col-sm-2 control-label">Rating</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="rating" placeholder="rating" name="rating">
            </div>
        </div>
        <div class="form-group">
            <label for="authorList" class="col-sm-2 control-label">Authors</label>
            <div class="col-sm-10">
                <select multiple class="form-control" id="authorList" name="authorOfBook">
                    <c:forEach items="${authorsList}" var="author">
                        <option value="${author.id}">${author.name}</option>
                    </c:forEach>
                </select>
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