<%--
  Created by IntelliJ IDEA.
  User: dongzhukai
  Date: 16/1/12
  Time: 下午5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<script src="../js/jquery.min.js"></script>
</head>
<div class="am-g">
    <div class="am-u-sm-6 am-u-lg-2">
        <span class="am-show-md-down">6</span>
        <span class="am-hide-md-down">&nbsp;</span>
    </div>
    <div class="am-u-sm-6 am-u-lg-8" >
        <span class="am-show-md-down">6</span>
                <span class="am-hide-md-down">
                    <form class="am-form" action="table?nowpage=1&city=" method="post">
                        <fieldset>

                            <div class="am-form-group am-fl" style="width: 90px;">
                                <select id="provinceId" name="provincecode"  >
                                    <%--<option value="option1">北京</option>--%>
                                    <%--<option value="option2">山西</option>--%>
                                    <%--<option value="option3">河北</option>--%>
                                        <option selected="selected" value="${provincecode}">${province.name}</option>
                                        <c:if test="${!empty provinceList}">
                                            <c:forEach items="${provinceList}" var="province">
                                                <option value="${province.code}">${province.name}</option>
                                            </c:forEach>
                                        </c:if>
                                </select>
                                <span class="am-form-caret"></span>
                            </div>

                            <div class="am-fl" style="width: 410px;"><input type="text" name="searchKey" placeholder="${info}"></div>


                            <div class="am-fl">
                                <button type="submit" class="am-btn am-btn-primary">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
                            </div>

                        </fieldset>
                    </form>

                </span>
    </div>
    <div class="am-u-sm-12 am-u-lg-2">
        <span class="am-show-md-down">full</span>
        <span class="am-hide-md-down">&nbsp;</span>
    </div>
</div>

<script type="text/javascript">
    //Auto:wb-apple:2016/1/19

    /*页面加载就开始执行*/
    $(document).ready(function () {
        $("#provinceId").change(function () {
            var title = $("#provinceId").find("option:selected").val();
			//alert(title);
            $('#hiden0').html('');
            $('#hiden0').val(title);//追加value值
            $.get("getCityByProvinceIdJson/"+title,function(data){
                if(data.status){
//                    var result = "<span class=\"am-badge am-badge-primary\"><h3>全部地区</h3></span>";
                    var result = "";
                    var cityTest = "<div> </div>"
                    $.each(data.obj,function(n,value){
                        result +="  <li><a href=\"table?provincecode="+title+"&searchKey=${info}&city="+value.name+"&nowpage=1\">"
                                +value.name+"</a></li>   ";
//                        result +="  <span class=\"am-badge\">"+value.name+"</span>   ";
                    });
                    $("#cityId").html('');
                    $("#cityId").append(result);
                }
            },"json");
        });




//        $(document).ready(function () {
//            $("#provinceId").change(function () {
//                var title = $("#provinceId").find("option:selected").text();
//                alert(title);
//                $('#hiden0').html('');
//                $('#hiden0').val(title);//追加value值
//                $.get("getCityByProvinceId/"+$("#provinceId").val(),function(data){
//                    if(data.status){
//                        var result = "<span class=\"am-badge am-badge-primary\"><h3>全部地区</h3></span>";
//                        var cityTest = "<div> </div>"
//                        $.each(data.obj,function(n,value){
//                            result +="  <span class=\"am-badge\">"+value.name+"</span>   ";
//                        });
//                        $("#cityId").html('');
//                        $("#cityId").append(result);
//                    }
//                },"json");
//            });

//        $("#cityId").change(function () {
////				解决插入数据库非中文问题
////				var title = $('#cityOption' ).attr("title");
////				获取选中的vlue值
//            var title = $("#cityId").find("option:selected").text();
////				alert(title);
//            $('#hiden1').html('');
//            $('#hiden1').val(title);//追加value值
//            $.get("getAreaByCityId/"+$("#cityId").val(),function(data){
//                if(data.status){
//                    var result = "<option>选择区域</option>";
//                    $.each(data.obj,function(n,value){
//                        result +="<option value='"+value.code+"'>"+value.name+"</option>";
//                    });
//                    $("#areaId").html('');
//                    $("#areaId").append(result);
//                }
//            },"json");
//        });
//        $("#areaId").change(function () {
//            var title = $("#areaId").find("option:selected").text();
////				alert(title);
//            $('#hiden2').html('');
//            $('#hiden2').val(title);
//
//        });

    });
</script>
