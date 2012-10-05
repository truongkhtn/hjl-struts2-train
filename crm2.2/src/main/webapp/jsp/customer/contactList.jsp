<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="${path}/css/customer.css"/>

<!-- 中部DIV -->
<div class="main">
    <div class="content">
        <div class="pageHead">
            <table>
                <tr>
                    <th width="8"><img src="${path}/images/c_l.gif" height="31" width="8"/></th>
                    <th align="left" class="title_area">当前位置：客户管理 &gt; 联系人列表</th>
                    <th width="9"><img src="${path}/images/c_r.gif" height="31" width="9"></th>
                </tr>
            </table>
        </div>
        <div class="pageBody">
            <table class="mytable resultTable">
                <tr>
                    <th>主联系人</th>
                    <th>联系人</th>
                    <th>职位</th>
                    <th>固定电话</th>
                    <th>手机</th>
                    <th>电子邮箱</th>
                    <th>性别</th>
                </tr>
                <s:if test="contactList.size > 0">
                    <s:iterator value="contactList" var="contact" status="stat">
                        <tr>
                            <s:if test="#contact.major">
                                <td>★</td>
                            </s:if>
                            <s:else>
                                <td></td>
                            </s:else>
                            <td><s:property value="#contact.name"/></td>
                            <td><s:property value="#contact.title"/></td>
                            <td><s:property value="#contact.phone"/></td>
                            <td><s:property value="#contact.mobilePhone"/></td>
                            <td><s:property value="#contact.email"/></td>
                            <td><s:property value="#contact.gender"/></td>
                        </tr>
                    </s:iterator>
                </s:if>
            </table>
            <div class="buttonBar">
            <input class="mybutton" type="button" value="返回"
                    onclick="javascript:history.back();"/>
            </div>
        </div>
    </div>
</div>
