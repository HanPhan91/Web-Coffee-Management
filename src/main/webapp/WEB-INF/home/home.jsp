<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<d:layout>
    <jsp:attribute name="head">
            <title>Trang chủ</title>
    </jsp:attribute>
    <jsp:attribute name="content">
        <div class="content-page">
            <div class="content">
                <div class="">
                    <div class="page-header-title">
                        <h1 class="page-title">Tạo đơn hàng</h1>
                    </div>
                </div>
                <div class="page-content-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6 col-sm-12">
                                <div class="card">
                                    <table class="table">
                                        <thead class="thead-light">
                                        <tr>
                                            <th scope="col">Tên thức uống</th>
                                            <th>Thêm</th>
                                        </tr>
                                        </thead>
                                        <tbody id="tb_drink">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="card">
                                    <form method="post">
                                        <table class="table">
                                            <thead class="thead-light">
                                            <tr>
                                                <th scope="col" style="width: 50%">Đã thêm</th>
                                                <th>Số lượng</th>
                                                <th>Xóa</th>
                                            </tr>
                                            </thead>
                                            <tbody id="cart">
                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <input type="text" value="${sessionScope.username}" hidden name="idU">
                                                <td colspan="3" class="text-center"><input type="submit" class="btn btn-success" disabled id="submit_cart" value="Tạo order"/></td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                let Products = [];
            </script>
            <c:forEach varStatus="count" items="${requestScope['listDrink']}" var="drink">
            <script>
                Products.push(new Product(${drink.id}, "${drink.name}", ${drink.price}));
            </script>
        </c:forEach>
            <script>
                showProduct();
            </script>

            <d:footer/>
        </div>
    </jsp:attribute>
</d:layout>