<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<d:layout>

    <jsp:attribute name="head">
            <title>Quản lý thức uống</title>
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
                        <h1 class="page-title">Danh sách thức uống</h1>
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
                                            <th scope="col">Tên thức uống</th>
                                            <th scope="col">Giá</th>
                                            <th scope="col">Mô tả</th>
                                            <th scope="col">Trạng thái</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach varStatus="count" items="${requestScope['listDrink']}" var="drink">
                                <tr>
                                    <th scope="row">${count.count}</th>
                                    <td>${drink.name}</td>
                                    <td>${drink.price}</td>
                                    <td>${drink.desc}</td>
                                    <td>${drink.status}</td>
                                    <c:if test="${drink.getStatus().value == 1}">
                                        <td>
                                            <a href="/drinks?action=edit&id=${drink.id}" class="btn btn-warning">Sửa</a>
                                            <a href="#"  onclick="removeDrink(${drink.id})" class="btn btn-danger">Gỡ</a>

                                        </td>
                                    </c:if>
                                    <c:if test="${drink.getStatus().value != 1}">
                                            <td><a href="#" onclick="activeDrink(${drink.id})" class="btn btn-success">Mở</a>

                                            </td>
                                    </c:if>
                                </tr>
                                </c:forEach>
                                        </tbody>
                                    </table>
                                    <script>
                                        function removeDrink(id) {
                                            if (confirm("Bạn có chắc chắn muốn gỡ thức uống này ?") == true)
                                                window.location = "/drinks?action=remove&id="+id;
                                        }
                                    </script>
                                    <script>
                                        function activeDrink(id) {
                                            if (confirm("Bạn có chắc chắn muốn mở bán lại thức uống này ?") == true)
                                                window.location = "/drinks?action=active&id="+id;
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
                var x = document.getElementById("drink_manager");
                var y = document.getElementById("show_drink_manager");
                var z = document.getElementById("i_drink_manager");
                var ul = document.getElementById("ul_drink_manager");
                x.classList.add("subdrop");
                x.classList.add("active");
                ul.style.display = "block";
                y.classList.add("active");
                z.classList.replace("mdi-plus", "mdi-minus");
            };
        </script>
    </jsp:attribute>
</d:layout>