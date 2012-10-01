<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="${path}/css/customer.css"/>

<script type="text/javascript">
    function submitForm(){
        document.getElementById("pageNumber").value = 1;
        document.myForm.submit();
    }
</script>

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
            <s:actionerror />
            <s:form namespace="/customer" action="conflict" name="myForm">
                <s:hidden id="pageNumber" name="pager.pageNumber" value="%{pager.pageNumber}"/>
                <table class="mytable">
                    <tr>
                        <th>客户名称</th>
                        <td>
                            <s:textfield name="contact.customer.name"/>
                        </td>
                        <th>客户地址</th>
                        <td>
                            <s:textfield name="contact.customer.address"/>
                        </td>
                    </tr>
                    <tr>
                        <th>固定电话</th>
                        <td>
                            <s:textfield name="contact.phone"/>
                        </td>
                        <th>手机</th>
                        <td>
                            <s:textfield name="contact.mobilePhone" />
                        </td>
                    </tr>
                    <tr>
                        <th>主联系人</th>
                        <td>
                            <s:textfield name="contact.name"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div class="buttonBar">
                                <input id="btnSearch" type="button" class="mybutton" value="查询" onclick="submitForm()">
                                <input id="btnReset" type="button" class="mybutton" value="重置">
                            </div>
                        </td>
                    </tr>
                </table>
            </s:form>
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
                <s:if test="pager.list.size > 0">
                <s:iterator value="pager.list" var="contact" status="stat">
                <tr>
                    <td><s:property value="(pager.pageNumber-1)* (pager.pageSize) + #stat.getCount()"/></td>
                    <td><s:property value="#contact.customer.createDate"/> </td>
                    <td>
                        <s:a namespace="/customer" action="info">
                            <s:param name="id" value="#contact.customer.id"/>
                            <s:property value="#contact.customer.name"/>
                        </s:a>
                    </td>
                    <td><s:property value="#contact.name"/></td>
                    <td><s:property value="#contact.customer.address"/></td>
                    <td><s:property value="#contact.customer.owner.realName"/></td>
                    <td>
                        <s:a namespace="/customer" action="visitRecordList">
                            <s:param name="id" value="#contact.customer.id"/>
                            拜访记录
                        </s:a>
                        <a href="contactList.jsp">联系人</a>
                    </td>
                </tr>
                </s:iterator>
                </s:if>
                <s:else>
                     <tr>
                        <td colspan="7">暂无数据</td>
                     </tr>
                </s:else>
            </table>
            <s:if test="pager.list.size > 0">
                    <div class="pager-container">
                        <jsp:include page="/${path}/jsp/common/pager.jsp"/>
                    </div>
                </s:if>
        </div>
    </div>
</div>