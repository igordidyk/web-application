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
    <h3>Create authors</h3>

    <form action="/authors/create" class="form-horizontal" method="post">
        <%--accept-charset="UTF-8--%>
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
    <br>
    <br/>
    <h3>Show all authors</h3>
    <table id="authors">
        <thead>
        <tr>
            <th class="disable-sorting">#</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Born</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${authorsList}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.gender}</td>
                <td>${author.born}</td>
                <td><p><a href="/authors/edit-${author.id}">edit</a>
                    <a href="/authors/delete-${author.id}">delete</a></p>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script type="text/javascript" charset="utf-8">
        $('#authors').dataTable();
    </script>
</div>

<jsp:include page="../templates/footer.jsp"/>