<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
        $.datepicker.setDefaults({
            showOn: "button",
            buttonImage: "../../images/calendar.png",
            buttonImageOnly: true
        });
        $("#publishDate").datepicker();
    });
</script>
<s:form id="editForm" action="updateRoutePrice" namespace="/routePrice" method="post">
    <s:hidden id="RECORD_ROUTE_ID" name="routePrice.routeID"/>
    <s:hidden id="RECORD_ID" name="routePrice.id"/>
    <s:hidden name="routePrice.version"/>
    <%--标题部分--%>
    <table class="pageHead">
        <tr>
            <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
            <th align="left" class="title_area">当前位置：编辑线路报价</th>
            <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
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
                <s:property escape="false" value="routePrice.route.productName.replaceAll('\n','<br>').trim()"/>
            </td>
            <td width="10%" class="pro_color2">出港地点:</td>
            <td width="40%">
                <s:property escape="false" value="routePrice.route.portOfDeparture.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">产品类别:</td>
            <td>
                <s:radio name="routePrice.route.productType" list="#{1:'特价',2:'常规',3:'尊品',4:'纯玩',5:'老年团'}"/>
            </td>
            <td class="pro_color2">年龄限制:</td>
            <td>
                <s:property escape="false" value="routePrice.route.ageLimit.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">购物:</td>
            <td>
                <s:property escape="false" value="routePrice.route.shopping.replaceAll('\n','<br>').trim()"/>
            </td>
            <td class="pro_color2">住宿标准:</td>
            <td>
                <s:property escape="false" value="routePrice.route.accomodationStandard.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">景点:</td>
            <td colspan="3">
                <s:property escape="false" value="routePrice.route.scenerySpot.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">赠送:</td>
            <td colspan="3">
                <s:property escape="false" value="routePrice.route.present.replaceAll('\n','<br>').trim()"/>
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
                <s:textfield name="routePrice.startFlightInfo" id="startFlightInfo" size="50"/>
            </td>
            <td width="10%" class="pro_color2">返程航班:</td>
            <td width="40%">
                <s:textfield name="routePrice.endFlightInfo" id="endFlightInfo" size="50"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="pro_color2">儿童门市价:</td>
            <td width="40%">
                <s:textfield name="routePrice.childenPrice" id="childenPrice" size="50"/>
            </td>
            <td width="10%" class="pro_color2">成人门市价:</td>
            <td width="40%">
                <s:textfield name="routePrice.adultPrice" id="adultPrice" size="50"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="pro_color2">人数限制:</td>
            <td width="40%">
                <s:textfield name="routePrice.totalPeople" id="totalPeople" size="50"/>
            </td>
            <td width="10%" class="pro_color2">出团日期:</td>
            <td width="40%" class="myDatepicker">
                <s:date name="routePrice.publishDate" format="yyyy-MM-dd"/>
            </td>
        </tr>
    </table>

    <table id="journeyInfo" width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
        <tr>
            <td class="pro_color1 f13" colspan="5"><b>行程安排</b></td>
        </tr>
        <tr>
            <th width="30px" class="pro_color3">序号</th>
            <th width="60px" class="pro_color3">交通</th>
            <th class="pro_color3">行程安排</th>
            <th width="80px" class="pro_color3">餐饮</th>
            <th width="80px" class="pro_color3">住宿</th>
        </tr>
            <%--循环输出 journeyList--%>
        <s:iterator value="routePrice.route.journeySet" id="journey" status="st">
            <tr class="journeyClass">
                <td class="center">
                    <s:property value='#st.index + 1'/>
                </td>
                <td>
                    <s:property escape="false" value="#journey.trafficName.replaceAll('\n','<br>').trim()"/>
                </td>
                <td>
                    <s:property escape="false" value="#journey.journeyInfo.replaceAll('\n','<br>').trim()"/>
                </td>
                <td>
                    <s:property escape="false" value="#journey.catering.replaceAll('\n','<br>').trim()"/>
                </td>
                <td>
                    <s:property escape="false" value="#journey.accomodation.replaceAll('\n','<br>').trim()"/>
                </td>
            </tr>
        </s:iterator>
    </table>

    <table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
        <tr>
            <td class="pro_color1 f13" colspan="4"><b>其他信息</b></td>
        </tr>
        <tr>
            <td class="pro_color2" width="10%">产品特色：</td>
            <td>
                <s:property escape="false" value="routePrice.route.productItem.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">服务标准：</td>
            <td>
                <s:property escape="false" value="routePrice.route.serviceStandard.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">特别说明：</td>
            <td>
                <s:property escape="false" value="routePrice.route.specialInstruction.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">温馨提示：</td>
            <td>
                <s:property escape="false" value="routePrice.route.friendlyTips.replaceAll('\n','<br>').trim()"/>
            </td>
        </tr>
    </table>

    <table width="90%" cellspacing="0" cellpadding="0" border="0" class="page_button">
        <tr>
            <td align="center" colspan="4">
                <input class="myButton" type="submit" style="width:65px" value="确认">
                <input class="myButton" type="button" style="width:65px" onclick="history.go(-1)" value="返回">
            </td>
        </tr>
    </table>
</s:form>
