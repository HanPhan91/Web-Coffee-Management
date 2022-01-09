<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<d:layout>
    <jsp:attribute name="head">
            <title>Quản lý nhân viên</title>
    </jsp:attribute>
    <jsp:attribute name="content">
        <div class="content-page">
            <div class="content">
                <link href="/assets/css/card_staff.css" rel="stylesheet" type="text/css"/>
                <div class="">
                    <div class="page-header-title">
                        <h1 class="page-title">Chỉnh sửa thông tin nhân viên</h1>
                    </div>
                </div>
                <div class="page-content-wrapper">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <c:if test="${requestScope['checkRegex'] == false }">
                                        <h4 class="title text-center text-info">Số điện thoại không đúng</h4>
                                    </c:if>
                                    <c:if test="${requestScope['staff']  != null}">
                                    <form method="post">
                                        <input type="text" name="id" value="${staff.id}" hidden>
                                        <input type="text" name="statusStaff" value="${staff.status.value}" hidden>
                                        <div class="form-group col-12 text-center">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Tên nhân viên</span>
                                                </div>
                                                <input type="text" aria-label="Tên nhân viên" class="form-control"
                                                       name="nameStaff"
                                                       value="${staff.name}">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <label class="input-group-text font-weight-bold"
                                                           for="inputGroupSelect01" style="width: 100%">Vị trí làm
                                                        việc</label>
                                                </div>
                                                <select class="custom-select" id="inputGroupSelect01"
                                                        name="positionStaff">
                                                    <option value="${staff.position.value}"
                                                            selected>${staff.position}</option>
                                                    <c:forEach items="${position}" var="ps">
                                                        <c:if test="${ps != staff.position}">
                                                            <option value="${ps.value}">${ps}</option>
                                                        </c:if>
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Địa chỉ</span>
                                                </div>
                                                <input type="text" aria-label="Địa chỉ" class="form-control"
                                                       value="${staff.address}" name="addressStaff">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Số điện thoại</span>
                                                </div>
                                                <input type="tel" aria-label="Địa chỉ" class="form-control"
                                                       value="${staff.phone}" name="phoneStaff" pattern="\d*">
                                            </div>
                                            <div class="mb-3 justify-content-center">
                                                <a href="/staffs" class="btn btn-warning">Trở lại</a>
                                                <input type="submit" class="btn btn-success" value="Lưu">
                                                <a href="#" onclick="deleteStaff()" class="btn btn-danger">Xóa</a>
                                                <script>
                                                    function deleteStaff() {
                                                        if (confirm("Bạn có chắc chắn muốn gỡ bỏ nhân viên này ?") == true)
                                                            window.location = "/staffs?action=remove&id=${staff.id}";
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