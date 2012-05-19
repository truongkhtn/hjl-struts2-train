<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
        <th align="left" class="title_area">当前位置：查看订单</th>
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
            <s:property escape="false" value="order.routePrice.route.accomodationStandard.replaceAll('\n','<br>').trim()"/>
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
            <s:property escape="false" value="order.adultCount.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">儿童人数:</td>
        <td width="40%">
            <s:property escape="false" value="order.childenCount.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">组团操作人:</td>
        <td width="40%">
            <s:property escape="false" value="order.operator.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">联系电话:</td>
        <td width="40%">
            <s:property escape="false" value="order.contactTel.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">订单状态:</td>
        <td width="40%">
            <s:property escape="false" value="order.statusName.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">备注说明:</td>
        <td width="40%">
            <s:property escape="false" value="order.memo.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
</table>
<%--旅客信息--%>
<table id="travellerInfo" width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="8"><b>旅客信息</b></td>
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
    </tr>
    <%--循环输出 travellerInfoList--%>
    <s:iterator value="order.travellerInfoList" id="travellerInfo" status="st">
        <tr class="travellerInfoClass">
            <td class="center"><s:property value='#st.index + 1'/></td>
            <td><s:property escape="false" value="#travellerInfo.traverName.replaceAll('\n','<br>').trim()"/></td>
            <td><s:property escape="false" value="#travellerInfo.sexName.replaceAll('\n','<br>').trim()"/></td>
            <td><s:property escape="false" value="#travellerInfo.peopleTypeName.replaceAll('\n','<br>').trim()"/></td>
            <td><s:property escape="false" value="#travellerInfo.certificateTypeName.replaceAll('\n','<br>').trim()"/></td>
            <td><s:property escape="false" value="#travellerInfo.certificateNumber.replaceAll('\n','<br>').trim()"/></td>
            <td><s:property escape="false" value="#travellerInfo.contactTel.replaceAll('\n','<br>').trim()"/></td>
            <td><s:property escape="false" value="#travellerInfo.memo.replaceAll('\n','<br>').trim()"/></td>
        </tr>
    </s:iterator>
</table>

<table width="90%" cellspacing="0" cellpadding="0" border="0" class="page_button">
    <tr>
        <td align="center" colspan="4">
            <input class="myButton" type="button" style="width:65px" onclick="history.go(-1)" value="返回">
        </td>
    </tr>
</table>