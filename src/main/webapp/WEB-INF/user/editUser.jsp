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
                        <h1 class="page-title">Chỉnh sửa thông tin tài khoản</h1>
                    </div>
                </div>
                <div class="page-content-wrapper">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <c:if test="${requestScope['userEdit']  != null}">
                                    <form method="post" class="mt-5">
                                        <input type="text" name="id" value="${userEdit.id}" hidden>
                                        <input type="text" name="statusUser" value="${userEdit.status.value}" hidden>
                                        <input type="text" name="idStaff" value="${userEdit.idstaff}" hidden>
                                        <div class="form-group col-12 text-center">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Tên đăng nhập</span>
                                                </div>
                                                <input type="text" aria-label="Tên đăng nhập" class="form-control" readonly
                                                       name="username"
                                                       value="${userEdit.username}">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                        <span class="input-group-text font-weight-bold"
                                                              style="width: 100%">Mật khẩu</span>
                                                </div>
                                                <input type="password" aria-label="Mật khẩu" class="form-control"
                                                       name="password"
                                                       value="${userEdit.password}">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <label class="input-group-text font-weight-bold"
                                                           for="inputGroupSelect01" style="width: 100%">Phân quyền</label>
                                                </div>
                                                <select class="custom-select" id="inputGroupSelect01"
                                                        name="roleUser">
                                                    <option value="${userEdit.role.value}"
                                                            selected>${userEdit.role}</option>
                                                    <c:forEach items="${requestScope['role']}" var="role">
                                                        <c:if test="${role != userEdit.role}">
                                                            <option value="${role.value}">${role}</option>
                                                        </c:if>
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                        <span class="input-group-text font-weight-bold"
                                                              style="width: 100%">Tên nhân viên</span>
                                                </div>
                                                <input type="text" aria-label="Tên nhân viên" class="form-control" readonly
                                                       name="staffName"
                                                       value="${userEdit.staffName}">
                                            </div>
                                            <div class="mb-3 justify-content-center">
                                                <a href="/drinks" class="btn btn-warning">Trở lại</a>
                                                <input type="submit" class="btn btn-success" value="Lưu">
                                                <a href="#" onclick="deleteDrink()" class="btn btn-danger">Xóa</a>
                                                <script>
                                                    function deleteDrink() {
                                                        if (confirm("Bạn có chắc chắn muốn gỡ bỏ nhân viên này ?") == true)
                                                            window.location = "/drinks?action=remove&id=${drink.id}";
                                                    }
                                                </script>
                                            </div>
                                        </div>
                                    </form>
                                </c:if>
                                </div>
                            </div>
                        </div>
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
        var y = document.getElementById("show_user_manager");
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