<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="${path}/css/customerAdd.css"/>

<script type="text/javascript">
	$(function(){
		$("#btnReset").click(function(){
			$('#customerSaveForm').each (function(){
			  this.reset();
			});
		});
		
		$("#btnSave").click(function(){
			//check form items...
			$('#customerAddForm').submit();
		});
	});
	
</script>

<!-- 中部DIV -->
<div class="main">
       <div class="content">
            <div class="pageHead">
                <table>
                    <tr>
                        <th width="8"><img src="${path}/images/c_l.gif" height="31" width="8"/></th>
                        <th align="left" class="title_area">当前位置：客户管理 &gt; 添加客户</th>
                        <th width="9"><img src="${path}/images/c_r.gif" height="31" width="9"></th>
                    </tr>
                </table>
            </div>
           <s:actionerror/>
           <s:form id="customerAddForm" namespace="/customer" action="add">
               <s:hidden name="customer.status" value="%{'UNSIGNED'}"/>
                <div class="pageBody">
                    <div class="customerDiv">
                        <table class="mytable" border="0">
                                <caption>客户信息</caption>
                                <tr>
                                    <th>客户名称</th>
                                    <td >
                                        <s:textfield name="customer.name" size="20"/>
                                        <span class="required">*</span>
                                    </td>
                                    <th>
                                        客户地址
                                    </th>
                                    <td>
                                        <s:textfield name="customer.address" size="30"/>
                                        <span class="required">*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>客户来源</th>
                                    <td>
                                        <s:select name="customer.source" list="sourceMap"/>
                                        <span class="required">*</span>
                                    </td>
                                    <th>
                                        客户地址2
                                    </th>
                                    <td>
                                        <s:textfield name="customer.address2" size="30"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>传真</th>
                                    <td>
                                        <s:textfield name="customer.fax" size="20"/>
                                    </td>
                                    <th>
                                        客户网站
                                    </th>
                                    <td>
                                        <s:textfield name="customer.webSite" size="30"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>行业</th>
                                    <td>
                                        <s:textfield name="customer.business" size="20"/>
                                    </td>
                                    <th>
                                        客户等级
                                    </th>
                                    <td>
                                        <s:select name="customer.level" list="levelMap"
                                                   headerKey="NA" headerValue="%{getText('select.header.value')}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>客户简介</th>
                                    <td>
                                        <s:textarea name="customer.remark" rows="4" cols="18"/>
                                    </td>
                                </tr>
                            </table>
                    </div>
                    <div class="contactDiv">
                        <table class="mytable" border="0">
                                <caption>主联系人信息</caption>
                                <tr>
                                    <th>联系人</th>
                                    <td >
                                        <s:textfield name="contact.name" size="20"/>
                                        <span class="required">*</span>
                                    </td>
                                    <th>
                                        职位
                                    </th>
                                    <td>
                                        <s:select list="titleMap" name="contact.title"
                                                  headerKey="NA" headerValue="%{getText('select.header.value')}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>手机</th>
                                    <td>
                                        <s:textfield name="contact.mobilePhone" size="20"/>
                                    </td>
                                    <th>
                                        性别
                                    </th>
                                    <td>
                                        <s:radio name="contact.gender" list="#{'MALE':'男', 'FEMALE':'女'}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>固定电话</th>
                                    <td>
                                        <s:textfield name="contact.phone" size="20"/>
                                    </td>
                                    <th>
                                        电子邮件
                                    </th>
                                    <td>
                                        <s:textfield name="contact.email" size="30"/>
                                    </td>
                                </tr>
                            <tr>
                                <th>QQ</th>
                                <td>
                                    <s:textfield name="contact.qq" size="20"/>
                                </td>
                                <th>
                                    备注
                                </th>
                                <td>
                                    <s:textarea rows="3" cols="18" name="contact.remark"/>
                                </td>
                                </tr>
                            </table>
                    </div>
                    <div class="buttonBar">
                        <input id="btnSave" type="button" class="mybutton" value="保存">
                        <input id="btnReset" type="button" class="mybutton" value="重置">
                        <input type="button" class="mybutton" value="返回" onclick="javascript:history.back();">
                    </div>
                </div>
            </s:form>
        </div>
    </div>
