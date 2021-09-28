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
    
    <title>Login | ITShedule</title>
    
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
        <link rel="stylesheet" href="/css/examples/pages/login-v3.css">
    
    
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
  <body class="animsition page-login-v3 layout-full">
    <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->


    <!-- Page -->
    <div class="page vertical-align text-center" data-animsition-in="fade-in" data-animsition-out="fade-out">>
      <div class="page-content vertical-align-middle animation-slide-top animation-duration-1">
        <div class="panel">
          <div class="panel-body">
            <div class="brand">
              <img class="brand-img" src="/images/logo-colored.png" alt="...">
              <h2 class="brand-text font-size-18"> ITShedule </h2>
            </div>
            <form name="loginForm" id="loginForm" method="post" action="<c:url value="/main"/>">
            	<input type="hidden" name="${_csrf.parameterName}" id="${_csrf.parameterName}" value="${_csrf.token}" />
              <div class="form-group form-material floating" data-plugin="formMaterial">
                <input type="text" class="form-control" id="username" name="userId" />
                <label class="floating-label">Id</label>
              </div>
              <div class="form-group form-material floating" data-plugin="formMaterial">
                <input type="password" class="form-control" id="userpassword" name="userPw" />
                <label class="floating-label">Password</label>
              </div>
              <div class="form-group clearfix">
                <div class="checkbox-custom checkbox-inline checkbox-primary checkbox-lg float-left">
                  <input type="checkbox" id="inputCheckbox" name="remember">
                  <label for="inputCheckbox">Remember me</label>
                </div>
                <a class="float-right" href="forgot-password.html">Forgot password?</a>
              </div>
              <button type="submit" class="btn btn-primary btn-block btn-lg mt-40">Sign in</button>
            </form>
            <p>Still no account? Please go to <a href="/signup">Sign up</a></p>
          </div>
        </div>

<!--
        <footer class="page-copyright page-copyright-inverse">
          <p>WEBSITE BY Creation Studio</p>
          <p>© 2018. All RIGHT RESERVED.</p>
          <div class="social">
            <a class="btn btn-icon btn-pure" href="javascript:void(0)">
            <i class="icon bd-twitter" aria-hidden="true"></i>
          </a>
            <a class="btn btn-icon btn-pure" href="javascript:void(0)">
            <i class="icon bd-facebook" aria-hidden="true"></i>
          </a>
            <a class="btn btn-icon btn-pure" href="javascript:void(0)">
            <i class="icon bd-google-plus" aria-hidden="true"></i>
          </a>
          </div>
-->
        </footer>
      </div>
    </div>
    <!-- End Page -->


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
        <script src="/js/jquery-placeholder/jquery.placeholder.js"></script>
    
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
        <script src="/js/Plugin/jquery-placeholder.js"></script>
        <script src="/js/Plugin/material.js"></script>
    
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
