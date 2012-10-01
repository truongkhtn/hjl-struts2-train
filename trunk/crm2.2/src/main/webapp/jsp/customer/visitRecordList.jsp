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
            <table class="mytable">
                <tr>
                    <th>序号</th>
                    <th>拜访日期</th>
                    <th>客户名称</th>
                    <th>成熟度</th>
                    <th>客户专员</th>
                    <th>拜访方式</th>
                    <th>客户联系人</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2012-1-1</td>
                    <td>xxx有限公司</td>
                    <td>★</td>
                    <td>业务员A</td>
                    <td>上门拜访</td>
                    <td>张三</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>2012-2-1</td>
                    <td>xxx有限公司</td>
                    <td>★</td>
                    <td>业务员A</td>
                    <td>上门拜访</td>
                    <td>张三</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>2012-3-1</td>
                    <td>xxx有限公司</td>
                    <td>★</td>
                    <td>业务员A</td>
                    <td>上门拜访</td>
                    <td>张三</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>2012-4-1</td>
                    <td>xxx有限公司</td>
                    <td>★</td>
                    <td>业务员A</td>
                    <td>上门拜访</td>
                    <td>张三</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>2012-5-1</td>
                    <td>xxx有限公司</td>
                    <td>★</td>
                    <td>业务员A</td>
                    <td>上门拜访</td>
                    <td>张三</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>2012-6-1</td>
                    <td>xxx有限公司</td>
                    <td>★</td>
                    <td>业务员A</td>
                    <td>上门拜访</td>
                    <td>张三</td>
                </tr>
            </table>
            <div class="buttonBar">
            <input class="mybutton" type="button" value="返回"
                    onclick="javascript:history.back();"/>
            </div>
        </div>
    </div>
</div>