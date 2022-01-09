<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topbar">
    <!-- LOGO -->
    <div class="topbar-left">
        <div class="text-center">
            <a href="index.jsp" class="logo"
            ><img src="/assets/img/logo.png" alt="logo-img"
            /></a>
            <a href="index.jsp" class="logo-sm"
            ><img src="/assets/img/logo.png" alt="logo-img"
            /></a>
        </div>
    </div>
    <!-- Button mobile view to collapse sidebar menu -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <ul class="list-inline menu-left mb-0">
                <li class="float-left">
                    <button
                            class="button-menu-mobile open-left waves-light waves-effect"
                    >
                        <i class="mdi mdi-menu"></i>
                    </button>
                </li>
                <li class="hide-phone app-search float-left">
                    <form role="search" class="navbar-form">
                        <input
                                type="text"
                                placeholder="Search..."
                                class="form-control search-bar"
                        />

                        <a href="" class="btn-search"><i class="fa fa-search"></i></a>
                    </form>
                </li>
            </ul>

            <ul class="nav navbar-right float-right list-inline">
                <li class="dropdown d-none d-sm-block"></li>
                <li class="d-none d-sm-block">
                    <a
                            href="#"
                            id="btn-fullscreen"
                            class="waves-effect waves-light notification-icon-box"
                    ><i class="mdi mdi-fullscreen"></i
                    ></a>
                </li>

                <li class="dropdown">
                    <a
                            href=""
                            class="dropdown-toggle profile waves-effect waves-light"
                            data-toggle="dropdown"
                            aria-expanded="true"
                    >
                        <img
                                src="assets\images\users\avatar-1.jpg"
                                alt="user-img"
                                class="rounded-circle"
                        />
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li>
                            <p class="dropdown-item">Xin chào, ${sessionScope.username}</p>
                        </li>
                        <li>
                            <a href="/logout" class="dropdown-item">
                                Logout</a
                            >
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</div>
<!-- Top Bar End -->
<!-- ========== Left Sidebar Start ========== -->
<div class="left side-menu">
    <div class="sidebar-inner slimscrollleft">
        <div id="sidebar-menu">
            <ul>
                <li class="menu-title">Menu</li>
                <li>
                    <a href="/orders?action=create" class="waves-effect"
                    ><i class="mdi mdi-home"></i><span> Trang chủ </span></a
                    >
                </li>
                <c:if test="${sessionScope.role == 1}">
                    <!-- Quản lý nhân viên -->
                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect" id="staff_manager"
                        ><i class="mdi mdi-album"></i>
                            <span> Quản lý nhân viên </span>
                            <span class="float-right"><i class="mdi mdi-plus" id="i_staff_manager"></i></span
                            ></a>
                        <ul class="list-unstyled" id="ul_staff_manager">
                            <li id="show_staff_manager"><a href="/staffs">Hiển thị thông tin nhân viên</a></li>
                            <li id="create_staff_manager"><a href="/staffs?action=create">Thêm nhân viên mới</a></li>
                        </ul>
                    </li>
                    <!-- Kết thúc quản lý nhân viên -->
                    <!-- Quản lý thức uống -->
                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect" id="drink_manager">
                            <i class="mdi mdi-layers"></i>
                            <span> Quản lý thức uống </span><span class="float-right">
                    <i class="mdi mdi-plus" id="i_drink_manager"></i></span></a>
                        <ul class="list-unstyled" id="ul_drink_manager">
                            <li id="show_drink_manager"><a href="/drinks">Hiển thị thức uống</a></li>
                            <li id="create_drink_manager"><a href="/drinks?action=create">Thêm thức uống mới</a></li>
                        </ul>
                    </li>
                    <!-- Kết thúc Quản lý thức uống -->
                </c:if>
                <!-- Quản lý hóa đơn -->
                <li>
                    <a href="javascript:void(0);" class="waves-effect" id="order_manager">
                        <i class="mdi mdi-diamond"></i>
                        <span> Quản lý hóa đơn </span><span class="float-right">
                      <i class="mdi mdi-plus" id="i_order_manager"></i></span></a>
                    <ul class="list-unstyled" id="ul_order_manager">
                        <li><a href="/orders">Hiển thị thông tin hóa đơn</a></li>
                    </ul>
                </li>
                <!-- Kết thúc Quản lý hóa đơn -->
                <c:if test="${sessionScope.role == 1}">
                    <!-- Quản lý tài khoản đăng nhập -->
                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect" id="user_manager">
                            <i class="mdi mdi-table"></i><span> Quản lý tài khoản </span>
                            <span class="float-right"><i class="mdi mdi-plus" id="i_user_manager"></i></span></a>
                        <ul class="list-unstyled" id="ul_user_manager">
                            <li id="show_user_manager"><a href="/users">Hiển thị thông tin tài khoản</a></li>
                            <li id="create_user_manager"><a href="/users?action=create">Thêm tài khoản mới</a></li>
                        </ul>
                    </li>
                    <!-- Kết thúc Quản lý tài khoản đăng nhập -->
                </c:if>
                <!-- Kết thúc menu -->
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
    <!-- end sidebarinner -->
</div>
<!-- Left Sidebar End -->
<!-- Start right Content here -->