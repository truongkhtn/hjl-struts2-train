<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        $("#changePassForm").submit(function(){
            if ($("#oldPass").val() == "") {
                alert("请填写原密码");
                return false;
            }
            if ($("#newPass").val() == "") {
                alert("请填写新密码");
                return false;
            }
            if ($("#newPass2").val() == "") {
                alert("请填写确认密码");
                return false;
            }
            if ($("#newPass").val() != $("#newPass2").val()) {
                alert("两次输入密码不一致");
                return false;
            }
            return true;
        });
    });
</script>

<s:form id="changePassForm" action="changePass" namespace="/user" method="post">
    <s:fielderror cssStyle="color: #ff0000;" />
    <div class="password">
        <%--<h2><span>修改密码</span></h2>--%>
        <ul>
            <li>
                <span>旧密码：</span><s:password id="oldPass" name="oldPass" cssClass="pwd_txt"/>
                <b>*</b>
            </li>
            <li>
                <span>新密码：</span><s:password id="newPass" name="newPass" cssClass="pwd_txt"/>
                <b>*</b>
            </li>
            <li>
                <span>确认密码：</span><s:password id="newPass2" name="newPass2" cssClass="pwd_txt"/>
                <b>*</b>
            </li>
            <li><input type="submit" value="" class="pwd_sure" name="ctl00">
                <input type="button" class="pwd_cancle" name="" onclick="history.go(-1)"></li>
        </ul>
    </div>
</s:form>