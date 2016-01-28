<%--
  Created by IntelliJ IDEA.
  User: dongzhukai
  Date: 16/1/12
  Time: 下午9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
  <%--<meta name="description" content="">--%>
  <%--<meta name="keywords" content="">--%>
  <%--<meta name="viewport"--%>
  <%--content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">--%>
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

  <link rel="stylesheet" href="../css/amazeui.min.css">
  <link rel="stylesheet" href="../css/app.css">
  <link rel="stylesheet" href="../css/admin.css">

  <style>
    #vld-tooltip {
      position: absolute;
      z-index: 1000;
      padding: 5px 10px;
      background: #F37B1D;
      min-width: 150px;
      color: #fff;
      transition: all 0.15s;
      box-shadow: 0 0 5px rgba(0, 0, 0, .15);
      display: none;
    }

    #vld-tooltip:before {
      position: absolute;
      top: -8px;
      left: 50%;
      width: 0;
      height: 0;
      margin-left: -8px;
      content: "";
      border-width: 0 8px 8px;
      border-color: transparent transparent #F37B1D;
      border-style: none inset solid;
    }
  </style>
</head>
<body>
<jsp:include page="common/header.jsp"/>

<div class="am-modal am-modal-no-btn company" tabindex="-1" id="company-modal">
  <div class="am-modal-dialog">
    <div>
      <div id="company-modal-title" class="am-modal-hd" style="display: inline">添加我的公司</div>
      <a href="javascript:void(0)" class="am-close am-close-spin " data-am-modal-close>&times;</a>

    </div>
    <hr>
    <div class="am-modal-bd">
      <form id="form-company" class="am-form am-form-horizontal" method="post" data-am-validator>
        <input type="text" name="accountId" id="accountId" style="display: none" value="${sessionScope.userId}"/>

        <div class="am-form-group">
          <label for="companyName" class="am-u-sm-2 am-form-label">公司名称 </label>
          <div class="am-u-sm-10">
            <input type="text" name="companyName" id="companyName" placeholder="请输入你要建立的公司名称(必填) " required>
          </div>
        </div>
        <div class="am-form-group">
          <label for="url" class="am-u-sm-2 am-form-label">公司网址 </label>
          <div class="am-u-sm-10">
            <input type="url" name="url" id="url" placeholder="输入你公司的网址(填写正确的网址) ">
            <%--<small>邮箱你懂得...</small>--%>
          </div>
        </div>
        <div class="am-form-group">
          <label for="lawPerson" class="am-u-sm-2 am-form-label">公司法人 </label>
          <div class="am-u-sm-10">
            <input type="text" name="lawPerson" id="lawPerson" placeholder="请填写公司的法人 ">
          </div>
        </div>

        <div class="am-form-group">
          <label for="telephone" class="am-u-sm-2 am-form-label js-pattern-mobile">公司电话</label>
          <div class="am-u-sm-10">
            <input type="text" name="telephone" id="telephone" placeholder="请填写公司的电话" maxlength="15">
          </div>
        </div>
        <div class="am-form-group">
          <label class="am-u-sm-2 am-form-label">公司地址 </label>
          <div class="am-u-sm-10">
            <%--<input style="width: 180px; float:left;" type="text" id="user-weibo" placeholder="输入你的微博 ">--%>

            <%--省份--%>
            <%--<label for="provinceId">选择省份:</label>--%>
            <select data-am-selected="{maxHeight: 200}" style="width: 80px;float:left;" id="provinceId" name="province">
              <c:if test="${!empty provinceList}">
                <c:forEach items="${provinceList}" var="province">
                  <option value="${province.code}">${province.name}</option>
                </c:forEach>
              </c:if>
            </select>
            <%--<input id="hiden0" name="province" type="text" value=""  style="display: none"/>--%>
            <%--市级--%>
            <%--<label for="cityId">选择城市:</label>--%>
            <select data-am-selected="{maxHeight: 200}" style="width: 80px;float:left;" data-placeholder="城市" name="city" id="cityId" class="form-control" data-rel="chosen">
              <option id="cityOption">选择城市</option>
            </select>
            <%--<input id="hiden1" name="city" type="text" value="" style="display: none" />--%>
            <%--地区--%>
            <%--<label for="areaId">选择区域:</label>--%>
            <select data-am-selected="{maxHeight: 200}" style="width: 80px;float:left;" data-placeholder="区域" name="county" id="areaId" class="form-control" data-rel="chosen">
              <option>选择区域</option>
            </select>
            <%--<input id="hiden2" name="county" type="text" value=""  style="display: none"/>--%>
            <br/>
            &nbsp;&nbsp;<input type="text" name="address" id="address" value="" placeholder="请填写公司的详细地址"/>
          </div>
        </div>
        <div class="am-form-group">
          <label for="intro" class="am-u-sm-2 am-form-label">简介 </label>
          <div class="am-u-sm-10">
            <textarea class="" rows="5" id="intro" name="intro" placeholder="输入公司简介"></textarea>
          </div>
        </div>

        <div class="am-form-group">
          <div class="am-u-sm-9 am-u-sm-push-2" id="edit-company-botton">
            <input id="company-modal-button" type="button" class="am-btn am-btn-primary" onclick="insertCompany()" value="保存公司"/>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="item-modal">
  <div class="am-modal-dialog">
    <div>
      <div id="item-modal-title" class="am-modal-hd" style="display: inline">添加服务</div>
      <a href="javascript:void(0)" class="am-close am-close-spin " data-am-modal-close>&times;</a>
    </div>
    <hr>
    <div class="am-modal-bd">
      <form id="form-item" class="am-form am-form-horizontal" data-am-validator>

        <input type="hidden" id="itemBindCompanyId" value="" name="companyId"/>
        <input type="hidden" id="itemId" value="" name="itemId"/>
        <div class="am-form-group">
          <label for="itemName" class="am-u-sm-2 am-form-label">服务名称 </label>
          <div class="am-u-sm-10">
            <input type="text" name="itemName" id="itemName" placeholder="请输入你要添加的服务名称(必填)" required>
          </div>
        </div>
        <div class="am-form-group">
          <label for="itemCost" class="am-u-sm-2 am-form-label">服务价格</label>
          <div class="am-u-sm-9">
            <input type="number" name="cost" id="itemCost" placeholder="请输入服务价格(必填)" min="0" required>
          </div>
          <div class="am-u-sm-1 am-fl">
            <label for="itemCost" class="am-u-sm-1 am-form-label">(元) </label>
          </div>
        </div>
        <div class="am-form-group">
          <label for="itemCost" class="am-u-sm-2 am-form-label"> </label>
          <div class="am-u-sm-4">
            <input type="text" name="minCost" id="itemMinCost" placeholder="请输入最小服务价格">
          </div>
          <div class="am-u-sm-1 am-fl">
            <label for="itemCost" class="am-u-sm-1 am-form-label">(元) </label>
          </div>
          <div class="am-u-sm-4">
            <input type="text" name="maxCost" id="itemMaxCost" placeholder="请输入最大服务价格">
          </div>
          <div class="am-u-sm-1 am-fl">
            <label for="itemCost" class="am-u-sm-1 am-form-label">(元) </label>
          </div>

        </div>
        <div class="am-form-group">
          <label for="itemIntro" class="am-u-sm-2 am-form-label">服务详情 </label>
          <div class="am-u-sm-10">
            <textarea class="" rows="5" id="itemIntro" name="intro" placeholder="输入服务详情"></textarea>
          </div>
        </div>

        <div class="am-form-group">
          <div class="am-u-sm-9 am-u-sm-push-2" id="editItem">
            <%--<button type="submit" class="am-btn am-btn-primary">保存服务</button>--%>
            <input id="item-modal-button" type="button" class="am-btn am-btn-primary" onclick="insertItem();" value="修改服务"/>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="staff-modal">
  <div class="am-modal-dialog">
    <div>
      <div id="staff-modal-title" class="am-modal-hd" style="display: inline">添加员工</div>
      <a href="javascript:void(0)" class="am-close am-close-spin " data-am-modal-close>&times;</a>
    </div>
    <hr>
    <div class="am-modal-bd">
      <form id="form-staff" class="am-form am-form-horizontal" data-am-validator>

        <input type="hidden" id="staffBindCompanyId" value="" name="companyId"/>
        <input type="hidden" id="staffId" value="" name="staffId"/>
        <div class="am-form-group">
          <label for="staffName" class="am-u-sm-2 am-form-label">员工名称 </label>
          <div class="am-u-sm-10">
            <input type="text" name="name" id="staffName" placeholder="请输入员工名称(必填哦)" minlength="2" maxlength="5" required>
          </div>
        </div>
        <div class="am-form-group">
          <label for="staffPhone" class="am-u-sm-2 am-form-label">手机号</label>
          <div class="am-u-sm-10">
            <input type="text" name="phone" id="staffPhone" placeholder="请输入员工手机号(必填)" pattern="^\s*1\d{10}\s*$" required>
          </div>
        </div>
        <div class="am-form-group">
          <label for="staffQQ" class="am-u-sm-2 am-form-label">QQ </label>
          <div class="am-u-sm-10">
            <input type="text" name="qq" id="staffQQ" placeholder="请输入员工QQ ">
          </div>
        </div>
        <div class="am-form-group">
          <label for="email" class="am-u-sm-2 am-form-label">邮箱 </label>
          <div class="am-u-sm-10">
            <input type="email" name="email" id="email" placeholder="请输入员工邮箱 ">
          </div>
        </div>
        <div class="am-form-group">
          <label for="weichat" class="am-u-sm-2 am-form-label">微信号 </label>
          <div class="am-u-sm-10">
            <input type="text" name="weichat" id="weichat" placeholder="请输入员工微信号 ">
          </div>
        </div>

        <div class="am-form-group">
          <div class="am-u-sm-9 am-u-sm-push-2">
            <input id="staff-modal-button" type="button" class="am-btn am-btn-primary" onclick="insertStaff(${company.companyId});" value="保存员工"/>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">亲</div>
    <div class="am-modal-bd">
      你，确定要删除这条记录吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>

