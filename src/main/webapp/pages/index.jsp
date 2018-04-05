<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="templates/header.jsp"/>

<div class="container">
    <div class="page-header">
        <h1 class="title_position">Test Project (Overview)</h1>
    </div>
    <br>
    <p class="lead">#TASK_1: Basic CRUD for tables: <a href="/books">Books</a> and <a href="/authors">Authors</a>
    </p>

    <br>
    <p class="lead">#TASK_2: <a href="/showAuthors">Show authors</a> which are older 55 years old and sort them by
        `born` column</p>
    <div id="showList">
        <table id="showAuthors">
            <thead>
            <tr>
                <th class="disable-sorting">#</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Born</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${showAuthors}" var="author">
                <tr>
                    <td>${author.id}</td>
                    <td>${author.name}</td>
                    <td>${author.gender}</td>
                    <td>${author.born}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
    <script type="text/javascript" charset="utf-8">
        $('#showAuthors').dataTable();
        $('#bookList').dataTable();
    </script>
<jsp:include page="templates/footer.jsp"/>