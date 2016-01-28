var strFullPath=window.document.location.href;
var strPath=window.document.location.pathname;
var pos=strFullPath.indexOf(strPath);
var prePath=strFullPath.substring(0,pos);
var postPath=strPath.substring(0,strPath.substr(1).indexOf("/")+1);
var ctx = postPath;

var $company = $('#company-modal');
var $item = $('#item-modal');
var $staff = $('#staff-modal');
var $companyWithValue = null;
var $itemWithValue = null;
var $staffWithValue = null;

var confirm = $('#my-confirm');

var confirmBtn = confirm.find('[data-am-modal-confirm]');
var cancelBtn = confirm.find('[data-am-modal-cancel]');
//todo:部分中文乱码
$(function () {
    init();

    drag();

    drop();
});

var staff = null;

function drag() {
    //$( ".sortable");
    //$( ".sortable" ).sortable({
    //  revert: true
    //});
    $(".draggable").draggable({
        connectToSortable: "#sortable",
        helper: "clone",
        revert: "invalid"


    });

    //$( ".sortable" ).disableSelection();
}

function drop() {
    //$( ".sortable");
    //$( ".sortable" ).sortable({
    //  revert: true
    //});

    $(".droppable").droppable({
        drop: function (event, ui) {
            var $target = $(event.target);
            itemId = $target.find("#itemId").val();

            $target.siblings().addClass("am-in");

            var $itemStaffLink = $target.siblings().find('#itemStaffLink');

            $source = ui.draggable.parent();
            companyId_StaffIdStr = $source.attr("id");
            var companyId_StaffIdArray = companyId_StaffIdStr.split("-", 2);
            companyId = companyId_StaffIdArray[0].match(/[1-9][0-9]*/g);
            staffId = companyId_StaffIdArray[1].match(/[1-9][0-9]*/g);

            var staffName = ui.draggable.text();
            if ($itemStaffLink.find("#" + staffId).size() == 0 || staffName != $itemStaffLink.find("#" + staffId).text()) {
                var result = "<div id='" + staffId + "' class='am-btn-success'><input type='hidden' value='" + staffId + "'>" + staffName + "</div>"

                $itemStaffLink.append(result);
                //保存到数据库
                $.post(ctx + "/item/insertItemStaffLink?itemId=" + itemId + "&staffId=" + staffId);
            }
        }
    });

    //$( ".sortable" ).disableSelection();
}


