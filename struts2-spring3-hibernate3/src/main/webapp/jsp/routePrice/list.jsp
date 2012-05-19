<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    function deleteRecord(id) {
        if (confirm('确定删除此记录吗？')) {
            window.location.href = "/routePrice/delete.action?id=" + id;
        }
    }
    function update(id) {
        window.location.href = "/routePrice/initUpdateRoutePrice.action?id=" + id;
    }

    function view(id) {
        window.location.href = "/routePrice/view.action?id=" + id;
    }

    function booking(id) {
        window.location.href = "/order/initBooking.action?routePriceID=" + id;
    }
</script>

<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
        <th align="left" class="title_area">当前位置：线路报价</th>
        <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
    </tr>
</table>
<table class="mygrid">
    <tr class="myheader">
        <th width="30px"></th>
        <th width="60px">产品类别</th>
        <th width="80px">出团日期</th>
        <th>产品名称</th>
        <th width="150px">航班信息</th>
        <th width="140px">门市价格</th>
        <th width="40px">人数</th>
        <th width="155px">操作</th>
    </tr>

    <s:if test="pager.list.size == 0">
        <tr>
            <td colspan="7" align="center">暂无相关数据</td>
            <td></td>
        </tr>
    </s:if>
    <s:else>
        <s:iterator value="pager.list" id="routePrice" status="st">
        <%--<s:iterator value="routePriceList" id="routePrice" status="st">--%>
            <s:if test="#st.Even">
                <tr class="tr-even">
            </s:if>
            <s:else>
                <tr class="tr-odd">
            </s:else>
            <td>
                <s:property value='#st.index + 1'/>
            </td>
            <td>
                <s:property escape="false" value="#routePrice.route.productTypeName.replaceAll('\n','<br>').trim()"/>
            </td>
            <td>
                <s:date name="#routePrice.publishDate" format="yyyy-MM-dd" />
            </td>
            <td class="td-operation">
                <a href="/routePrice/view.action?id=<s:property value="#routePrice.id"/>"><s:property escape="false" value="#routePrice.route.productName.replaceAll('\n','<br>').trim()"/></a>
            </td>
            <td>
                <s:property escape="false" value="'往：' + #routePrice.startFlightInfo.replaceAll('\n','<br>').trim()"/><br>
                <s:property escape="false" value="'返：' + #routePrice.endFlightInfo.replaceAll('\n','<br>').trim()"/>
            </td>
            <td>
                <s:property escape="false" value="'儿童价：' + #routePrice.childenPrice.replaceAll('\n','<br>').trim()"/><br>
                <s:property escape="false" value="'成人价：' + #routePrice.adultPrice.replaceAll('\n','<br>').trim()"/>
            </td>
            <td>
                <s:property escape="false" value="#routePrice.totalPeople.replaceAll('\n','<br>').trim()"/>
            </td>
            <td class="td-myButtonBar">
                <input type="button" class="myButton" style="width:40" onclick="update('<s:property value="#routePrice.id"/>')" value="修改">
                <input type="button" class="myButton" style="width:40" onclick="deleteRecord('<s:property value="#routePrice.id"/>')" value="删除">
                <input type="button" class="myButton" style="width:40" onclick="view('<s:property value="#routePrice.id"/>')" value="查看">
                <input type="button" class="myButton" style="width:40" onclick="booking('<s:property value="#routePrice.id"/>')" value="预定">
            </td>
            </tr>
        </s:iterator>
        <tr>
            <td colspan="8">
                <s:include value="../common/pager.jsp"/>
            </td>
        </tr>
    </s:else>
</table>
