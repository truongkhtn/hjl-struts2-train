<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">

    function logout_form() {
//        alert("click");
        $("#logoutForm").submit();
//        alert("The request has been submitted.");
//        window.close();
//        return false;
    }

    //    $(doucument).ready(function(){
    //        $("#logout_href").click(function() {
    //            alert("click");
    //        });
    //    });

</script>

<div class="top">
    <div class="top_left">
        <div class="user_ico">
            <span class="fl tooltip">欢迎您： ${loginUser.realname}</span>
        </div>
    </div>
    <div class="top_right">
        <a class="top_ico6" id="logout_href" href="javascript:logout_form();">退出</a>
        <a class="top_ico5" href="javascript:location.reload();">刷新</a>
        <a class="top_ico4" href="/user/initChangePass.action">修改密码</a>
        <s:form id="logoutForm" action="logout" namespace="/" method="post">
            <s:token/>
        </s:form>
    </div>
</div>
<div class="nav">
    <div class="nav logo fl">
        <%--<img src="/images/logo.gif" alt="旅游产品预定平台" width="216" height="60">--%>
    </div>
</div>