<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<d:layout>
    <jsp:attribute name="head">
            <title>Quản lý tài khoản</title>
    </jsp:attribute>
    <jsp:attribute name="content">
        <div class="content-page">
            <div class="content">
                <link href="/assets/css/card_staff.css" rel="stylesheet" type="text/css"/>
                <div class="">
                    <div class="page-header-title">
                        <h1 class="page-title">Thêm tài khoản mới</h1>
                    </div>
                </div>
                <div class="page-content-wrapper">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <c:if test="${requestScope['userFalse'] == false}">
                                        <p class="title text-center text-info ">Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác</p>
                                    </c:if>
                                    <c:if test="${requestScope['passFalse'] == false}">
                                        <p class="title text-center text-info ">Mật khẩu không trùng khớp, vui lòng nhập lại</p>
                                    </c:if>
                                    <form method="post">
                                        <div class="form-group col-12 text-center">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Tên đăng nhập</span>
                                                </div>
                                                <input type="text" aria-label="Tên đăng nhập" class="form-control"
                                                       name="username"
                                                       value="">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Mật khẩu</span>
                                                </div>
                                                <input type="password" aria-label="Tên đăng nhập" class="form-control"
                                                       name="password"
                                                       value="">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Nhập lại mật khẩu</span>
                                                </div>
                                                <input type="password" aria-label="Nhập lại mật khẩu" class="form-control"
                                                       name="password-repeat"
                                                       value="">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <label class="input-group-text font-weight-bold"
                                                           for="inputGroupSelect01" style="width: 100%">Nhân viên sử
                                                        dụng</label>
                                                </div>
                                                <select class="custom-select" id="inputGroupSelect01"
                                                        name="nameStaff">
                                                    <c:forEach items="${requestScope['listStaff']}" var="staff">
                                                            <option value="${staff.id}">${staff.name}</option>
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <label class="input-group-text font-weight-bold"
                                                           for="inputGroupSelect02" style="width: 100%">Phân
                                                        quyền</label>
                                                </div>
                                                <select class="custom-select" id="inputGroupSelect02"
                                                        name="role">
                                                    <c:forEach items="${requestScope['listRole']}" var="role">
                                                            <option value="${role.value}">${role}</option>
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="mb-3 justify-content-center">
                                                <a href="/staffs" class="btn btn-warning">Trở lại</a>
                                                <input type="submit" class="btn btn-success" value="Lưu">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <d:footer/>
        </div>
<script>
    window.onload = function () {
        var x = document.getElementById("user_manager");
        var y = document.getElementById("create_user_manager");
        var z = document.getElementById("i_user_manager");
        var ul = document.getElementById("ul_user_manager");
        x.classList.add("subdrop");
        x.classList.add("active");
        ul.style.display = "block";
        y.classList.add("active");
        z.classList.replace("mdi-plus", "mdi-minus");
    };
</script>
    </jsp:attribute>
</d:layout>