function init() {
    $('.js-modal-insert').on('click', function (e) {
        var $target = $(e.target);

        if (($target).hasClass('company')) {
            $company.find("#company-modal-title").text("添加公司");
            $company.find("#companyName").val("");
            $company.find("#address").val("");
            $company.find("#companyScale").val("");
            $company.find("#lawPerson").val("");
            $company.find("#telephone").val("");
            $company.find("#intro").val("");
            $company.find("#url").val("");
            $company.find("#provinceId").find("option[value='']").attr("selected", true);
            $company.find("#cityId").find("option[value='']").attr("selected", true);
            $item.find("#item-modal-button").attr("onclick", "insertcompany();");
            $company.find("#company-modal-button").val("保存公司");
            $company.css("width", "800");
            $company.modal('open');
        } else if (($target).hasClass('item')) {
            var companyId = $target.siblings('input').val();
            $item.find("#item-modal-title").text("添加服务");
            $item.find("#itemName").val("");
            $item.find("#itemCost").val("");
            $item.find("#itemMinCost").val("");
            $item.find("#itemMaxCost").val("");
            $item.find("#itemIntro").val("");
            $item.find("#item-modal-button").attr("onclick", "insertItem();");
            $item.find("#item-modal-button").val("保存服务");
            $item.find('#itemBindCompanyId').val(companyId);
            $item.css("width", "800");
            $item.modal('open');

        } else if (($target).hasClass('staff')) {
            var companyId = $target.siblings('input').val();
            $staff.find("#staff-modal-title").text("添加员工");
            $staff.find('#staffId').val("");
            $staff.find("#staffName").val("");
            $staff.find("#staffPhone").val("");
            $staff.find("#staffQQ").val("");
            $staff.find("#email").val("");
            $staff.find("#weichat").val("");
            $staff.find("#staff-modal-button").attr("onclick", "insertStaff();");
            $staff.find("#staff-modal-button").val("保存员工");
            $staff.find('#staffBindCompanyId').val(companyId);
            $staff.css("width", "620");
            $staff.modal('open');
        }
    });

    $('.js-modal-edit').on('click', function (e) {
        var $target = $(e.target);

        if (($target).hasClass('company')) {
            $companyWithValue = $target.parent();
            companyId = $companyWithValue.find("#edit-companyId").val();
            $.ajax({
                url: ctx + "/company/select?companyId=" + companyId,
                async: true,
                cache: false,
                type: "POST",
                dataType: "json",
                success: function (agencyCompany) {
                    $company.find("#company-modal-title").text("编辑公司");
                    $company.find("#companyName").val(agencyCompany.companyName);
                    $company.find("#form-company").append("<input type=\"text\" name=\"companyId\" style=\"display:none\" value=\""+companyId+"\" >");
                    $company.find("#address").val(agencyCompany.address);
                    $company.find("#companyScale").val(agencyCompany.companyScale);
                    $company.find("#lawPerson").val(agencyCompany.lawPerson);
                    $company.find("#telephone").val(agencyCompany.telephone);
                    $company.find("#intro").val(agencyCompany.intro);
                    $company.find("#url").val(agencyCompany.url);
                    $company.find("#provinceId").find("option[value='" + agencyCompany.province + "']").attr("selected", true);
                    //todo:省回显数据没问题，市区和县城有问题，稍后修改
                    $company.find("#cityId").find("option[value='" + agencyCompany.city + "']").attr("selected", true);
                    $company.find("#areaId").find("option[value='" + agencyCompany.county + "']").attr("selected", true);
                    $company.find("#company-modal-button").val("保存修改");

                }
            });
            $company.find("#company-modal-title").text("编辑公司");
            $company.find("#companyName").val(companyName);
            $company.find("#address").val(companyAddress);
            $company.find("#companyScale").val(companyScale);
            $company.find("#company-modal-button").attr("onclick", "editCompany(" + companyId + ");");
            $company.find("#company-modal-button").val("保存修改");
            $company.css("width", "800");
            $company.text();
            $company.modal('open');
        } else if (($target).hasClass('item')) {
            $itemWithValue = $target.parent();
            itemId = $itemWithValue.find("#itemId").val();
            companyId = $itemWithValue.find("#companyId").val();
            $.ajax({
                url: ctx + "/item/select?itemId="+itemId,
                async: true,
                cache: false,
                type: "POST",
                dataType: "json",
                success: function (agencyItems) {
                    $item.find("#item-modal-title").text("编辑服务");
                    $item.find("#itemName").val(agencyItems.itemName);
                    $item.find("#itemCost").val(agencyItems.cost);
                    $item.find("#itemMinCost").val(agencyItems.minCost);
                    $item.find("#itemMaxCost").val(agencyItems.maxCost);
                    $item.find("#itemIntro").val(agencyItems.intro);
                    $item.find("#item-modal-button").attr("onclick", "editItem(" + companyId + "," + itemId + ");");
                    $item.find("#item-modal-button").val("保存修改");
                    $item.css("width", "800");
                    $item.modal('open');

                }
            });


        } else if (($target).hasClass('staff')) {
            $staffWithValue = $target.parent();
            companyId_StaffIdStr = $staffWithValue.attr("id"); //company259-staff318
            var companyId_StaffIdArray = companyId_StaffIdStr.split("-", 2);
            companyId = companyId_StaffIdArray[0].match(/[1-9][0-9]*/g);
            staffId = companyId_StaffIdArray[1].match(/[1-9][0-9]*/g);
            $.ajax({
                url: ctx + "/staff/select?staffId="+staffId,
                async: true,
                cache: false,
                type: "POST",
                dataType: "json",
                success: function (agencyStaff) {
                    $staff.find('#staffId').val(staffId);
                    $staff.find("#staff-modal-title").text("编辑员工");
                    $staff.find("#staffName").val(agencyStaff.name);
                    $staff.find("#staffPhone").val(agencyStaff.phone);
                    $staff.find("#staffQQ").val(agencyStaff.qq);
                    $staff.find("#email").val(agencyStaff.email);
                    $staff.find("#weichat").val(agencyStaff.weichat);
                    $staff.find("#staff-modal-button").attr("onclick", "editStaff(" + companyId + "," + staffId + ");");
                    $staff.find("#staff-modal-button").val("保存修改");
                    $staff.css("width", "620");
                    $staff.modal('open');

                }
            });


        }
    });
}

