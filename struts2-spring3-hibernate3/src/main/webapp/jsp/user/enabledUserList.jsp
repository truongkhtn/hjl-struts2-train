<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    function deleteUser(id){
        if(confirm('确定删除此用户吗？'))
        {
            window.location.href = "/user/deleteEnabled.action?id=" + id;
        }
    }
</script>

<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
        <th align="left" class="title_area">当前位置：用户列表</th>
        <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
    </tr>
</table>
<table class="mygrid">
    <tr class="myheader">
        <th width="50px"></th>
        <th>公司名称</th>
        <th>真实姓名</th>
        <th>联系电话</th>
        <th>手机号码</th>
        <th>用户名</th>
        <th>操作</th>
    </tr>

    <s:iterator value="userList" id="user" status="st" >
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
                <s:property value="#user.companyName"/>
            </td>
            <td>
                <s:property value="#user.name"/>
            </td>
            <td>
                <s:property value="#user.phone"/>
            </td>
            <td>
                <s:property value="#user.cellPhone"/>
            </td>
            <td>
                <s:property value="#user.username"/>
            </td>
            <td class="td-operation">
                <a href="/user/view.action?id=<s:property value="#user.id"/>">查看</a>
                <a href="/user/initUpdate.action?id=<s:property value="#user.id"/>">修改</a>
                <a href="javascript:deleteUser('<s:property value="#user.id"/>');">删除</a>
            </td>
        </tr>
    </s:iterator>

</table>