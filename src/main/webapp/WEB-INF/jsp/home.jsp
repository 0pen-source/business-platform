<%--
  Created by IntelliJ IDEA.
  User: dongzhukai
  Date: 16/1/12
  Time: 下午2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>微宝创业服务交易平台</title>

  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <link rel="icon" type="image/png" href="assets/i/favicon.png">

  <!-- Add to homescreen for Chrome on Android -->
  <meta name="mobile-web-app-capable" content="yes">
  <link rel="icon" sizes="192x192" href="assets/i/app-icon72x72@2x.png">

  <!-- Add to homescreen for Safari on iOS -->
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileImage" content="assets/i/app-icon72x72@2x.png">
  <meta name="msapplication-TileColor" content="#0e90d2">

  <link rel="stylesheet" href="${ctx}/css/amazeui.min.css">
  <link rel="stylesheet" href="${ctx}/css/app.css">
</head>
<body>
<jsp:include page="common/header.jsp"/>

<%--<div class="am-container">--%>
<%--网格布局--%>
<%--<div class="am-g">--%>

<%--<div class="am-g">--%>
<%--<div class="am-u-lg-3">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--<div class="am-u-lg-6">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--<div class="am-u-lg-3">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--</div>--%>
<%--<p></p>--%>
<%--<p></p>--%>
<%--<p></p>--%>
<%--<div class="am-g">--%>
<%--<div class="am-u-sm-6 am-u-lg-2">--%>
<%--<span class="am-show-md-down">6</span>--%>
<%--</div>--%>
<div class="am-u-lg-8">
  <span class="am-show-md-down">
    <p class="am-kai">微宝创业服务交易平台提供如下服务:</p>
    <p class="am-kai">1.工商注册、代理记账、财税咨询、法律咨询、融资理财等信息查找、发布</p>
    <p class="am-kai">2.证照、域名、专利、商标、上市等资产服务交易</p>
  </span>
</div>

<div class="am-u-lg-8">
   <span class="am-show-md-down">
        <form class="am-form" action="search/table?&city=" method="post">
          <%--<fieldset>--%>
            <span><select id="doc-select-1" name="provincecode">
              <c:if test="${!empty provinceList}">
                <c:forEach items="${provinceList}" var="province">
                  <option value="${province.code}">${province.name}</option>
                </c:forEach>
              </c:if>
            </select>
            </span>
          <%--<div class="am-form-group am-fl" style="display: inline">--%>
          <%--<select id="doc-select-1" name="provincecode">--%>
          <%--<c:if test="${!empty provinceList}">--%>
          <%--<c:forEach items="${provinceList}" var="province">--%>
          <%--<option value="${province.code}">${province.name}</option>--%>
          <%--</c:forEach>--%>
          <%--</c:if>--%>
          <%--</select>--%>
          <%--&lt;%&ndash;<span class="am-form-caret"></span>&ndash;%&gt;--%>
          <%--</div>--%>
          <input type="hidden" name="nowpage" value="1">
          <input type="search" name="searchKey" placeholder="代理记账,工商注册">


          <button type="submit" class="am-btn-xl am-btn-block am-btn am-btn-primary">搜索</button>


          <%--</fieldset>--%>
        </form>
      </span>


</div>

<%--<div class="am-u-sm-12 am-u-lg-2">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--</div>--%>

<div class="am-u-lg-8">
    <span class="am-show-md-down">
      <%--<div class="am-center">--%>
        <c:if test="${empty sessionScope}">
          <%--<div class="am-cf">--%>
          <button id="empty-button" type="button" class="am-btn-block am-btn-xl am-btn am-btn-success">我要发布</button>
          <%--</div>--%>
        </c:if>
        <c:if test="${!empty sessionScope}">
          <%--<div class="am-cf">--%>
          <button type="button" class="am-btn-xl am-btn-block am-btn am-btn-success" onclick="location.href='   admin/release'">我要发布</button>
          <%--</div>--%>
        </c:if>
      <%--</div>--%>
    </span>
</div>
<%--<div class="am-u-sm-12 am-u-lg-2">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="am-g">--%>
<%--<div class="am-u-lg-3">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--<div class="am-u-lg-6">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--<div class="am-u-lg-3">--%>
<%--<span class="am-show-md-down"></span>--%>
<%--</div>--%>
<%--</div>--%>

<%--</div>--%>

<%--</div>--%>