function insertCompany() {
    var companyBox = $('#companyList');
    var $form = $('#form-company');
    $.ajax({
        url:  ctx + "/company/insert",
        async: true,
        cache: false,
        type: "post",
        data: $form.serialize(),
        dataType: "json",
        success: function (agencyCompany) {
            var result = "<div id=\"company" + agencyCompany.companyId + "\" class=\"am-panel-collapse am-collapse am-in\">"
                + "<div class=\"am-panel am-panel-default am-panel-group\">"
                + "<div class=\"am-g\">"
                + "<div class=\"am-panel am-panel-default\">"
                + "<div class=\"am-panel-hd\">"
                + "<div>"
                + "  <input id=\"ipt-" + agencyCompany.companyId + "\" type=\"hidden\" value=\"" + agencyCompany.companyId + "\">"
                + "  <label>" + agencyCompany.companyName + "</label>"
                + "  <button class=\"am-fr am-icon-arrow-circle-down\" data-am-collapse=\"{parent: '#accordion', target: '#company" + agencyCompany.companyId + "-itemAndStaffList'}\"></button>"
                + "  <button class=\"am-fr am-icon-close\" onclick=\"removeCompany(" + agencyCompany.companyId + ")\"></button>"
                + "  <button class=\"am-fr am-icon-edit js-modal-edit company\"></button> <input id=\"edit-companyId\" style=\"display:none\" value=\""+agencyCompany.companyId+"\">"
                + "<br>"
                + "        公司地址 :"
                + "          <div style=\"display: inline\" id=\"companyAddress\">" + agencyCompany.address + "</div>"
                + "      <br>"
                + "        公司规模 :"
                + "          <div style=\"display: inline\" id=\"companyScale\">" + agencyCompany.companyScale + "</div>"
                + "</div>"
                + "</div>"
                + "<div id=\"company" + agencyCompany.companyId + "-itemAndStaffList\" class=\"am-panel-collapse am-collapse am-in\">"
                + "<div class=\"am-u-md-8\">"
                + "  <input id=\"company" + agencyCompany.companyId + "\" class=\"companyId\" type=\"hidden\" value=\"" + agencyCompany.companyId + "\">"
                + "  <h4 class=\"am-btn am-btn-danger am-btn-block am-icon-plus-circle js-modal-insert item\">添加服务 </h4>"
                + "  <div id=\"company" + agencyCompany.companyId + "-itemList\">"
                + "      <a id=\"company" + agencyCompany.companyId + "-item-null\" href=\"#\" class=\"am-btn am-btn-primary am-disabled\">对不起，该公司下没有关联任何服务。 </a>"
                + "  </div>"
                + "</div>"
                + "<div class=\"am-u-md-4\">"
                + "  <input id=\"company" + agencyCompany.companyId + "\" class=\"companyId\" type=\"hidden\" value=\"" + agencyCompany.companyId + "\">"
                + "  <h4 class=\"am-btn am-btn-danger am-btn-block am-icon-user-plus js-modal-insert staff\">添加员工 </h4>"
                + "  <div class=\"am-panel-collapse\">"
                + "    <ul id=\"company" + agencyCompany.companyId + "-staffList\" class=\"am-list am-list-static\">"
                + "     <a id=\"company" + agencyCompany.companyId + "-staff-null\" href=\"#\" class=\"am-btn am-btn-primary am-disabled\">该公司下没有任何的人员哦。</a>";
            +"    </ul>"
            + "  </div>"
            + "</div>"
            + "</div>"
            + "</div>"

            + "</div>"

            + "</div>"
            + "</div>"


            companyBox.prepend(result);

            $company.modal('close');
            init();
        },

    });

    return false;
}

