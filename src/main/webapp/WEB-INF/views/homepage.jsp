<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Homepage</title>
	
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    rel="stylesheet">
	
	<style>
		.footer {
		    position: absolute;
		    bottom: 0;
		    width: 100%;
		    height: 60px;
		    background-color: #f5f5f5;
		}
		
		* {
		   font-size: 16px;
		   line-height: 2;
		}
	</style>
	
</head>

<body>

    <nav class="navbar navbar-default">

        <a href="/" class="navbar-brand">Login Demo</a>

        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout.do">Logout</a></li>
        </ul>

    </nav>

    <div class="container">
        <H1>Welcome ${fullname}</H1>

        Your Table are:
        
        <%-- <ol>
            <c:forEach items="${todos}" var="todo">
                <li>${todo.name}&nbsp;<a
                    href="/delete-todo.do?todo=${todo.name}">Delete</a></li>
            </c:forEach>
        </ol> --%>
        
        <input type="button" value="Show Table" id="showTable"/>
		<div class="table-responsive" id="tablediv">
		<table class="table" id="employeetable"> 
		    <tr> 
		        <th scope="col">EMPLOYEE_ID</th> 
		        <th scope="col">NAME</th> 
		        <th scope="col">PHONE_NUMBER</th> 
		        <th scope="col">SUPERVISORS</th> 
		        <th scope="col">USERNAME</th> 
		        <th scope="col">PASSWORD</th>          
		    </tr> 
		</table>
		</div>

        
    </div>

    <!-- <footer class="footer"> 
    </footer> -->

    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript">
		$(document).ready(function() {
		 $("#tablediv").hide();
		     $("#showTable").click(function(event){
		           $.get('PopulateTable',function(responseJson) {
		            if(responseJson!=null){
		                $("#employeetable").find("tr:gt(0)").remove();
		                var table1 = $("#employeetable");
		                $.each(responseJson, function(key,value) { 
		                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
		                        rowNew.children().eq(0).text(value['id']); 
		                        rowNew.children().eq(1).text(value['name']); 
		                        rowNew.children().eq(2).text(value['phone']); 
		                        rowNew.children().eq(3).text(value['supervisor']); 
		                        rowNew.children().eq(4).text(value['username']); 
		                        rowNew.children().eq(5).text(value['password']); 
		                        rowNew.appendTo(table1);
		                });
		                }
		            },'json');
		            $("#tablediv").show();          
		  });      
		});
	</script>

</body>

</html>
