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
                    <th align="left" class="title_area">当前位置：客户管理 &gt; 拜访记录</th>
                    <th width="9"><img src="${path}/images/c_r.gif" height="31" width="9"></th>
                </tr>
            </table>
        </div>
        <div class="pageBody">
            <table class="mytable resultTable">
                <tr>
                    <th style="width:50px">序号</th>
                    <th>拜访日期</th>
                    <th>成熟度</th>
                    <th>拜访内容</th>
                    <th>客户专员</th>
                    <th>拜访方式</th>
                    <th>客户联系人</th>
                </tr>
                <s:if test="pager.list.size > 0">
                    <s:iterator value="pager.list" var="record" status="stat">
                        <tr>
                            <td><s:property value="(pager.pageNumber-1)* (pager.pageSize) + #stat.getCount()"/></td>
                            <td><s:property value="#record.createDate"/> </td>
                            <td><s:property value="#record.level"/></td>
                            <td><s:property value="#record.content"/></td>
                            <td><s:property value="#record.owner.realName"/></td>
                            <td><s:property value="#record.visitType.name"/></td>
                            <td><s:property value="#record.contact.name"/></td>
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
                    <jsp:include page="/${path}/jsp/common/pager2.jsp"/>
                </div>
            </s:if>
            <div class="buttonBar">
                <input class="mybutton" type="button" value="返回"
                        onclick="javascript:history.back();"/>
            </div>
        </div>
    </div>
</div>