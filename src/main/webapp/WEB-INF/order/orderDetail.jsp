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
                        <h1 class="page-title">Chi tiết hóa đơn</h1>
                    </div>
                </div>
                <div class="page-content-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col text-left"><p class="text-success">Ngày tạo: ${requestScope['orderInfo'].createAt}</p></div>
                            <div class="col text-right"><p class="text-success">Người tạo: ${requestScope['orderInfo'].idUser}</p></div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <table class="table">
                                        <thead class="thead-light">
                                        <tr>
                                            <th>STT</th>
                                            <th scope="col">Danh sách thức uống</th>
                                            <th scope="col">Đơn giá (VNĐ)</th>
                                            <th scope="col">Số lượng</th>
                                            <th scope="col">Thành tiền (VNĐ)</th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach varStatus="count" items="${requestScope['listDetail']}"
                                                   var="list">
                                <tr>
                                    <th scope="row">${count.count}</th>
                                    <td>${list.name}</td>
                                    <td>${list.price}</td>
                                    <td>${list.quantity}</td>
                                    <td>${list.total}</td>
                                </tr>
                                </c:forEach>
                                        </tbody>
                                        <tfoot>
                                        <tr>
                                            <td colspan="5" class="text-right h4">
                                                <p class="title text-info">
                                                Tổng tiền: ${requestScope['orderInfo'].total} VNĐ
                                                </p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="5" class="text-center">
                                                <a href="/orders?action=create" class="btn-success btn">Xong</a>
                                            </td>
                                        </tr>
                                        </tfoot>
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