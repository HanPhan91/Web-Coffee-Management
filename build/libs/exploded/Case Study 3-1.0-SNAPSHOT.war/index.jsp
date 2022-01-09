<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta content="Admin Dashboard" name="description" />
    <meta content="ThemeDesign" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Coffee Management</title>
    <link rel="shortcut icon" href="assets\images\favicon.ico" />
    <!--Morris Chart CSS -->
    <!-- <link rel="stylesheet" href="assets\plugins\morris\morris.css" />  Chặn chuột phải-->
    <link
      href="assets\css\bootstrap.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link href="assets\css\icons.css" rel="stylesheet" type="text/css" />
    <link href="assets\css\style.css" rel="stylesheet" type="text/css" />
  </head>

  <body class="fixed-left">
    <!-- Begin page -->
    <div id="wrapper">
      <!-- Top Bar Start -->
      <div class="topbar">
        <!-- LOGO -->
        <div class="topbar-left">
          <div class="text-center">
            <a href="index.jsp" class="logo"
              ><img src="assets\images\logo.png" alt="logo-img"
            /></a>
            <a href="index.jsp" class="logo-sm"
              ><img src="assets\images\logo_sm.png" alt="logo-img"
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
                    <a href="javascript:void(0)" class="dropdown-item">
                      Profile</a
                    >
                  </li>
                  <li>
                    <a href="javascript:void(0)" class="dropdown-item">
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
                <a href="index.jsp" class="waves-effect"
                  ><i class="mdi mdi-home"></i><span> Trang chủ </span></a
                >
              </li>
              <!-- Quản lý nhân viên -->
              <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect"
                  ><i class="mdi mdi-album"></i>
                  <span> Quản lý nhân viên </span>
                  <span class="float-right"><i class="mdi mdi-plus"></i></span
                ></a>
                <ul class="list-unstyled">
                  <li><a href="#">Hiển thị thông tin nhân viên</a></li>
                  <li><a href="#">Thêm nhân viên mới</a></li>
                </ul>
              </li>
              <!-- Kết thúc quản lý nhân viên -->
              <!-- Quản lý thức uống -->
              <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect">
                  <i class="mdi mdi-layers"></i>
                  <span> Quản lý thức uống </span><span class="float-right">
                    <i class="mdi mdi-plus"></i></span></a>
                <ul class="list-unstyled">
                  <li><a href="#">Hiển thị thức uống</a></li>
                  <li><a href="#">Thêm thức uống mới</a></li>
                </ul>
              </li>
              <!-- Kết thúc Quản lý thức uống -->
              <!-- Quản lý hóa đơn -->
              <li>
                <a href="#" class="waves-effect">
                    <i class="mdi mdi-diamond"></i>
                    <span> Quản lý hóa đơn </span><span class="float-right">
                      <i class="mdi mdi-plus"></i></span></a>
                    <ul class="list-unstyled">
                      <li><a href="#">Hiển thị thông tin hóa đơn</a></li>
                    </ul>
              </li>
              <!-- Kết thúc Quản lý hóa đơn -->
              <!-- Quản lý tài khoản đăng nhập -->
              <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect">
                    <i class="mdi mdi-table"></i><span> Quản lý tài khoản </span>
                    <span class="float-right"><i class="mdi mdi-plus"></i></span></a>
                <ul class="list-unstyled">
                  <li><a href="tables-basic.html">Hiển thị thông tin tài</a></li>
                  <li><a href="tables-basic.html">Thêm tài khoản mới</a></li>
                </ul>
              </li>
                <!-- Kết thúc Quản lý tài khoản đăng nhập -->

                <!-- Các phần chưa cần thiết -->
              <!-- <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect"
                  ><i class="mdi mdi-chart-pie"></i><span> Charts </span
                  ><span class="float-right"><i class="mdi mdi-plus"></i></span
                ></a>
                <ul class="list-unstyled">
                  <li><a href="charts-morris.html">Morris Chart</a></li>
                  <li><a href="charts-chartjs.html">Chartjs</a></li>
                  <li><a href="charts-flot.html">Flot Chart</a></li>
                  <li><a href="charts-other.html">Other Chart</a></li>
                </ul>
              </li> -->

              <!-- <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect"
                  ><i class="mdi mdi-opacity"></i> <span> Icons </span>
                  <span class="float-right"><i class="mdi mdi-plus"></i></span
                ></a>
                <ul class="list-unstyled">
                  <li><a href="icons-material.html">Material Design</a></li>
                  <li><a href="icons-ion.html">Ion Icons</a></li>
                  <li><a href="icons-fontawesome.html">Font awesome</a></li>
                  <li><a href="icons-themify.html">Themify Icons</a></li>
                </ul>
              </li> -->

              <!-- <li class="menu-title">Features</li> -->

              <!-- <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect"
                  ><i class="mdi mdi-map"></i><span> Maps </span
                  ><span class="float-right"><i class="mdi mdi-plus"></i></span
                ></a>
                <ul class="list-unstyled">
                  <li><a href="maps-google.html"> Google Map</a></li>
                  <li><a href="maps-vector.html"> Vector Map</a></li>
                </ul>
              </li> -->

              <!-- <li>
                <a href="calendar.html" class="waves-effect"
                  ><i class="mdi mdi-calendar"></i
                  ><span>
                    Calendar
                    <span class="badge badge-primary badge-pill float-right"
                      >NEW</span
                    ></span
                  ></a
                >
              </li> -->

              <!-- <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect"
                  ><i class="mdi mdi-assistant"></i><span> Layouts </span
                  ><span class="float-right"><i class="mdi mdi-plus"></i></span
                ></a>
                <ul class="list-unstyled">
                  <li><a href="layouts-collapse.html">Menu Collapse</a></li>
                  <li><a href="layouts-smallmenu.html">Menu Small</a></li>
                  <li><a href="layouts-menu2.html">Menu Style 2</a></li>
                </ul>
              </li> -->

              <!-- <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect"
                  ><i class="mdi mdi-google-pages"></i><span> Pages </span
                  ><span class="float-right"><i class="mdi mdi-plus"></i></span
                ></a>
                <ul class="list-unstyled">
                  <li><a href="pages-login.html">Login</a></li>
                  <li><a href="pages-register.html">Register</a></li>
                  <li><a href="pages-recoverpw.html">Recover Password</a></li>
                  <li><a href="pages-lock-screen.html">Lock Screen</a></li>
                  <li><a href="pages-blank.html">Blank Page</a></li>
                  <li><a href="pages-404.html">Error 404</a></li>
                  <li><a href="pages-500.html">Error 500</a></li>
                  <li><a href="pages-timeline.html">Timeline</a></li>
                  <li><a href="pages-invoice.html">Invoice</a></li>
                  <li><a href="pages-directory.html">Directory</a></li>
                </ul>
              </li> -->

              <!-- <li class="has_sub">
                <a href="javascript:void(0);" class="waves-effect"
                  ><i class="mdi mdi-share-variant"></i><span>Multi Menu </span
                  ><span class="float-right"><i class="mdi mdi-plus"></i></span
                ></a>
                <ul>
                  <li class="has_sub">
                    <a href="javascript:void(0);" class="waves-effect"
                      ><span>Menu Item 1.1</span>
                      <span class="float-right"
                        ><i class="mdi mdi-plus"></i></span
                    ></a>
                    <ul>
                      <li>
                        <a href="javascript:void(0);"
                          ><span>Menu Item 2.1</span></a
                        >
                      </li>
                      <li>
                        <a href="javascript:void(0);"
                          ><span>Menu Item 2.2</span></a
                        >
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a href="javascript:void(0);"><span>Menu Item 1.2</span></a>
                  </li>
                </ul>
              </li> -->

              <!-- Kết thúc menu -->
            </ul>
          </div>
          <div class="clearfix"></div>
        </div>
        <!-- end sidebarinner -->
      </div>
      <!-- Left Sidebar End -->

      <!-- Start right Content here -->

      <div class="content-page">
        <!-- Start content -->
        <div class="content">
          <div class="">
            <div class="page-header-title">
              <h4 class="page-title">Trang chủ</h4>
            </div>
          </div>

          <div class="page-content-wrapper">
            <div class="container-fluid">
              <div class="row"></div>

              <div class="row"></div>

              <div class="row"></div>
            </div>
            <!-- container-fluid -->
          </div>
          <!-- Page content Wrapper -->
        </div>
        <!-- content -->

        <footer class="footer">© H.A.N Coffee and Tea Management.</footer>
      </div>
      <!-- End Right content here -->
    </div>
    <!-- END wrapper -->

    <!-- jQuery  -->
    <script src="assets\js\jquery.min.js"></script>
    <script src="assets\js\popper.min.js"></script>
    <script src="assets\js\bootstrap.min.js"></script>
    <script src="assets\js\modernizr.min.js"></script>
    <script src="assets\js\detect.js"></script>
    <script src="assets\js\fastclick.js"></script>
    <script src="assets\js\jquery.slimscroll.js"></script>
    <script src="assets\js\jquery.blockUI.js"></script>
    <script src="assets\js\waves.js"></script>
    <script src="assets\js\wow.min.js"></script>
    <script src="assets\js\jquery.nicescroll.js"></script>
    <script src="assets\js\jquery.scrollTo.min.js"></script>

    <!--Morris Chart-->
    <script src="assets\plugins\morris\morris.min.js"></script>
    <script src="assets\plugins\raphael\raphael-min.js"></script>

    <script src="assets\pages\dashborad.js"></script>

    <script src="assets\js\app.js"></script>
  </body>
</html>
