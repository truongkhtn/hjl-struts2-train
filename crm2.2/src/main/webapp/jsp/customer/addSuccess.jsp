<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<style type="text/css">
	.pageBody{
		width: 100%;
		height: 80%;
	}
	.resultTable{
		width: 90%;
		text-align: center;
		margin: 30px auto;
	}
</style>

<!-- 中部DIV -->
<div class="main">
    <div class="content">
        <div class="pageHead">
            <table>
                <tr>
                    <th width="8"><img src="${path}/images/c_l.gif" height="31" width="8"/></th>
                    <th align="left" class="title_area">当前位置：客户管理 &gt; 添加客户 &gt; 保存成功</th>
                    <th width="9"><img src="${path}/images/c_r.gif" height="31" width="9"></th>
                </tr>
            </table>
        </div>
        <div class="pageBody">
          <table class="resultTable">
            <tr>
              <td>
                 <img src="../../images/success.jpg" width="200" height="150">
              </td>
            </tr>
            <tr>
              <td>操作成功！</td>
            </tr>
          </table>
          <div class="buttonBar">
            <input class="mybutton" type="button" value="返回"
              onclick="javascript:history.back();"/>
          </div>
        </div>
    </div>
</div>
