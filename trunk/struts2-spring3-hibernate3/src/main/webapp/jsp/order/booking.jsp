<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        $("#btnAddTraveller").click(function() {
            var index = $("#travellerInfo tr::last-child").index();
            var num = Number(index) - Number(1);
            $("<tr class='travellerInfoClass'></tr>").appendTo($("#travellerInfo"));
            $lastTr = $("#travellerInfo tr::last-child");
            $('<td class="center">' + index + '</td>').appendTo($lastTr);
            $('<td><input type="text" class="travellerInfo-traverName" name="order.travellerInfoList[' + num + '].traverName" value="" size="8"></td>').appendTo($lastTr);
            $('<td><select class="travellerInfo-sex" name="order.travellerInfoList[' + num + '].sex"><option selected="selected" value="1">男</option><option value="2">女</option></select></td>').appendTo($lastTr);
            $('<td><select class="travellerInfo-peopleType" name="order.travellerInfoList[' + num + '].peopleType" onchange="calculate()"><option value="1">成人</option><option value="2">儿童</option></select></td>').appendTo($lastTr);
            $('<td><select class="travellerInfo-certificateType" name="order.travellerInfoList[' + num + '].certificateType"><option value="1">身份证</option><option value="2">护照</option></select></td>').appendTo($lastTr);
            $('<td><input type="text" class="travellerInfo-certificateNumber" value="" size="18" name="order.travellerInfoList[' + num + '].certificateNumber"></td>').appendTo($lastTr);
            $('<td><input type="text" class="travellerInfo-contactTel" value="" size="14" name="order.travellerInfoList[' + num + '].contactTel"></td>').appendTo($lastTr);
            $('<td><input type="text" class="travellerInfo-memo" value="" size="30" name="order.travellerInfoList[' + num + '].memo"></td>').appendTo($lastTr);
            $('<td><input type="button" value="删除" onclick="delete_travellerInfo(this);" style="width:65px" class="myButton"></td>').appendTo($lastTr);
            calculate();
        });

        $("#editForm").submit(function() {
            if ($("#RECORD_ID").val() == "") {
                $("#editForm").attr('action', '/order/booking.action');
            } else {
                $("#editForm").attr('action', '/order/updateBooking.action');
            }
            return true;
        });

        calculate();

    });

    //删除traveller tr
    function delete_travellerInfo(obj) {
        $tr = $(obj).parent().parent();
        if (hasContent($tr)) {
            if (confirm("确认要删除吗？")) {
                $tr.remove();
            }
        } else {
            $tr.remove();
        }
        refresh_traveller();
        calculate();
    }

    //判断tr中是否含有任何一个数据
    function hasContent(tr) {
        if (tr.find('.travellerInfo-traverName').val() != "" ||
                tr.find('.travellerInfo-sex').val() != "" ||
                tr.find('.travellerInfo-peopleType').val() != "" ||
                tr.find('.travellerInfo-certificateType').val() != "" ||
                tr.find('.travellerInfo-certificateNumber').val() != "" ||
                tr.find('.travellerInfo-contactTel').val() != "" ||
                tr.find('.travellerInfo-memo').val() != "") {
            return true;
        }
        return false;
    }

    //刷新 traveller tr 排序
    function refresh_traveller() {
        var num = 0;
        $("#travellerInfo .travellerInfoClass").each(function() {
            $(this).children('td').eq(0).text(num + 1);
            $(this).find('.travellerInfo-traverName').attr("name", 'order.travellerInfoList[' + num + '].traverName');
            $(this).find('.travellerInfo-sex').attr("name", 'order.travellerInfoList[' + num + '].sex');
            $(this).find('.travellerInfo-peopleType').attr("name", 'order.travellerInfoList[' + num + '].peopleType');
            $(this).find('.travellerInfo-certificateType').attr("name", 'order.travellerInfoList[' + num + '].certificateType');
            $(this).find('.travellerInfo-certificateNumber').attr("name", 'order.travellerInfoList[' + num + '].certificateNumber');
            $(this).find('.travellerInfo-contactTel').attr("name", 'order.travellerInfoList[' + num + '].contactTel');
            $(this).find('.travellerInfo-memo').attr("name", 'order.travellerInfoList[' + num + '].memo');
            num++;
        });
    }

    //计算人员数
    function calculate(){
        var adult = 0;
        var childen = 0;
        $("#travellerInfo .travellerInfoClass").each(function() {
            var v = $(this).find('.travellerInfo-peopleType').val();
            if(v == 1){
                adult ++;
            }else if(v ==2 ){
                childen ++;
            }
        });
        $("#adultCount").val(adult);
        $("#childenCount").val(childen);
    }
</script>

<s:form id="editForm" action="booking" namespace="/order" method="post">
<s:hidden id="RECORD_ID" name="order.id"/>
<s:hidden id="RECORD_ROUTE_PRICE_ID" name="order.routePriceID"/>
<s:hidden id="RECORD_USER_ID" name="order.userID"/>
<s:hidden name="order.version"/>
<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
        <th align="left" class="title_area">当前位置：线路预订</th>
        <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
    </tr>
</table>
<%--旅行社信息--%>
<table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="4"><b>旅行社信息</b></td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">旅行社名称:</td>
        <td width="40%">
            <s:property escape="false" value="order.user.companyName.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">联系地址:</td>
        <td width="40%">
            <s:property escape="false" value="order.user.companyAddress.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">联系人:</td>
        <td width="40%">
            <s:property escape="false" value="order.user.name.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">联系电话:</td>
        <td width="40%">
            <s:property escape="false" value="order.user.phone.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
</table>

