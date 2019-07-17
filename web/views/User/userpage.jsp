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
    <script src="../../resources/js/avatar.js"></script>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../resources/css/main.css" rel="stylesheet" type="text/css">
    <link href="../../resources/css/cropper.min.css" rel="stylesheet" type="text/css">
    <title>用户信息</title>
</head>
<body>
<div class="container">
    <div class="card userCard">
        <div class="card-body">
            <div class="row">
                <div class="d-md-none col-12">
                </div>
                <div class="col">
                    <div class="row">
                        <div class="mx-auto">
                            <div id="profile">
                                <%@ include file="usrInfo.jsp"%>
                                <form action="/user" method="POST" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="form-group">
                                                <label for="nickname">昵称</label>
                                                <input type="text" name="nickname" id="nickname" class="form-control nickname-input">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mx-auto">
                                        <input class="btn btn-success" type="submit" name="submit" value="保存">
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

<%@ include file="../footer.jsp"%>
</body>
</html>