<div class="am-container">
  <%--网格布局--%>
  <%--<div class="am-g">--%>

  <div class="am-g">
    <div class="am-u-lg-3">
      <%--<span class="am-show-md-down"></span>--%>
      <span class="am-show-lg-only">&nbsp;</span>
    </div>
    <div class="am-u-lg-6">
      <span class="am-show-md-down"></span>
                <span class="am-show-lg-only" style="width: 800px;">
                    <%--<p class="am-kai">微宝创业服务交易平台致力于,</p>--%>
                    <%--<p class="am-kai">创业路上中小企业的孵化器.</p>--%>
                    <p class="am-kai">微宝创业服务交易平台提供如下服务:</p>
                    <p class="am-kai">1.工商注册、代理记账、财税咨询、法律咨询、融资理财等信息查找、发布</p>
                    <p class="am-kai">2.证照、域名、专利、商标、上市等资产服务交易</p>
                </span>
    </div>
    <div class="am-u-lg-3">
      <span class="am-show-lg-only"></span>
    </div>
  </div>
  <p></p>
  <p></p>
  <p></p>
  <div class="am-g">
    <div class="am-u-sm-6 am-u-lg-2">
      <%--<span class="am-show-md-down">6</span>--%>
      <span class="am-hide-md-down">&nbsp;</span>
    </div>
    <div class="am-u-sm-6 am-u-lg-8">
      <%--<span class="am-show-md-down">--%>
      <%--<form class="am-form" action="search/table?&city=" method="post">--%>
      <%--<fieldset>--%>

      <%--<div class="am-form-group am-fl">--%>
      <%--<select id="doc-select-1" name="provincecode">--%>
      <%--<c:if test="${!empty provinceList}">--%>
      <%--<c:forEach items="${provinceList}" var="province">--%>
      <%--<option value="${province.code}">${province.name}</option>--%>
      <%--</c:forEach>--%>
      <%--</c:if>--%>
      <%--</select>--%>
      <%--<span class="am-form-caret"></span>--%>
      <%--</div>--%>
      <%--<div><input type="hidden" name="nowpage" value="1"></div>--%>
      <%--<div class="am-fl"><input type="text" name="searchKey" placeholder="代理记账"></div>--%>

      <%--<div class="am-fl">--%>
      <%--<button type="submit" class="am-btn am-btn-primary">搜索</button>--%>
      <%--</div>--%>

      <%--</fieldset>--%>
      <%--</form>--%>
      <%--</span>--%>
      <span class="am-hide-md-down">
        <div class="am-g">
          <form class="am-form" action="search/table?&city=" method="post">
            <fieldset>

              <div class="am-form-group am-fl" style="width: 90px;">
                <select id="doc-select-1" name="provincecode">
                  <c:if test="${!empty provinceList}">
                    <c:forEach items="${provinceList}" var="province">
                      <option value="${province.code}">${province.name}</option>
                    </c:forEach>
                  </c:if>
                </select>
                <span class="am-form-caret"></span>
              </div>
              <div><input type="hidden" name="nowpage" value="1"></div>
              <div class="am-fl" style="width: 458.4px;"><input type="text" name="searchKey" placeholder="我要查找工商注册、代理记账、财税咨询、法律咨询等信息"></div>

              <div class="am-fl">
                <button type="submit" class="am-btn am-btn-primary">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
              </div>

            </fieldset>
          </form>
        </div>
      </span>
    </div>
    <div class="am-u-sm-12 am-u-lg-2">
      <%--<span class="am-show-md-down">full</span>--%>
      <span class="am-hide-md-down">&nbsp;</span>
    </div>
  </div>

  <div class="am-g">
    <div class="am-u-sm-6 am-u-lg-2">
      <%--<span class="am-show-md-down">6</span>--%>
      <span class="am-hide-md-down">&nbsp;</span>
    </div>
    <div class="am-u-sm-6 am-u-lg-8">
      <%--<span class="am-show-md-down">6</span>--%>
      <span class="am-hide-md-down">
        <div class="am-g">
          <div></div>
          <c:if test="${empty sessionScope}">
            <div class="am-cf">
              <button id="empty-button1" type="button" style="width: 635px; height:80px; margin-left: 10px;" class="am-btn am-btn-success">我要发布工商注册、代理记账、财税咨询、法律咨询、融资理财等信息&nbsp;&nbsp;</button>
            </div>
          </c:if>
          <c:if test="${!empty sessionScope}">
            <div class="am-cf">
              <button type="button" style="width: 635px; height:80px; margin-left: 10px;" class="am-btn am-btn-success" onclick="location.href='   admin/release'">我要发布工商注册、代理记账、财税咨询、法律咨询、融资理财等信息&nbsp;&nbsp;</button>
            </div>
          </c:if>
          <div></div>
        </div>
      </span>
    </div>
    <div class="am-u-sm-12 am-u-lg-2">
      <%--<span class="am-show-md-down">full</span>--%>
      <span class="am-hide-md-down">&nbsp;</span>
    </div>
  </div>

  <div class="am-g">
    <div class="am-u-lg-3">
      <%--<span class="am-show-md-down">sm-full</span>--%>
      <span class="am-show-lg-only">&nbsp;</span>
    </div>
    <div class="am-u-lg-6">
      <%--<span class="am-show-md-down">sm-full</span>--%>
      <span class="am-show-lg-only"></span>
    </div>
    <div class="am-u-lg-3">
      <%--<span class="am-show-md-down">sm-full</span>--%>
      <span class="am-show-lg-only">&nbsp;</span>
    </div>
  </div>
  <%--</div>--%>

</div>
<%--session失效验证判断，保障用户体验--%>
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">登录提示</div>
    <div class="am-modal-bd">
      亲，没有登录暂时不能发布公司和服务哦!您想现在登陆吗?
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>登录</span>
    </div>
  </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<hr/>
<jsp:include page="common/footer.jsp"/>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${ctx}/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${ctx}/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="${ctx}/js/amazeui.min.js"></script>
</body>
<script>
  var ctx = "${ctx}/";
  $(function () {
    $("#empty-button1").bind("click", function () {
//            alert("点击成功接收");
      $('#my-confirm').modal({
        relatedTarget: this,
        onConfirm: function (options) {
          location.href = "${ctx}/login"
        },
        // closeOnConfirm: false,
        onCancel: function () {

        }
      });
    })
  });

  $(function () {
    $("#empty-button").bind("click", function () {
      $('#my-confirm').modal({
        relatedTarget: this,
        onConfirm: function (options) {
          location.href = "${ctx}/login"
        },
        // closeOnConfirm: false,
        onCancel: function () {

        }
      });
    })
  });
</script>
</html>
