<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        //日期控件
        $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
        $.datepicker.setDefaults({
            showOn: "button",
            buttonImage: "../../images/calendar.png",
            buttonImageOnly: true
        });
        $("#FROM_DATE").datepicker();
        $("#TO_DATE").datepicker();

        //定义弹出框
        $("#infoDialog").dialog({
            autoOpen: false,
            show: "highlight",
            hide: "none",
            height:100,
            width:150
        });
    });

    function deleteRecord(id) {
        if (confirm('确定删除此记录吗？')) {
            window.location.href = "/order/delete.action?id=" + id;
        }
    }

    function update(id, status) {
        if (status != '1') {
            alert("只能修改未确认的订单!");
            return;
        }
        window.location.href = "/order/initUpdate.action?id=" + id;
    }

    function view(id) {
        window.location.href = "/order/view.action?id=" + id;
    }

    function updateOrderStatus(id, status) {
        $.ajax({
            url: "/order/updateOrderStatusAjax.action",
            data: {"id":id, "status": status},
            dataType: "json",
            async: true,
            success: function(data) {
                var position =  $("#"+id).position();
                $("#infoDialog").dialog("option", "position", ["center", position.top]);
                $("#infoDialog").dialog("open");
                updateRecordText(id,status);
                //1500ms后消失
                setTimeout(function() {
                    $("#infoDialog").dialog("close");
                }, 1500);
            } ,
            error:function() {
                alert("操作失败,请联系管理员!");
            }
        });
    }

    //根据 id 找到 tr , 更新订单状态
    function updateRecordText(id,status){
        //1:未确认 , 2:已确认 , 3:已取消
        var newText;
        if(status == 1){
            newText = "未确认";
        }else if(status == 2){
            newText = "已确认";
        }else if(status == 3){
            newText = "已取消";
        }
        var message = "订单状态:"+newText;
        $("#infoDialog").find("p").text(message);
        $("#"+id).find(".status-class").text(newText);
    }

</script>

<%--弹出框div--%>
<div id="infoDialog" title="操作成功" style="display: none;">
    <p></p>
</div>

<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
        <th align="left" class="title_area">当前位置：订单列表</th>
        <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
    </tr>
</table>

<div class="search_div" align="left">
    <s:form id="editForm" action="query" namespace="/order" method="post">
        <ul>
            <li class="myDatepicker">
                <label>&nbsp;预订日期：</label>&nbsp;
                <s:textfield name="order.createDate" id="FROM_DATE" size="12">
                    <s:param name="value"><s:date name="order.createDate" format="yyyy-MM-dd"/></s:param>
                </s:textfield>
                ~
                <s:textfield name="order.modifyDate" id="TO_DATE" size="12">
                    <s:param name="value"><s:date name="order.modifyDate" format="yyyy-MM-dd"/></s:param>
                </s:textfield>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <label>订单状态：</label>
                <s:select name="order.status" list="#{'0':'请选择','1':'未确认','2':'已确认','3':'已取消'}" />
                &nbsp;&nbsp;&nbsp;&nbsp;
                <s:submit value="搜索" cssClass="myButton" cssStyle="width: 65px"/>
            </li>
        </ul>
    </s:form>
</div>

<table class="mygrid">
    <tr class="myheader">
        <th width="30px"></th>
        <th width="120px">旅行社</th>
        <th width="60px">出团日期</th>
        <th width="60px">产品类别</th>
        <th>产品名称</th>
        <th width="60px">预订日期</th>
        <th width="55px">订单状态</th>
        <th width="190px">操作</th>
    </tr>

    <s:if test="pager.list.size == 0">
        <tr>
            <td colspan="7" align="center">暂无相关数据</td>
            <td></td>
        </tr>
    </s:if>
    <s:else>
        <s:iterator value="pager.list" id="order" status="st">
            <s:if test="#st.Even">
                <tr class="tr-even" id="<s:property value="#order.id"/>">
            </s:if>
            <s:else>
                <tr class="tr-odd" id="<s:property value="#order.id"/>">
            </s:else>
            <td><s:property value='#st.index + 1'/></td>
            <td><s:property escape="false" value="#order.user.companyName"/></td>
            <td><s:date name="#order.routePrice.publishDate" format="yyyy-MM-dd"/></td>
            <td><s:property escape="false"
                            value="#order.routePrice.route.productTypeName"/></td>
            <td class="td-operation">
                <a href="/routePrice/view.action?id=<s:property value="#order.routePriceID"/>"><s:property
                        escape="false" value="#order.routePrice.route.productName"/></a>
            </td>
            <td><s:date name="#order.createDate" format="yyyy-MM-dd"/></td>
            <td class="status-class"><s:property escape="false" value="#order.statusName"/></td>
            <td class="td-myButtonBar">
                <input type="button" class="myButton" style="width:40"
                       onclick="update('<s:property value="#order.id"/>', '<s:property value="#order.status"/>')"
                       value="修改">
                <input type="button" class="myButton" style="width:40"
                       onclick="deleteRecord('<s:property value="#order.id"/>')" value="删除">
                <input type="button" class="myButton" style="width:40" onclick="view('<s:property value="#order.id"/>')"
                       value="查看">
                <input type="button" class="myButton" style="width:40"
                       onclick="updateOrderStatus('<s:property value="#order.id"/>' , '2')" value="确认">
                <input type="button" class="myButton" style="width:40"
                       onclick="updateOrderStatus('<s:property value="#order.id"/>' , '3')" value="取消">
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
