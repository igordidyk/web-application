<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li class="active">Books</li>
    </ol>
    <br>
    <h3>Create books</h3>
    <br>
    <form action="/books/create" class="form-horizontal" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Name of books" name="name" required>
            </div>
        </div>
        <div class="form-group">
            <label for="published" class="col-sm-2 control-label">Published</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="published" placeholder="published" name="published" required>
            </div>
        </div>
        <div class="form-group">
            <label for="genre" class="col-sm-2 control-label">Genre</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="genre" placeholder="genre" name="genre" required>
            </div>
        </div>
        <div class="form-group">
            <label for="rating" class="col-sm-2 control-label">Rating</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="rating" placeholder="rating" name="rating" required>
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
                <button type="submit" class="btn btn-default">Create books</button>
            </div>
        </div>
    </form>

    <br/>
    <h3>Show books</h3>
    <br>
    <table id="books">
        <thead>
        <tr>
            <th class="disable-sorting">#</th>
            <th>Name</th>
            <th>Published</th>
            <th>Genre</th>
            <th>Rating</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${booksList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.published}</td>
                <td>${book.genre}</td>
                <td>${book.rating}</td>
                <td><p><a href="/books/edit-${book.id}">edit</a>
                    <a href="/books/delete-${book.id}">delete</a></p>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <script type="text/javascript" charset="utf-8">
        $('#books').dataTable();
    </script>
</div>

<jsp:include page="../templates/footer.jsp"/>