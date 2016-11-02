<%@page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<body>
<h2>Customer SignUp Form - JSR303 @Valid example</h2>

<form:form method="POST" modelAttribute="user"
            enctype="multipart/form-data">

       <div class="errorblock">      <p class="error">${error}</p>
       </div>
           <table>
            <tr>
                <td>Customer Name :</td>
                <td><form:input path="userName" /></td>
                <th> <form:errors path="userName" delimiter="," cssClass="error" /></th>
            </tr>
            <tr>
                <td><form:label path="userAge">userAge</form:label></td>
                <td><form:input path="userAge" /></td>
            </tr>
            <tr>
                <td><form:label path="userAddress">userAddress</form:label></td>
                <td><form:input path="userAddress" /></td>
                <th><form:errors path="userAddress" cssClass="error"/> </th>
            </tr>


            <tr>
                <input name="image" type="file"/> </td>
                <th><label for="image">Profile image</label> </th>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
