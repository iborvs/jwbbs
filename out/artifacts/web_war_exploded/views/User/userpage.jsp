<%--
  Created by IntelliJ IDEA.
  User: iborvs
  Date: 2019/7/16
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp"%>
<head>
    <script src="../../resources/js/jquery-2.1.4.min.js"></script>
    <script src="../../resources/js/popper.min.js"></script>
    <script src="../../resources/js/jquery.slides.min.js"></script>
    <script src="../../resources/js/main.js"></script>
    <script src="../../resources/js/cropper.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
    <script src="../../resources/js/jquery.form.min.js"></script>
    <script src="../../resources/js/avatar.js"></script>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../resources/css/main.css" rel="stylesheet" type="text/css">
    <link href="../../resources/css/cropper.min.css" rel="stylesheet" type="text/css">
    <title>用户信息</title>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div class="d-md-none col-12">
                </div>
                <div class="col">
                    <div class="row">
                        <div class="mx-auto user-info ">
                            <div id="profile">
                                <%@ include file="usrInfo.jsp"%>
                                <form action="/user" method="POST" enctype="application/x-www-form-urlencoded" id="userinfo-form">
                                    <div class="row">
                                        <div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2">
                                            <div class="form-group">
                                                <label for="nickname">用户ID</label>
                                                <input type="text" name="username" id="username" class="form-control nickname-input">
                                                <label for="nickname">昵称</label>
                                                <input type="text" name="nickname" id="nickname" class="form-control nickname-input">
                                                <label for="nickname">qq</label>
                                                <input type="text" name="qq" id="qq" class="form-control nickname-input">
                                                <label for="nickname">email</label>
                                                <input type="text" name="email" id="email" class="form-control nickname-input">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mx-auto">
                                        <input class="btn btn-success" type="button" name="submit" value="保存" onclick="update()">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function update(){
        $.post(
            '${pageContext.request.contextPath}/action/UsrInfoUpdate',
            $("#userinfo-form").serialize(),
            function(response,status,xhr) {
                if(response!=null){
                    alert(response);
                    if( response.indexOf("success") != -1 ){
                        alert("修改成功!");
                    }
                    else {
                        alert("修改失败！");
                    }
                }
                else{
                    alert("失去连接,请检查网络");
                }
            }
        );
    }
</script>
<%@ include file="../footer.jsp"%>
</body>
</html>
