<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>
<div class="container">

    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li><a href="/books">Books</a></li>
        <li class="active">Books Editing</li>
    </ol>
    <br>
    <h3>Update books</h3>
    <br>
    <form action="/books/update" class="form-horizontal" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Name of books" name="name"
                       value="${booksInfo.name}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="published" class="col-sm-2 control-label">Published</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="published" placeholder="published" name="published"
                       value="${booksInfo.published}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="genre" class="col-sm-2 control-label">Genre</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="genre" placeholder="genre" name="genre"
                       value="${booksInfo.genre}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="rating" class="col-sm-2 control-label">Rating</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="rating" placeholder="rating" name="rating"
                       value="${booksInfo.rating}" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="hidden" class="form-control" id="id" name="id" value="${booksInfo.id}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Update books</button>
            </div>
        </div>
    </form>
    <br>
    <br>
</div>


<jsp:include page="../templates/footer.jsp"/>