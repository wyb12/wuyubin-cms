<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  


  	
<div class="container-fluid" style="background: white">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header" style="background: white">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="/resource/images/logo.png">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="background: white">
      <ul class="nav navbar-nav"  >
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
      </ul>
      
      <form class="navbar-form navbar-left" action="/index" method="get">
        <div class="form-group">
          <input type="text" name="key" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      
      <ul class="nav navbar-nav navbar-right">
       <li><a href="#"><img width="30px" height="30px" src="/resource/images/donghua.gif"/> </a></li>
        <c:choose>
	        <c:when  test="${sessionScope.SESSION_USER_KEY == null}">
	        	<li class="register"><a href="/user/register">注册</a></li>
	        	<li class="register"><a href="/user/login">登录</a></li>
	        </c:when>
	        <c:otherwise>
		        <li class="dropdown" id="clsdropDwon">
		          <a href="#" class="dropdown-toggle clsdropDwon" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
		          	${sessionScope.SESSION_USER_KEY.username}
		           <span class="caret"></span></a>
		         <ul class="dropdown-menu ">
		            <li><a href="/user/home">个人中心</a></li>
		            <li><a href="#">个人设置</a></li>
		            <li><a href="#">修改头像</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="/user/logout">退出登录</a></li>
		          </ul>
		        </li> 、
	        </c:otherwise>
        </c:choose>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  
  <style>
		
		#clsdropDwon a{
			color:blue;
		}
		
		#clsdropDwon a:hover{
		 	background:white;
			color:red;
			font-size:18px;
		 }
		 
		.register a:hover{
		 	background:white!important;;
			color:#FF9900!important;;
			font-size:18px!important;;
		}
		

</style>
 