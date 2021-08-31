<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    
    <title>User | Remark Admin Template</title>
    
    <link rel="apple-touch-icon" href="/images/apple-touch-icon.png">
    <link rel="shortcut icon" href="/images/favicon.ico">
    
    <!-- Stylesheets -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-extend.min.css">
    <link rel="stylesheet" href="/css/site.min.css">
    
    <!-- Plugins -->
    <link rel="stylesheet" href="/css/animsition/animsition.css">
    <link rel="stylesheet" href="/css/asscrollable/asScrollable.css">
    <link rel="stylesheet" href="/css/switchery/switchery.css">
    <link rel="stylesheet" href="/css/intro-js/introjs.css">
    <link rel="stylesheet" href="/css/slidepanel/slidePanel.css">
    <link rel="stylesheet" href="/css/flag-icon-css/flag-icon.css">
        <link rel="stylesheet" href="/css/examples/pages/user.css">
    
    
    <!-- Fonts -->
    <link rel="stylesheet" href="/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="/fonts/brand-icons/brand-icons.min.css">
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,300italic'>
    
    <!--[if lt IE 9]>
    <script src="/js/html5shiv/html5shiv.min.js"></script>
    <![endif]-->
    
    <!--[if lt IE 10]>
    <script src="/js/media-match/media.match.min.js"></script>
    <script src="/js/respond/respond.min.js"></script>
    <![endif]-->
    
    <!-- Scripts -->
    <script src="/js/breakpoints/breakpoints.js"></script>
    <script>
      Breakpoints();
    </script>
  </head>
  <body class="animsition page-user">
    <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <nav class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega" role="navigation">
    
      <div class="navbar-header">
        <button type="button" class="navbar-toggler hamburger hamburger-close navbar-toggler-left hided"
          data-toggle="menubar">
          <span class="sr-only">Toggle navigation</span>
          <span class="hamburger-bar"></span>
        </button>
        <button type="button" class="navbar-toggler collapsed" data-target="#site-navbar-collapse"
          data-toggle="collapse">
          <i class="icon wb-more-horizontal" aria-hidden="true"></i>
        </button>
        <div class="navbar-brand navbar-brand-center site-gridmenu-toggle" data-toggle="gridmenu">
          <img class="navbar-brand-logo" src="/images/logo.png" title="Remark">
          <span class="navbar-brand-text hidden-xs-down"> Remark</span>
        </div>
        <button type="button" class="navbar-toggler collapsed" data-target="#site-navbar-search"
          data-toggle="collapse">
          <span class="sr-only">Toggle Search</span>
          <i class="icon wb-search" aria-hidden="true"></i>
        </button>
      </div>
    
      <div class="navbar-container container-fluid">
        <!-- Navbar Collapse -->
        <div class="collapse navbar-collapse navbar-collapse-toolbar" id="site-navbar-collapse">
          <!-- Navbar Toolbar -->
          <ul class="nav navbar-toolbar">
          <!-- MEMO: left menu fix -->
            <!-- <li class="nav-item hidden-float" id="toggleMenubar">
              <a class="nav-link" data-toggle="menubar" href="#" role="button">
                <i class="icon hamburger hamburger-arrow-left">
                  <span class="sr-only">Toggle menubar</span>
                  <span class="hamburger-bar"></span>
                </i>
              </a>
            </li> -->
            
          </ul>
          <!-- End Navbar Toolbar -->
    
          <!-- Navbar Toolbar Right -->
          <ul class="nav navbar-toolbar navbar-right navbar-toolbar-right">
            <li class="nav-item dropdown">
              <a class="nav-link navbar-avatar" data-toggle="dropdown" href="#" aria-expanded="false"
                data-animation="scale-up" role="button">
                <span class="avatar avatar-online">
                  <img src="/images/userLogo.png" alt="...">
                  <i></i>
                </span>
              </a>
              <div class="dropdown-menu" role="menu">
                <a class="dropdown-item" href="javascript:void(0)" role="menuitem"><i class="icon wb-user" aria-hidden="true"></i> Profile</a>
                <div class="dropdown-divider" role="presentation"></div>
                <a class="dropdown-item" href="javascript:void(0)" role="menuitem"><i class="icon wb-power" aria-hidden="true"></i> Logout</a>
              </div>
            </li>
            
            <li class="nav-item" id="toggleChat">
              <a class="nav-link" data-toggle="site-sidebar" href="javascript:void(0)" title="Chat"
                data-url="../site-sidebar.tpl">
                <i class="icon wb-chat" aria-hidden="true"></i>
              </a>
            </li>
          </ul>
          <!-- End Navbar Toolbar Right -->
        </div>
        <!-- End Navbar Collapse -->
    
        <!-- Site Navbar Seach -->
        <div class="collapse navbar-search-overlap" id="site-navbar-search">
          <form role="search">
            <div class="form-group">
              <div class="input-search">
                <i class="input-search-icon wb-search" aria-hidden="true"></i>
                <input type="text" class="form-control" name="site-search" placeholder="Search...">
                <button type="button" class="input-search-close icon wb-close" data-target="#site-navbar-search"
                  data-toggle="collapse" aria-label="Close"></button>
              </div>
            </div>
          </form>
        </div>
        <!-- End Site Navbar Seach -->
      </div>
    </nav>    
    <div class="site-menubar">
      <div class="site-menubar-body">
        <div>
          <div>
            <ul class="site-menu" data-plugin="menu">
              <li class="site-menu-category">일반</li>
              <li class="site-menu-item has-sub">
                <a href="javascript:void(0)">
                        <i class="site-menu-icon wb-dashboard" aria-hidden="true"></i>
                        <span class="site-menu-title">Dashboard</span>
                            <div class="site-menu-badge">
                                <span class="badge badge-pill badge-success">3</span>
                            </div>
                    </a>
                <ul class="site-menu-sub">
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../index.html">
                      <span class="site-menu-title">Dashboard v1</span>
                    </a>
                  </li>
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../dashboard/v2.html">
                      <span class="site-menu-title">Dashboard v2</span>
                    </a>
                  </li>
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../dashboard/ecommerce.html">
                      <span class="site-menu-title">Ecommerce</span>
                    </a>
                  </li>
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../dashboard/analytics.html">
                      <span class="site-menu-title">Analytics</span>
                    </a>
                  </li>
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../dashboard/team.html">
                      <span class="site-menu-title">Team</span>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="site-menu-item has-sub">
                <a href="javascript:void(0)">
                        <i class="site-menu-icon wb-layout" aria-hidden="true"></i>
                        <span class="site-menu-title">Layouts</span>
                                <span class="site-menu-arrow"></span>
                    </a>
                <ul class="site-menu-sub">
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../layouts/menu-collapsed.html">
                      <span class="site-menu-title">Menu Collapsed</span>
                    </a>
                  </li>
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../layouts/menu-collapsed-alt.html">
                      <span class="site-menu-title">Menu Collapsed Alt</span>
                    </a>
                  </li>
                  <li class="site-menu-item">
                    <a class="animsition-link" href="../layouts/menu-expended.html">
                      <span class="site-menu-title">Menu Expended</span>
                    </a>
                  </li>
                  
                  
                </ul>
              </li>
              
              
              
              
            </ul>
            
            </div>
        </div>
      </div>
    
      </div>    
      
      
      
    <!-- Page -->
    <div class="page">
      <div class="page-content">
        <!-- Panel -->
        <div class="panel">
          <div class="panel-body">
            
            <div class="page-invoice-table table-responsive">
              <table class="table table-hover text-right">
                <thead>
                  <tr>
                    <th class="text-center">번호</th>
                    <th>제목</th>
                    <th class="text-right">작성자</th>
                    <th class="text-right">날짜</th>
                  </tr>
                </thead>
                <tbody>
                <c:if test="${resultListCnt > 0}">
	                <c:forEach items="${resultList}" var="board" varStatus="status">
	                	 <tr>
		                    <td class="text-center"><c:out value="${no-status.index}"/> </td>
		                    <td class="text-left">
		                      <c:out value="${board.title}"/>
		                    </td>
		                    <td>
		                      <c:out value="${board.userName}"/>
		                    </td>
		                    <td>
		                      <c:out value="${board.created}"/>
		                    </td>
		                  </tr>
	                </c:forEach>
                </c:if>
                </tbody>
              </table>
            </div>
            
            
          </div>
        </div>
        <!-- End Panel -->
      </div>
    </div>
    <!-- End Page -->


    <!-- Footer -->
    <footer class="site-footer">
      <div class="site-footer-legal">© 2018 <a href="http://themeforest.net/item/remark-responsive-bootstrap-admin-template/11989202">Remark</a></div>
      <div class="site-footer-right">
        Crafted with <i class="red-600 wb wb-heart"></i> by <a href="https://themeforest.net/user/creation-studio">Creation Studio</a>
      </div>
    </footer>
    <!-- Core  -->
    <script src="/js/babel-external-helpers/babel-external-helpers.js"></script>
    <script src="/js/jquery/jquery.js"></script>
    <script src="/js/popper-js/umd/popper.min.js"></script>
    <script src="/js/bootstrap/bootstrap.js"></script>
    <script src="/js/animsition/animsition.js"></script>
    <script src="/js/mousewheel/jquery.mousewheel.js"></script>
    <script src="/js/asscrollbar/jquery-asScrollbar.js"></script>
    <script src="/js/asscrollable/jquery-asScrollable.js"></script>
    <script src="/js/ashoverscroll/jquery-asHoverScroll.js"></script>
    
    <!-- Plugins -->
    <script src="/js/switchery/switchery.js"></script>
    <script src="/js/intro-js/intro.js"></script>
    <script src="/js/screenfull/screenfull.js"></script>
    <script src="/js/slidepanel/jquery-slidePanel.js"></script>
        <script src="/js/aspaginator/jquery-asPaginator.min.js"></script>
    
    <!-- Scripts -->
    <script src="/js/Component.js"></script>
    <script src="/js/Plugin.js"></script>
    <script src="/js/Base.js"></script>
    <script src="/js/Config.js"></script>
    
    <script src="/js/Section/Menubar.js"></script>
    <script src="/js/Section/GridMenu.js"></script>
    <script src="/js/Section/Sidebar.js"></script>
    <script src="/js/Section/PageAside.js"></script>
    <script src="/js/Plugin/menu.js"></script>
    
    <script src="/js/config/colors.js"></script>
    <script src="/js/config/tour.js"></script>
    <!-- <script>Config.set('assets', '../../assets');</script> -->
    
    <!-- Page -->
    <script src="/js/Site.js"></script>
    <script src="/js/Plugin/asscrollable.js"></script>
    <script src="/js/Plugin/slidepanel.js"></script>
    <script src="/js/Plugin/switchery.js"></script>
        <script src="/js/Plugin/aspaginator.js"></script>
        <script src="/js/Plugin/responsive-tabs.js"></script>
        <script src="/js/Plugin/tabs.js"></script>
    
    <script>
      (function(document, window, $){
        'use strict';
    
        var Site = window.Site;
        $(document).ready(function(){
          Site.run();
        });
      })(document, window, jQuery);
    </script>
  </body>
</html>
