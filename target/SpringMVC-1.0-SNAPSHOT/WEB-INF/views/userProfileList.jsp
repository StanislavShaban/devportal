<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h1>UserProfileList</h1>
<div class="container-fluid">
    <div id = "delete-result">${result}</div>
    <c:forEach var="profiles" items="${userProfileList}">
        <div class="row" id = "${profiles.username}">
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive"/>
                        </div>
                        <div class="col-sm-6 col-md-8">
                            <h4>
                                    ${profiles.name} ${profiles.surname}</h4>
                            <small><cite title="San Francisco, USA">${profiles.country}<i
                                    class="glyphicon glyphicon-map-marker">
                            </i></cite></small>
                            <p>
                                <i class="glyphicon glyphicon-envelope"></i>${profiles.email}
                                <br/>
                                <i class="glyphicon glyphicon-globe"></i><a href="http://www.jquery2dotnet.com">www.jquery2dotnet.com</a>
                                <br/>
                                <i class="glyphicon glyphicon-gift"></i>${profiles.birthday}</p>
                            <!-- Split button -->
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <div class="btn-group" role="group" aria-label="...">
                                    <button id = "${profiles.username}" onClick="deleteUser(this.id);" type="button" class="btn btn-default">Delete</button>
                                    <button id = "${profiles.username}" onClick="editUser(this.id);"type="button" class="btn btn-default">Edit</button>
                                </div>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>