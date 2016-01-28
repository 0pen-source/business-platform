<%--
  Created by IntelliJ IDEA.
  User: dongzhukai
  Date: 16/1/9
  Time: 下午7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link rel="icon" type="image/png" href="../i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
  <link rel="stylesheet" href="../css/amazeui.min.css"/>
  <link rel="stylesheet" href="../css/admin.css">

  <!--[if lt IE 9]>
  <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
  <script src="../js/polyfill/rem.min.js"></script>
  <script src="../js/polyfill/respond.min.js"></script>
  <script src="../js/amazeui.legacy.js"></script>
  <![endif]-->

  <!--[if (gte IE 9)|!(IE)]><!-->
  <script src="../js/jquery.min.js"></script>
  <script src="../js/amazeui.min.js"></script>
  <!--<![endif]-->
  <script src="../js/app.js"></script>


  <script type="text/javascript" src="../js/show.js"></script>
  <style type="text/css">
    .title{
      width:85px;
      float: left;
      color: rgb(0, 160, 233);
      margin-left: 20px;
    }
    .showaddress{
      width: 85%;
      float: left;
    //height: 100%;

    }
    .showaddress li{
      list-style:none;
      float: left;
      margin-top: 4px;
      margin-left: 10px;
    }
    .showaddress  li a{
      color: rgb(160, 160, 160);
      text-decoration:none;
    }
    .showaddress li a:hover{
      color: rgb(0, 160, 233);
    }
    .td-table{
      margin-left: 30px;
      margin-right: 30px;
    }
  </style>
</head>
<body id="main">

<jsp:include page="common/header.jsp"/>
<div>

  <!-- content start -->
  <div class="am-container">
    <jsp:include page="common/select-search.jsp"/>

    <div >
      <%--<span class="am-badge am-badge-primary"><h3>全部地区</h3></span>--%>

      <%--<c:forEach items="${citylist}" var="city">--%>
        <%--<span class="am-badge"><a href="table?provincecode=${provincecode}&searchKey=${info}&city=${city.name}&nowpage=1">${city.name}</a></span>--%>
      <%--</c:forEach>--%>
        <div class="title">全部地区</div>
        <div class="showaddress">
          <ul id="cityId">
            <c:forEach items="${citylist}" var="city">
              <li><a href="table?provincecode=${provincecode}&searchKey=${info}&city=${city.name}&nowpage=1">${city.name}</a></li>
            </c:forEach>
          </ul>
        </div>

    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
            <tr>
              <%--<th class="table-check"><input type="checkbox"/></th>--%>
              <th class="table-id">ID</th>
              <th class="table-title">服务内容</th>
                <th class="table-date">报价</th>
              <th class="table-author">联系方式</th>
             <%--<th class="table-set">操作</th>--%>
            </tr>
            </thead>
            <tbody>

              <tr>
            <c:forEach items="${selectlist}" var="selectall" varStatus="status">
              <tr   id="trtop1" onmousemove="showinfo('trtop1${status.count}')" onmouseout="displayinfo('trtop1${status.count}')">
                  <%--<td><input type="checkbox"/></td>--%>
                <td>${status.count}</td>
                <td>${selectall.itemName}</td>
                    <td>${selectall.cost}</td>
                <td>${selectall.telephone}</td>
                <%--<td>--%>
                  <%--<div class="am-btn-toolbar">--%>
                    <%--<div class="am-btn-group am-btn-group-xs">--%>
                      <%--<button class="am-btn am-btn-default am-btn-xs"><span--%>
                              <%--class="am-icon-copy"></span>--%>
                        <%--复制--%>
                      <%--</button>--%>
                    <%--</div>--%>
                  <%--</div>--%>
                <%--</td>--%>
              </tr>
                <tr class="trselect" id="trtop1${status.count}">
                  <td colspan="4">
                    <table class="table-main td-table" id="tdtable">
                      <tr >
                        <td class="td1" style="width: 80px">服务简介：</td>
                        <td class="td2" >
                          <%--<div style="width: 400px">--%>
                            ${selectall.intro}

                        </td>
                      </tr>
                      <tr>
                        <td class="td1">服务人员：</td>
                        <td class="td2" colspan="2">
                            ${selectall.nameAndPhone}
                        </td>
                      </tr>
                      <tr>
                        <td class="td1">公司名称：</td>
                        <td class="td2" colspan="2">
                            ${selectall.companyName}
                        </td>
                      </tr>
                      <tr>
                        <td class="td1">公司规模：</td>
                        <td class="td2" colspan="2">${selectall.companyScale}人</td>
                      </tr>
                      <tr id="tdtabletr">
                        <td class="td1">详细地址：</td>
                        <td class="td2" colspan="2">${selectall.province}${selectall.city}${selectall.county}${selectall.address}</td>
                      </tr>
                    </table>
                  </td>
                  <%--<td>--%>
                    <%--<img src="images/edit.png"/>--%>
                  <%--</td>--%>
                </tr>
            </c:forEach>
            </tbody>
          </table>
          <div class="am-cf">
          <!--  共 15 条记录-->
            <div class="am-fr">
              <ul class="am-pagination-first am-pagination-last am-pagination">
                <c:choose>
                  <c:when test="${nowpage==1}">
                    <li>首页</li>
                    <li>上一页</li>
                  </c:when>
                  <c:otherwise>
                    <li><a href="table?provincecode=${provincecode}&searchKey=${info}&city=${city}&nowpage=1">首页</a></li>
                    <li><a href="table?provincecode=${provincecode}&searchKey=${info}&city=${city}&nowpage=${nowpage-1}">«</a></li>
                  </c:otherwise>
                </c:choose>

                <c:forEach begin="1" end="${page}" var="num">
                  <c:choose>
                    <c:when test="${nowpage==num}">
                      [${num}]
                    </c:when>
                    <c:otherwise>
                      <li><a href="table?provincecode=${provincecode}&searchKey=${info}&city=${city}&nowpage=${num}">${num}</a></li>
                    </c:otherwise>
                  </c:choose>
                </c:forEach>

                <c:choose>
                  <c:when test="${nowpage==page}">
                    <li>下一页</li>
                    <li>尾页</li>
                  </c:when>
                  <c:otherwise>
                    <li><a href="table?provincecode=${provincecode}&searchKey=${info}&city=${city}&nowpage=${nowpage+1}">»</a></li>
                    <li><a href="table?provincecode=${provincecode}&searchKey=${info}&city=${city}&nowpage=${page}">尾页</a></li>
                  </c:otherwise>
                </c:choose>

                <%--<li class="am-disabled"><a href="#">«</a></li>--%>
                <%--<li class="am-active"><a href="#">1</a></li>--%>
                <%--<li><a href="#">2</a></li>--%>
                <%--<li><a href="#">3</a></li>--%>
                <%--<li><a href="#">4</a></li>--%>
                <%--<li><a href="#">5</a></li>--%>
                <%--<li><a href="#">»</a></li>--%>
              </ul>
            </div>
          </div>
          <hr/>

        </form>
      </div>

    </div>
  </div>
  <!-- content end -->
</div>

<jsp:include page="common/footer.jsp"/>

</body>
</html>
