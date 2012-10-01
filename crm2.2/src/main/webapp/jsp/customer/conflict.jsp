<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="${path}/css/customer.css"/>

<div class="main">
    <div class="content">
        <div class="pageHead">
            <table>
                <tr>
                    <th width="8"><img src="${path}/images/c_l.gif" height="31" width="8"/></th>
                    <th align="left" class="title_area">当前位置：客户管理 &gt; 客户冲突</th>
                    <th width="9"><img src="${path}/images/c_r.gif" height="31" width="9"></th>
                </tr>
            </table>
        </div>
        <div class="pageBody">
            <s:form namespace="/customer" action="conflict">
            <table class="mytable">
                <tr>
                    <th>客户名称</th>
                    <td>
                        <s:textfield name="customer.name"/>
                    </td>
                    <th>客户地址</th>
                    <td>
                        <s:textfield name="customer.address"/>
                    </td>
                </tr>
                <tr>
                    <th>固定电话</th>
                    <td>
                        <s:textfield name="customer.contractor.phone"/>
                    </td>
                    <th>手机</th>
                    <td>
                        <s:textfield name="customer.contractor.mobilePhone" />
                    </td>
                </tr>
                <tr>
                    <th>主联系人</th>
                    <td>
                        <s:textfield name="customer.contractor.name"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div class="buttonBar">
                            <input id="btnSearch" type="submit" class="mybutton" value="查询">
                            <input id="btnReset" type="button" class="mybutton" value="重置">
                        </div>
                    </td>
                </tr>
            </table>
        </s:form>
        <s:if test="pager.size > 0">
            <table class="mytable resultTable">
                <tr>
                    <th style="width:30px">序号</th>
                    <th style="width:70px">创建时间</th>
                    <th>客户名称</th>
                    <th style="width:70px">主联系人</th>
                    <th>客户地址</th>
                    <th style="width:70px">客户专员</th>
                    <th style="width:70px">操作</th>
                </tr>
                <s:iterator value="customerList" var="customer" status="stat">
                <tr>
                    <td><s:property value="#stat.getCount()"/></td>
                    <td><s:property value="#customer.createDate"/> </td>
                    <td><a href="info.jsp"><s:property value="#customer.name"/> </a></td>
                    <td><s:property value="#customer.contractor.name"/></td>
                    <td><s:property value="#customer.contractor.address"/></td>
                    <td><s:property value="#customer.user.realName"/></td>
                    <td>
                        <a href="history.jsp">拜访记录</a>
                        <a href="contactList.jsp">联系人</a>
                    </td>
                </tr>
                </s:iterator>
            </table>
            <div class="pager-container">
            <ul class="pager">
                <li class="pageInfo">共<s:property value="page.pageCount"/>页，当前为第<s:property value="page.currentPage"/>页</li>
                <li class="firstPage"><a href='#'>首页</a></li>
                <li class="prePage"><a href='#'>上一页</a></li>
                <li class="nextPage"><a href='#'>下一页</a></li>
                <li class="lastPage"><a href='#'>末页</a></li>
            </ul>
        </div>
        </s:if>
        </div>
    </div>
</div>