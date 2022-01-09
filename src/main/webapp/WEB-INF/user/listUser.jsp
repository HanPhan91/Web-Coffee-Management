<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<d:layout>

    <jsp:attribute name="head">
            <title>Quản lý tài khoản</title>
    </jsp:attribute>
    <jsp:attribute name="content">
        <c:if test="${check == true}">
            <script>
                alert("Cập nhật thành công");
            </script>
        </c:if>

        <div class="content-page">
            <div class="content">
                <div class="">
                    <div class="page-header-title">
                        <h1 class="page-title">Danh sách tài khoản</h1>
                    </div>
                </div>
                <div class="page-content-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <table class="table">
                                        <thead class="thead-light">
                                        <tr>
                                            <th scope="col">STT</th>
                                            <th scope="col">Tên đăng nhập</th>
                                            <th scope="col">Mật khẩu</th>
                                            <th scope="col">Phân quyền</th>
                                            <th scope="col">Tên nhân viên</th>
                                            <th scope="col">Trạng thái</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach varStatus="count" items="${requestScope['userList']}" var="user">
                                <tr>
                                    <th scope="row">${count.count}</th>
                                    <td>${user.username}</td>
                                    <td><input class="form-control" type="password" value="${user.password}" readonly
                                               style="border: none;background-color: rgba(0,0,0,0);"></td>
                                    <td>${user.role}</td>
                                    <td>${user.staffName}</td>
                                    <td>${user.status}</td>
                                    <c:if test="${user.status.value == 1}">
                                        <td>
                                            <a href="/users?action=edit&id=${user.getId()}" class="btn btn-warning">Chỉnh
                                                sửa</a>
                                            <a href="#" onclick="deleteUser()" class="btn btn-danger">Xóa</a>
                                            <script>
                                                function deleteUser() {
                                                    if (confirm("Bạn có chắc chắn muốn gỡ bỏ nhân viên này ?") == true)
                                                        window.location = "/users?action=remove&id=${user.id}";
                                                }
                                            </script>
                                        </td>
                                    </c:if>
                                    <c:if test="${user.status.value != 1}">
                                            <td><a href="/users?action=active&id=${user.getId()}"
                                                   class="btn btn-success">Kích hoạt</a></td>
                                    </c:if>
                                </tr>
                                </c:forEach>
                                        </tbody>
                                    </table>
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