function insertItem() {
    var $form = $("#form-item");
    var companyId = $form.find('#itemBindCompanyId').val();
    var $itemBox = $("#company" + companyId + "-itemList");
    var $a = $("#company" + companyId + "-item-null");

    $.ajax({
        url: ctx + "/item/insert",
        async: true,
        cache: true,
        type: "POST",
        data: $form.serialize(),
        dataType: "json",
        success: function (agencyItems) {
            if ($a != null)
                $a.remove();

            var result = "<div id=\"company" + companyId + "-item" + agencyItems.itemId + "\" class=\"am-panel am-panel-default\">"
                + "  <div class=\"am-panel-hd droppable\">"
                + "   <input id=\"itemId\" type=\"hidden\" value=\"" + agencyItems.itemId + "\"/>"
                + "        <input id=company" + companyId + "-items" + agencyItems.itemId + " type=\"hidden\" value='" + agencyItems.itemId + "'/>"
                + "        <label>" + agencyItems.itemName + "</label>"
                + "        <button class=\"am-fr am-icon-arrow-circle-down\" data-am-collapse=\"{parent: '#accordion', target: '#ctx-company" + companyId + "-items" + agencyItems.itemId + "'}\"></button>"
                + "        <button class=\"am-fr am-icon-remove\" onclick=\"removeItem(" + companyId + "," + agencyItems.itemId + ")\"></button>"
                + "        <button class=\"am-fr am-icon-edit js-modal-edit item\"></button>"
                + "  </div>"
                + "  <div id=\"ctx-company" + companyId + "-items" + agencyItems.itemId + "\" class=\"am-panel-collapse am-collapse n am-in am-panel-bd\">"
                + "        服务价格 ："
                + "  <div style=\"display: inline\" id=\"itemCost\">" + agencyItems.cost + " 元</div>"
                + "    <div id='itemStaffLink'></div>"
                + "  </div>"
                + "</div>";

            $itemBox.prepend(result);
            $item.modal('close');

            drop();

            init();
        }
    });
}

function insertStaff() {
    var $form = $("#form-staff");
    var companyId = $form.find('#staffBindCompanyId').val();
    var $ul = $("#company" + companyId + "-staffList");
    var $a = $("#company" + companyId + "-staff-null");

    $.ajax({
        url: ctx + "/staff/insert",
        async: true,
        cache: false,
        type: "POST",
        data: $form.serialize(),
        dataType: "json",
        success: function (agencyStaff) {
            if ($a != null)
                $a.remove();

            var result = "<li id=\"company" + companyId + "-staff" + agencyStaff.staffId + "\">"
                + " <span id=\"staffName\" class=\"draggable\" style=\"cursor: move; background: #4cae4c;\">" + agencyStaff.name + "</span>"
                + " <span id=\"phone\">" + agencyStaff.phone + "</span>"
                + " <button class=\"am-fr am-icon-remove\" onclick=\"removeStaff(" + companyId + "," + agencyStaff.staffId + ")\"></button>"
                + " <button class=\"am-fr am-icon-edit js-modal-edit staff\"></button>"
                + " </li>";
            $ul.prepend(result);

            $("#staff-modal").modal('close');

            drag();

            init();
        }
    });
}

