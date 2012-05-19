<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    function addRoute() {
        window.location.href = "/route/initCreate.action";
    }

    function deleteRecord(id) {
        if (confirm('确定删除此记录吗？')) {
            window.location.href = "/route/delete.action?id=" + id;
        }
    }

    function update(id) {
        window.location.href = "/route/initUpdate.action?id=" + id;
    }

    function view(id) {
        window.location.href = "/route/view.action?id=" + id;
    }

    function publish(routeID) {
        window.location.href = "/routePrice/initPublishRoute.action?routeID=" + routeID;
    }
</script>

<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
        <th align="left" class="title_area">当前位置：线路列表</th>
        <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
    </tr>
</table>

<table class="mygrid">
    <tr class="myheader">
        <th width="30px"></th>
        <th width="80px">产品类别</th>
        <th>产品名称</th>
        <th width="80px">年龄限制</th>
        <th width="100px">出港地点</th>
        <th width="100px">住宿标准</th>
        <th width="180px">操作</th>
    </tr>
    <s:if test="routeList.size == 0">
        <tr>
            <td colspan="6" align="center">暂无相关数据</td>
            <td></td>
        </tr>
    </s:if>
    <s:else>
        <s:iterator value="routeList" id="route" status="st">
            <s:if test="#st.Even"><tr class="tr-even"></s:if>
            <s:else><tr class="tr-odd"></s:else>
            <td>
                <s:property value='#st.index + 1'/>
            </td>
            <td>
                <s:property escape="false" value="#route.productTypeName.replaceAll('\n','<br>').trim()"/>
            </td>
            <td class="td-operation">
                <a href="/route/view.action?id=<s:property value="#route.id"/>"><s:property escape="false" value="#route.productName.replaceAll('\n','<br>').trim()"/></a>
            </td>
            <td>
                <s:property escape="false" value="#route.ageLimit.replaceAll('\n','<br>').trim()"/>
            </td>
            <td>
                <s:property escape="false" value="#route.portOfDeparture.replaceAll('\n','<br>').trim()"/>
            </td>
            <td>
                <s:property escape="false" value="#route.accomodationStandard.replaceAll('\n','<br>').trim()"/>
            </td>
            <td class="td-myButtonBar">
                <input type="button" class="myButton" style="width:40" onclick="update('<s:property value="#route.id"/>')" value="修改">
                <input type="button" class="myButton" style="width:40" onclick="deleteRecord('<s:property value="#route.id"/>')" value="删除">
                <input type="button" class="myButton" style="width:40" onclick="view('<s:property value="#route.id"/>')" value="查看">
                <input type="button" class="myButton" style="width:60" onclick="publish('<s:property value="#route.id"/>')" value="发布线路">
            </td>
            </tr>
        </s:iterator>
    </s:else>
    <tr>
        <td colspan="6"></td>
        <td align="right" class="myButtonBar"><input type="button" class="myButton" style="width:40" onclick="addRoute()" value="添加线路"></td>
    </tr>
</table>
