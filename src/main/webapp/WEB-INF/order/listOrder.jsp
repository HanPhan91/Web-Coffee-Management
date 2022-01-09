<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<d:layout>
    <jsp:attribute name="head">
            <title>Quản lý hóa đơn</title>
    </jsp:attribute>
    <jsp:attribute name="content">
        <div class="content-page">
            <div class="content">
                <div class="">
                    <div class="page-header-title">
                        <h1 class="page-title">Danh sách hóa đơn</h1>
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
                                            <th scope="col">Mã hóa đơn</th>
                                            <th scope="col">Ngày tạo</th>
                                            <th scope="col">Người tạo</th>
                                            <th scope="col">Tổng tiền (VNĐ)</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach varStatus="count" items="${requestScope['listOrder']}" var="order">
                                            <tr>
                                                <th scope="row">${count.count}</th>
                                                <td>${order.id}</td>
                                                <td>${order.createAt}</td>
                                                <td>${order.idUser}</td>
                                                <td>${order.total}</td>
                                                <td>
                                                    <a href="/orders?action=detail&id=${order.id}"
                                                       class="btn btn-success">Chi
                                                        tiết</a>
                                                </td>
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
                var x = document.getElementById("order_manager");
                var y = document.getElementById("show_order_manager");
                var z = document.getElementById("i_order_manager");
                var ul = document.getElementById("ul_order_manager");
                x.classList.add("subdrop");
                x.classList.add("active");
                ul.style.display = "block";
                z.classList.replace("mdi-plus", "mdi-minus");
            };
        </script>
    </jsp:attribute>
</d:layout>