<%--产品信息--%>
<table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="4"><b>基本信息</b></td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">产品名称:</td>
        <td width="40%">
            <s:property escape="false" value="order.routePrice.route.productName.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">出港地点:</td>
        <td width="40%">
            <s:property escape="false" value="order.routePrice.route.portOfDeparture.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td class="pro_color2">产品类别:</td>
        <td>
            <s:radio name="order.routePrice.route.productType" list="#{1:'特价',2:'常规',3:'尊品',4:'纯玩',5:'老年团'}"/>
        </td>
        <td class="pro_color2">年龄限制:</td>
        <td>
            <s:property escape="false" value="order.routePrice.route.ageLimit.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td class="pro_color2">购物:</td>
        <td>
            <s:property escape="false" value="order.routePrice.route.shopping.replaceAll('\n','<br>').trim()"/>
        </td>
        <td class="pro_color2">住宿标准:</td>
        <td>
            <s:property escape="false"
                        value="order.routePrice.route.accomodationStandard.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td class="pro_color2">景点:</td>
        <td colspan="3">
            <s:property escape="false" value="order.routePrice.route.scenerySpot.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td class="pro_color2">赠送:</td>
        <td colspan="3">
            <s:property escape="false" value="order.routePrice.route.present.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
</table>

<%--价格信息--%>
<table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="4"><b>价格信息</b></td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">去程航班:</td>
        <td width="40%">
            <s:property escape="false" value="order.routePrice.startFlightInfo.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">返程航班:</td>
        <td width="40%">
            <s:property escape="false" value="order.routePrice.endFlightInfo.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">儿童门市价:</td>
        <td width="40%">
            <s:property escape="false" value="order.routePrice.childenPrice.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">成人门市价:</td>
        <td width="40%">
            <s:property escape="false" value="order.routePrice.adultPrice.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">人数限制:</td>
        <td width="40%">
            <s:property escape="false" value="order.routePrice.totalPeople.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">出团日期:</td>
        <td width="40%" class="myDatepicker">
            <s:date name="order.routePrice.publishDate" format="yyyy-MM-dd"/>
        </td>
    </tr>
</table>

<%--预订信息--%>
<table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="4"><b>预订信息</b></td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">成人人数:</td>
        <td width="40%">
            <s:textfield name="order.adultCount" id="adultCount" size="30" readonly="true"/>
        </td>
        <td width="10%" class="pro_color2">儿童人数:</td>
        <td width="40%">
            <s:textfield name="order.childenCount" id="childenCount" size="30" readonly="true"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">组团操作人:</td>
        <td width="40%">
            <s:textfield name="order.operator" id="operator" size="30"/>
        </td>
        <td width="10%" class="pro_color2">联系电话:</td>
        <td width="40%">
            <s:textfield name="order.contactTel" id="contactTel" size="30"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">订单状态:</td>
        <td width="40%">
            <s:hidden id="STATUS" name="order.status"/>
            <s:property escape="false" value="order.statusName.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">备注说明:</td>
        <td width="40%">
            <s:textfield name="order.memo" id="contactTel" size="60"/>
        </td>
    </tr>
</table>
<%--旅客信息--%>
<table id="travellerInfo" width="100%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="8"><b>旅客信息</b></td>
        <td class="pro_color1 f13">
            <input id="btnAddTraveller" class="myButton" type="button" style="width:65px" value="+ 添加旅客">
        </td>
    </tr>
    <tr>
        <th width="40px" class="pro_color3">序号</th>
        <th width="90px" class="pro_color3">姓名</th>
        <th width="60px" class="pro_color3">性别</th>
        <th width="80px" class="pro_color3">成人/儿童</th>
        <th width="100px" class="pro_color3">证件类型</th>
        <th width="160px" class="pro_color3">证件号码</th>
        <th width="120px" class="pro_color3">联系电话</th>
        <th class="pro_color3">备注</th>
        <th width="80px" class="pro_color3">操作</th>
    </tr>
        <%--循环输出 travellerInfoList--%>
    <s:iterator value="order.travellerInfoList" id="travellerInfo" status="st">
        <tr class="travellerInfoClass">
            <td class="center"><s:property value='#st.index + 1'/></td>
            <td><s:textfield name="order.travellerInfoList[%{#st.index}].traverName" size="8"
                             cssClass="travellerInfo-traverName"/></td>
            <td><s:select name="order.travellerInfoList[%{#st.index}].sex" list="#{'1':'男','2':'女'}"
                          cssClass="travellerInfo-sex"/></td>
            <td><s:select name="order.travellerInfoList[%{#st.index}].peopleType"
                          list="#{'1':'成人','2':'儿童'}"
                          cssClass="travellerInfo-peopleType" onchange="calculate()"/></td>
            <td><s:select name="order.travellerInfoList[%{#st.index}].certificateType" list="#{'1':'身份证','2':'护照'}"
                          cssClass="travellerInfo-certificateType"/></td>
            <td><s:textfield name="order.travellerInfoList[%{#st.index}].certificateNumber" size="18"
                             cssClass="travellerInfo-certificateNumber"/></td>
            <td><s:textfield name="order.travellerInfoList[%{#st.index}].contactTel" size="14"
                             cssClass="travellerInfo-contactTel"/></td>
            <td><s:textfield name="order.travellerInfoList[%{#st.index}].memo" size="30"
                             cssClass="travellerInfo-memo"/></td>
            <td><input class="myButton" type="button" style="width:65px" onclick="delete_travellerInfo(this);"
                       value="删除"></td>
        </tr>
    </s:iterator>
</table>

<table width="100%" cellspacing="0" cellpadding="0" border="0" class="page_button">
    <tr>
        <td align="center" colspan="4">
            <input class="myButton" type="submit" style="width:65px" value="确认">
            <input class="myButton" type="button" style="width:65px" onclick="history.go(-1)" value="返回">
        </td>
    </tr>
</table>

</s:form>
