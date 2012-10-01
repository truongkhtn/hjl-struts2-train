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
                    <th align="left" class="title_area">当前位置：客户管理 &gt; 客户信息</th>
                    <th width="9"><img src="${path}/images/c_r.gif" height="31" width="9"></th>
                </tr>
            </table>
        </div>
        <div class="pageBody">
            <table class="mytable">
                <tr>
                    <th>客户名称</th>
                    <td><s:property value="customer.name"/></td>
                </tr>
                <tr>
                    <th>客户地址</th>
                    <td><s:property value="customer.address"/></td>
                </tr>
                <tr>
                    <th>客户地址2</th>
                    <td><s:property value="customer.address2"/></td>
                </tr>
                <tr>
                    <th>主联系人</th>
                    <td><s:property value="customer.majorContact.name"/></td>
                </tr>
                <tr>
                    <th>性别</th>
                    <td><s:property value="customer.majorContact.gender"/></td>
                </tr>
                <tr>
                    <th>职位</th>
                    <td><s:property value="customer.majorContact.title"/></td>
                </tr>
                <tr>
                    <th>固定电话</th>
                    <td><s:property value="customer.majorContact.phone"/></td>
                </tr>
                <tr>
                    <th>手机</th>
                    <td><s:property value="customer.majorContact.mobilePhone"/></td>
                </tr>
                <tr>
                    <th>客户等级</th>
                    <td>
                        <s:property value="getText('Level.'+customer.level)"/>
                    </td>
                </tr>
                <tr>
                    <th>客户来源</th>
                    <td><s:property value="customer.source"/></td>
                </tr>
                <tr>
                    <th>传真</th>
                    <td><s:property value="customer.fax"/></td>
                </tr>
                <tr>
                    <th>客户网站</th>
                    <td><s:property value="customer.webSite"/></td>
                </tr>
                <tr>
                    <th>行业</th>
                    <td><s:property value="customer.business"/></td>
                </tr>
                <tr>
                    <th>客户简介</th>
                    <td><s:property value="customer.remark"/></td>
                </tr>
            </table>
            <div class="buttonBar">
                <input type="button" class="mybutton" value="返回" onclick="javascript:history.back();">
            </div>
        </div>
    </div>
</div>