function removeCompany(companyId) {
    var $company = $('#company' + companyId);

    confirmBtn.click(function () {
        $.ajax({
            url: ctx + "/company/remove",
            async: true,
            cache: false,
            type: "POST",
            data: {"companyId": companyId},
            dataType: "text",
            success: function () {
                $company.remove();
            }
        });
    });

    cancelBtn.click(function () {

    });

    confirm.modal('open');
}

function removeItem(companyId, itemId) {
    var $item = $('#company' + companyId + "-item" + itemId);

    confirmBtn.click(function () {
        $.ajax({
            url: ctx + "/item/remove",
            async: true,
            cache: false,
            type: "POST",
            data: {
                "companyId": companyId,
                "itemId": itemId
            },
            dataType: "text",
            success: function () {
                if ($item != null || $item.size() != 0)
                    $item.remove();

            }
        });
    });

    cancelBtn.click(function () {

    });

    confirm.modal('open');
}

function removeStaff(companyId, staffId) {
    var $staff = $('#company' + companyId + "-staff" + staffId);

    confirmBtn.click(function () {
        $.ajax({
            url: ctx + "/staff/delete",
            async: true,
            cache: false,
            type: "POST",
            data: {
                "companyId": companyId,
                "staffId": staffId
            },
            dataType: "json",
            success: function () {
                if ($staff != null)
                    $staff.remove();
            }
        });
    });

    cancelBtn.click(function () {

    });

    confirm.modal('open');
}

function editCompany(companyId) {
    var $form = $("#form-company");
    var $li = $("#company" + companyId );

    $.ajax({
        url: ctx + "/company/update",
        async: true,
        cache: false,
        type: "POST",
        data: $form.serialize(),
        dataType: "json",
        success: function (agencyCompany) {
            $li.find("#companyName").text(agencyCompany.companyName);
            $li.find("#companyAddress").text(agencyCompany.address);

            $("#company-modal").modal('close');


        }
    });
}

function editItem(companyId, itemId) {
    var $form = $("#form-staff");
    var $li = $("#company" + companyId + "-item" + itemId);

    $("#item-modal-button").bind("click", function () {
        var itemName = $("#itemName").val();
        var itemCost = $("#itemCost").val();
        var itemMinCost = $("#itemMinCost").val();
        var itemMaxCost = $("#itemMaxCost").val();
        var itemIntro = $("#itemIntro").val();
        $.ajax({
            url: ctx + "/item/update?itemId=" + itemId + "&itemName=" + itemName + "&cost=" + itemCost + "&minCost=" + itemMinCost + "&maxCost=" + itemMaxCost + "&intro=" + itemIntro,
            async: true,
            cache: false,
            type: "POST",
            dataType: "json",
            success: function (agencyItems) {
                $li.find("#itemName").text(agencyItems.itemName);
                $li.find("#itemCost").text(agencyItems.cost);
                $li.find("#itemMinCost").text(agencyItems.minCost);
                //itemCost = $itemWithValue.parent().find("#itemCost").text();
                //minCost = $itemWithValue.parent().find("#minCost").text();
                //maxCost = $itemWithValue.parent().find("#maxCost").text();
                //itemIntro = $itemWithValue.parent().find("#itemIntro").text();

                $("#item-modal").modal('close');


            }
        });
    })
}

function editStaff(companyId, staffId) {
    var $form = $("#form-staff");
    var $li = $("#company" + companyId + "-staff" + staffId);//$("#company259-staff330")

    $.ajax({
        url: ctx + "/staff/update",
        async: true,
        cache: false,
        type: "POST",
        data: $form.serialize(),
        dataType: "json",
        success: function (agencyStaff) {
            $li.find("#staffName").text(agencyStaff.name);
            $li.find("#phone").text(agencyStaff.phone);

            $("#staff-modal").modal('close');

            drag();
        }
    });
}
