<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<d:layout>
    <jsp:attribute name="head">
            <title>Quản lý thức uống</title>
    </jsp:attribute>
    <jsp:attribute name="content">
        <div class="content-page">
            <div class="content">
                <link href="/assets/css/card_staff.css" rel="stylesheet" type="text/css"/>
                <div class="">
                    <div class="page-header-title">
                        <h1 class="page-title">Thêm thức uống mới</h1>
                    </div>
                </div>
                <div class="page-content-wrapper">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <c:if test="${requestScope['check'] == false}">
                                        <h4 class="title text-center text-info">Giá thức uống không đúng</h4>
                                    </c:if>
                                    <form method="post">
                                        <div class="form-group col-12 text-center">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Tên thức uống</span>
                                                </div>
                                                <input type="text" aria-label="Tên thức uống" class="form-control"
                                                       name="nameDrink"
                                                       value="">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Giá thức uống</span>
                                                </div>
                                                <input type="number" aria-label="Giá thức uống" class="form-control"
                                                       name="priceDrink"
                                                       value="">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend" style="width: 15%">
                                                    <span class="input-group-text font-weight-bold" style="width: 100%">Mô tả</span>
                                                </div>
                                                <input type="text" aria-label="Mô tả" class="form-control"
                                                       value="" name="descDrink">
                                            </div>
                                            <div class="mb-3 justify-content-center">
                                                <a href="/drinks" class="btn btn-warning">Trở lại</a>
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
        var x = document.getElementById("drink_manager");
        var y = document.getElementById("create_drink_manager");
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