<div id="box" style="margin: 0px 5px 0px 5px; font-size: 13px;">
  <div class="am-u-md-12">

    <button type="button" class="am-btn am-btn-danger am-u-md-12 am-icon-google-plus js-modal-insert company">添加公司</button>

    <div id="companyList">
      <%--<h4 class="am-u-md-12 am-btn am-btn-danger am-icon-google-plus"--%>
      <%--data-am-modal="{target: '#company-modal', closeViaDimmer: 0, width: 800, height: 625}"--%>
      <%--data-am-collapse="{parent: '#accordion-1', target: '#company-modal'}">--%>
      <%--添加我的公司--%>
      <%--</h4>--%>

      <%--折叠面板开始--%>
      <c:if test="${!empty listCompany}">
        <%--<c:forEach items="${listCompany}" var="company" varStatus="companyNum">--%>
        <c:forEach items="${listCompany}" var="company">
          <div id="company${company.companyId}" class="am-panel-collapse am-collapse am-in">
            <div class="am-panel am-panel-default am-panel-group">
              <div class="am-g">
                <div class="am-panel am-panel-default">
                  <div class="am-panel-hd">
                    <div>
                      <input id="ipt-${company.companyId}" type="hidden" value="${company.companyId}"/>
                      <label id="companyName">${company.companyName}</label>

                      <button class="am-fr am-icon-arrow-circle-down" data-am-collapse="{parent: '#accordion', target: '#company${company.companyId}-itemAndStaffList'}"></button>
                      <button class="am-fr am-icon-close" onclick="removeCompany(${company.companyId})"></button>
                      <button class="am-fr am-icon-edit js-modal-edit company" ></button>
                      <input id="edit-companyId" style="display:none" value="${company.companyId}" />
                      <br>
                      公司地址 :
                      <div style="display: inline" id="companyAddress">${company.address}</div>
                      <br>
                      公司规模 :
                      <div style="display: inline" id="companyScale">${company.companyScale}</div>


                    </div>
                  </div>
                  <div id="company${company.companyId}-itemAndStaffList" class="am-panel-collapse am-collapse ">
                    <!-- 开始遍历我的服务 -->
                    <div class="am-u-md-8">

                        <%--<h4 class="am-btn am-btn-danger am-btn-block am-icon-plus-circle js-modal-edit item" data-am-modal="{target: '#item-modal', closeViaDimmer: 0, width: 800, height: 450}">--%>
                        <%--添加服务--%>
                        <%--</h4>--%>
                      <input id="company${company.companyId}" class="companyId" type="hidden" value="${company.companyId}"/>
                      <h4 class="am-btn am-btn-danger am-btn-block am-icon-plus-circle js-modal-insert item">
                        添加服务
                      </h4>

                      <div id="company${company.companyId}-itemList">

                        <c:if test="${empty company.itemList}">
                          <a id="company${company.companyId}-item-null" href="#" class="am-btn am-btn-primary am-disabled">
                            对不起，该公司下没有关联任何服务。
                          </a>
                        </c:if>

                        <c:if test="${!empty company.itemList}">
                          <c:forEach items="${company.itemList}" var="item">
                            <div id="company${company.companyId}-item${item.itemId}" class="am-panel am-panel-default">
                              <div class="am-panel-hd droppable">
                                  <%--<div>--%>
                                  <%--<input id="company${company.companyId}-items${item.itemId}" type="hidden" value="${item.itemId}"/>--%>
                                <input id="itemId" type="hidden" value="${item.itemId}"/>
                                <input id="companyId" type="hidden" value="${company.companyId}"/>

                                <label id="itemName">${item.itemName}</label>

                                <button class="am-fr am-icon-arrow-circle-down" data-am-collapse="{parent: '#accordion', target: '#ctx-company${company.companyId}-items${item.itemId}'}"></button>
                                <button class="am-fr am-icon-remove" onclick="removeItem(${company.companyId},${item.itemId})"></button>
                                <button class="am-fr am-icon-edit js-modal-edit item"></button>
                                  <%--</div>--%>
                              </div>
                              <div id="ctx-company${company.companyId}-items${item.itemId}" class="am-panel-collapse am-collapse n am-panel-bd sortable">
                                  <%--<div class="am-panel-bd">--%>
                                服务价格 ：
                                <div style="display: inline" id="itemCost">${item.cost} 元</div>

                                    <%--隐藏域开始--%>
                                <div style="display: none" id="minCost">${item.minCost} </div>
                                <div style="display: none" id="maxCost">${item.maxCost} </div>
                                <div style="display: none" id="itemIntro">${item.intro} </div>
                                    <%--隐藏域结束--%>
								 <div id="sortable"></div>
                                  <%--</div>--%>
                               <div id="itemStaffLink">
                                  <%-- 服务和人员的关系 --%>
                                </div>                              </div>
                            </div>
                          </c:forEach>
                        </c:if>
                      </div>
                    </div>
                    <!-- 结束遍历我的服务 -->
                    <!-- 开始遍历我的员工-->
                    <div class="am-u-md-4">

                        <%--<h4 class="am-btn am-btn-danger am-btn-block am-icon-user-plus " data-am-modal="{target: '#staff-modal', closeViaDimmer: 0, width: 600, height: 425}">--%>
                        <%--添加员工--%>
                        <%--</h4>--%>
                      <input id="company${company.companyId}" class="companyId" type="hidden" value="${company.companyId}"/>
                      <h4 class="am-btn am-btn-danger am-btn-block am-icon-user-plus js-modal-insert staff">
                        添加员工
                      </h4>

                      <div class="am-panel-collapse">
                        <ul id="company${company.companyId}-staffList" class="am-list am-list-static">
                          <c:if test="${!empty company.staffsList}">

                            <c:forEach items="${company.staffsList}" var="staff">
                              <li id="company${company.companyId}-staff${staff.staffId}">
                                <span id="staffName" class="draggable" style="cursor: move; background: #4cae4c;">${staff.name}</span>
                                <span id="phone" >${staff.phone}</span>
                                <span id="staffQQ" style="display: none">${staff.qq}</span>
                                <span id="email" style="display: none">${staff.email}</span>
                                <span id="weichat"style="display: none" >${staff.weichat}</span>

                                  <%--<div style="display: inline">--%>
                                <button onclick="removeStaff(${company.companyId},${staff.staffId})" class="am-fr am-icon-remove"></button>
                                  <%--</div>--%>
                                  <%--<div style="display: inline">--%>
                                <button class="am-fr am-icon-edit js-modal-edit staff"></button>
                                  <%--</div>--%>
                              </li>
                            </c:forEach>

                          </c:if>

                          <c:if test="${empty company.staffsList}">
                            <a id="company${company.companyId}-staff-null" href="#" class="am-btn am-btn-primary am-disabled">该公司下没有任何的人员哦。</a>
                          </c:if>
                        </ul>
                      </div>
                    </div>
                    <!-- 结束遍历我的员工-->
                  </div>
                </div>

              </div>

            </div>
          </div>
        </c:forEach>
      </c:if>
      <%--折叠面板结束--%>

      <%--折叠面板开始2--%>
      <c:if test="${!empty organizationList}">

        <c:forEach items="${organizationList}" var="organization" varStatus="status">
          <div id="item-framework-${status.index+200}" class="am-pane${status.index+200}">
            <div class="am-panel am-panel-default am-panel-group">
              <div class="am-g">
                <div class="am-panel am-panel-default">
                  <div class="am-panel-hd">
                    <h4 class="am-panel-title"
                        data-am-collapse="{parent: '#accordion', target: '#do-not-say-${status.index+200}'}">
                        ${organization.orgName}
                    </h4>
                  </div>
                  <div id="do-not-say-${status.index+200}" class="am-panel-collapse am-collapse "> <%--am-in--%>
                    <div class="am-u-md-4 am-panel-bd">
                        <%--这里是一个第一个公司的详细信息。--%>
                        <%--${organization.intro}--%>
                    </div>
                      <%--&lt;%&ndash;服务面板开始&ndash;%&gt;--%>
                      <%--<div class="am-u-md-4">--%>

                      <%--<div class="am-panel am-panel-secondary">--%>
                      <%--<div class="am-panel-hd am-cf">--%>
                      <%--<h4 class="am-panel-title"--%>
                      <%--data-am-collapse="{parent: '#accordion', target: '#do-not-say-${status.index+200}'}">--%>
                      <%--我的服务--%>
                      <%--</h4>--%>
                      <%--</div>--%>
                      <%--<div id="do-not-say-${status.index+200}" class="am-panel-collapse am-collapse am-in">--%>
                      <%--<div class="am-panel-bd">--%>
                      <%--<a href="#" class="am-icon-edit"--%>
                      <%--data-am-modal="{target: '#doc-modal-${status.index+200}', closeViaDimmer: 0, width: 850, height: 525}">添加服务</a>--%>

                      <%--<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-${status.index+200}">--%>
                      <%--<div class="am-modal-dialog">--%>
                      <%--<div class="am-modal-hd">添加服务--%>
                      <%--<a href="javascript: void(0)" class="am-close am-close-spin"--%>
                      <%--data-am-modal-close>&times;</a>--%>
                      <%--</div>--%>
                      <%--<div class="am-modal-bd">--%>
                      <%--&lt;%&ndash;Modal 内容。本 Modal 无法通过遮罩层关闭。&ndash;%&gt;--%>
                      <%--<form action="/insertItems">--%>
                      <%--<input style="display: none" type="text" value="${organization.orgId}"--%>
                      <%--name="companyId"/>--%>
                      <%--<br/>--%>
                      <%--<input type="text" name="itemName" id="itemName" placeholder="请输入服务名称名称 "--%>
                      <%--style="width: 400px;height: 35px;">--%>
                      <%--<br/>--%>
                      <%--<input type="text" name="cost" id="cost" placeholder="请输入服务价格 "--%>
                      <%--style="width: 400px;height: 35px;margin-top: 20px;">--%>
                      <%--<br/>--%>
                      <%--<textarea class="am-input-lg" name="intro" rows="5" id="doc-ta-1"--%>
                      <%--style="width: 400px;margin-top: 20px" placeholder="请输入服务详情 "></textarea>--%>


                      <%--<br/>--%>

                      <%--<button type="submit" class="am-btn am-btn-primary">提交服务</button>--%>
                      <%--</form>--%>
                      <%--</div>--%>
                      <%--</div>--%>
                      <%--</div>--%>
                      <%--</div>--%>
                      <%--</div>--%>
                      <%--</div>--%>
                      <%--&lt;%&ndash;服务面板结束&ndash;%&gt;--%>

                    <div class="am-u-md-4">
                      <div class="am-panel am-panel-primary">
                        <div class="am-panel-hd am-cf">
                          <h4 class="am-panel-title"
                              data-am-collapse="{parent: '#accordion', target: '#do-not-say-113'}">
                            我的员工</h4>
                        </div>
                        <div id="do-not-say-313" class="am-panel-collapse am-collapse am-in">
                          <div class="am-panel-bd">
                            <a href="#" class="am-icon-edit"
                               data-am-modal="{target: '#doc-modal-3', closeViaDimmer: 0, width: 400, height: 225}">添加员工</a>

                            <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-313">
                              <div class="am-modal-dialog">
                                <div class="am-modal-hd">Modal 标题
                                  <a href="javascript: void(0)" class="am-close am-close-spin"
                                     data-am-modal-close>&times;</a>
                                </div>
                                <div class="am-modal-bd">
                                  Modal 内容。本 Modal 无法通过遮罩层关闭。
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>


              </div>


            </div>
          </div>

        </c:forEach>
      </c:if>
      <%--折叠面板结束2--%>
    </div>
  </div>
</div>


<%--</div>--%>

<hr/>
<jsp:include page="common/footer.jsp"/>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="../js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="../js/amazeui.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="../js/admin-release.js"></script>
<script type="text/javascript">
  //Auto:zwd-apple:2016/1/8

  /*页面加载就开始执行*/
  $(document).ready(function () {

    $("#provinceId").change(function () {
      $.get("../release/getCityByProvinceId/" + $("#provinceId").val(), function (data) {
        if (data.status) {
          var result = "<option>选择城市</option>";
          $.each(data.obj, function (n, value) {
            result += "<option value='" + value.code + "' title=" + value.name + " id=cityOption>" + value.name + "</option>";
          });
          $("#cityId").html('');
          $("#cityId").append(result);
        }
      }, "json");
    });

    $("#cityId").change(function () {
      $.get("../release/getAreaByCityId/" + $("#cityId").val(), function (data) {
        if (data.status) {
          var result = "<option>选择区域</option>";
          $.each(data.obj, function (n, value) {
            result += "<option value='" + value.code + "'>" + value.name + "</option>";
          });
          $("#areaId").html('');
          $("#areaId").append(result);
        }
      }, "json");
    });

  });



</script>


</body>
</html>

