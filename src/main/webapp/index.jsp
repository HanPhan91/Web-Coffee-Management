<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta content="Admin Dashboard" name="description" />
        <meta content="ThemeDesign" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <link rel="shortcut icon" href="/assets/images/favicon.ico" />
        <!--Morris Chart CSS -->
        <%--    <link rel="stylesheet" href="/assets/plugins/morris/morris.css" />--%>
        <link href="/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="/assets/css/style.css" rel="stylesheet" type="text/css" />
        <title>Đăng nhập</title>
    </head>
    <body>
        <!-- Begin page -->
        <div class="accountbg"></div>
        <div class="wrapper-page">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center m-t-0 m-b-15">
                        <img src="/assets/img/logo.png" alt="logo-img" width="100px">
                    </h3>
                    <h4 class="text-muted text-center m-t-0"><b>Đăng nhập</b></h4>
                    <form class="form-horizontal m-t-20" method="post" action="login">
                        <div class="form-group">
                            <div class="col-12">
                                <input class="form-control" type="text" required="" placeholder="Username" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-12">
                                <input class="form-control" type="password" required="" placeholder="Password" name="password">
                            </div>
                        </div>
                        <c:if test="${requestScope['check']== false}">
                            <p class="text-center text-warning">Tên đăng nhập hoặc mật khẩu không đúng</p>
                        </c:if>
                        <div class="form-group text-center m-t-40">
                            <div class="col-12">
                                <button class="btn btn-primary btn-block btn-lg waves-effect waves-light" type="submit">Log In</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- jQuery  -->
        <script src="assets\js\jquery.min.js"></script>
        <script src="assets\js\bootstrap.min.js"></script>
        <script src="assets\js\modernizr.min.js"></script>
        <script src="assets\js\detect.js"></script>
        <script src="assets\js\fastclick.js"></script>
        <script src="assets\js\jquery.slimscroll.js"></script>
        <script src="assets\js\jquery.blockUI.js"></script>
        <script src="assets\js\waves.js"></script>
        <script src="assets\js\wow.min.js"></script>
        <script src="assets\js\jquery.nicescroll.js"></script>
        <script src="assets\js\jquery.scrollTo.min.js"></script>

        <script src="assets\js\app.js"></script>

    </body>
</html>