<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
  String path = request.getContextPath();
  System.out.println("====" + path);
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
  String exit = "exit";
  // 获得当前路径以及"直接父路径"的所有Cookie对象,如果没有任何Cookie的话,则返回null
  Cookie[] cookies = request.getCookies();
  //Cookie cookie1 = cookies[0];
  ///cookie1.setDomain(".http://www.weibaobeijing.com");
  //String a  = cookie1.getValue();
  //out.println(a);
  String value = "";
  // 遍历数组,获得具体的Cookie
  if (cookies == null) {

  } else {
    for (int i = 0; i < cookies.length; i++) {
      // 获得具体的Cookie
      Cookie cookie = cookies[i];
      // 获得Cookie的名称
      if (cookie.getName().equals("username")) {
        value = cookie.getValue();
        exit = "login";
      } else {

      }

      String name = cookie.getName();

//        out.print("Cookie名:"+name+" &nbsp; Cookie值:"+value+"<br>"+cookie.getMaxAge());
    }
  } %>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/bd.js"></script>
<script src="${ctx}/js/sso.js"></script>

<% if (exit.equals("exit")) {
%>

<script type="text/javascript">
  $.ssoLogout('<%=path%>');

</script>
<%}%>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong> 微宝</strong>
    <small>创业服务交易平台</small>
  </div>

  <%--<button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>--%>
  <%--<form action="http://www.weibaobeijing.com/Accounting?returnUrl=http://hlrcv.stage.adobe.com:8080/login" method="post">--%>
  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">


      <%
        if (value.isEmpty()&&value.equals("")){
      %>
      <li><a href="http://www.weibaobeijing.com/Accounting?returnUrl=http://www.weibaochuangye.com:9090/login"><span class="am-icon-user">
      </span> 登录 </a></li>
      <li><a href=""><span class="am-icon-registered"></span> 注册 </a></li>
      <%}%>

      <%
        if (!value.isEmpty()&&!value.equals("")){
      %>
      <%--<c:if test="${!empty user}">--%>
        <%--</span> ${user.name} </a></li>--%>
      <%--</c:if>--%>
      <%--<li><a href="http://www.weibaobeijing.com/Accounting/forward/configuration/memberRegister.jspx?returnUrl=http://www.weibaochuangye.com/busiplatform/Login"><span class="am-icon-registered"></span> 注册 </a></li>--%>
      <%--<li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>--%>
      <li class="am-dropdown" data-am-dropdown="">
      <a class="am-dropdown-toggle" data-am-dropdown-toggle="" href="javascript:;">
      <span class="am-icon-user"></span> <%=value%> <span class="am-icon-caret-down"></span>
      </a>
      <ul class="am-dropdown-content">
      <%--<li><a href="#"><span class="am-icon-user"></span> 资料</a></li>--%>
      <%--<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>--%>
      <li><a href="/loginout"><span class="am-icon-power-off"></span> 退出 </a></li>
      </ul>
      </li>
      <%--<li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>--%>
    </ul>
    <%}%>
  </div>
  <%--</form>--%>
</header>

<%--<header data-am-widget="header"--%>
<%--class="am-header am-header-default">--%>
<%--<div class="am-header-left am-header-nav">--%>
<%--<a href="#left-link" class="">--%>

<%--<i class="am-header-icon am-icon-home"></i>--%>
<%--</a>--%>
<%--<a href="#phone-link" class="">--%>

<%--<i class="am-header-icon am-icon-phone"></i>--%>
<%--</a>--%>
<%--</div>--%>

<%--<h1 class="am-header-title">--%>

<%--</h1>--%>

<%--<div class="am-header-right am-header-nav">--%>
<%--<a href="#user-link" class="">--%>

<%--<i class="am-header-icon am-icon-user"></i>--%>
<%--</a>--%>
<%--<a href="#cart-link" class="">--%>

<%--<i class="am-header-icon am-icon-shopping-cart"></i>--%>
<%--</a>--%>
<%--</div>--%>
<%--</header>--%>

