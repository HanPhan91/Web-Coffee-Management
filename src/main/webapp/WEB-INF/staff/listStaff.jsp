<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<d:layout>

    <jsp:attribute name="head">
            <title>Quản lý nhân viên</title>
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
                        <h1 class="page-title">Danh sách nhân viên</h1>
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
                                            <th scope="col">Tên nhân viên</th>
                                            <th scope="col">Vị trí làm việc</th>
                                            <th scope="col">Địa chỉ</th>
                                            <th scope="col">Trạng thái</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach varStatus="count" items="${requestScope['listStaff']}" var="staff">
                                <tr>
                                    <th scope="row">${count.count}</th>
                                    <td>${staff.getName()}</td>
                                    <td>${staff.getPosition()}</td>
                                    <td>${staff.getAddress()}</td>
                                    <td>${staff.getStatus()}</td>
                                    <c:if test="${staff.getStatus().value == 1}">
                                        <td>
                                            <a href="/staffs?action=edit&id=${staff.getId()}" class="btn btn-warning">Chỉnh
                                                sửa</a>
                                            <a href="#" onclick="deleteStaff(${staff.getId()})" class="btn btn-danger">Xóa</a>

                                        </td>
                                    </c:if>
                                    <c:if test="${staff.getStatus().value != 1}">
                                            <td></td>
                                    </c:if>
                                </tr>
                                </c:forEach>
                                        </tbody>

                                    </table>
                                    <script>
                                        function deleteStaff(id) {
                                            if (confirm("Bạn có chắc chắn muốn gỡ bỏ nhân viên này ?") == true)
                                                window.location = "/staffs?action=remove&id="+id;
                                        }
                                    </script>
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
                var x = document.getElementById("staff_manager");
                var y = document.getElementById("show_staff_manager");
                var z = document.getElementById("i_staff_manager");
                var ul = document.getElementById("ul_staff_manager");
                x.classList.add("subdrop");
                x.classList.add("active");
                ul.style.display = "block";
                y.classList.add("active");
                z.classList.replace("mdi-plus", "mdi-minus");
            };
        </script>
    </jsp:attribute>
</d:layout>