function PostData(url, flag, onoff) {
    XMLHTTP = new ActiveXObject("Microsoft.XMLHTTP");
    var sURL = url
    XMLHTTP.onreadystatechange = getUserName_return;
    XMLHTTP.open("POST", sURL, onoff);
    try {
        XMLHTTP.send();
    }
    catch(e) {
    }
}
function getUserName_return() {
    if (XMLHTTP.readyState == 4) {
        if (XMLHTTP.responseText == "0") {
            $("hidUSERNAME").value = "0"
            $("Msg").innerHTML = "<span style='color:green'>用户名可以使用</span>";
        }
        else {
            $("hidUSERNAME").value = "1"
            $("Msg").innerHTML = "<span style='color:red'>该用户名已经存在,请重新选择</span>";
        }
    }
}
function getUserName(val) {
    if (val != "") {
//            var Url = "index.aspx?Action=getUserName&USERNAME=" + val;
//            PostData(Url, 0, true);
        //TODO...ajax validate username ??
        $("Msg").innerHTML = "<span style='color:red'></span>";
    }
    else {
        $("Msg").innerHTML = "<span style='color:red'>请输入用户名</span>";
    }
}
function $(id) {
    return document.getElementById(id);
}
function chkform() {
    if ($("CITY_ID").value == "0") {
        alert("请选择您的公司所在区域");
        return false;
    }
    if ($("COMPNAME").value == "") {
        $("COMPNAME").className = 'inputbox_error';
        alert("请填写您的公司名称");
        return false;
    }
    if ($("TRUENAME").value == "") {
        $("TRUENAME").className = 'inputbox_error';
        alert("请填写您的真实姓名");
        return false;
    }
    if ($("TELEPHONE").value == "") {
        $("TELEPHONE").className = 'inputbox_error';
        alert("请填写您的联系电话");
        return false;
    }
    if ($("FAXESNO").value == "") {
        $("FAXESNO").className = 'inputbox_error';
        alert("请填写您公司的传真号码");
        return false;
    }
    if ($("MOBLE").value == "") {
        $("MOBLE").className = 'inputbox_error';
        alert("请填写您的手机号码");
        return false;
    }
    if (!is_Mobile($("MOBLE").value)) {
        $("MOBLE").className = 'inputbox_error';
        alert("手机号填写不正确,请重新输入");
        return false;
    }
    if ($("USERNAME").value == "") {
        $("USERNAME").className = 'inputbox_error';
        alert("请输入用户名");
        return false;
    }
    if (!is_english($("USERNAME").value)) {
        $("USERNAME").className = 'inputbox_error';
        alert('用户名填写不正确,只能使用英文字母和数字的组合字符');
        return false;
    }
    if ($("hidUSERNAME").value == "1") {
        $("USERNAME").className = 'inputbox_error';
        alert("您输入的用户名已经被使用,请重新输入");
        return false;
    }
    if ($("USERPWD").value == "") {
        $("USERPWD").className = 'inputbox_error';
        alert("请输入密码");
        return false;
    }
    if ($("USERPWD1").value == "") {
        $("USERPWD1").className = 'inputbox_error';
        alert("请输入确认密码");
        return false;
    }
    if ($("USERPWD1").value != $("USERPWD").value) {
        $("USERPWD1").className = 'inputbox_error';
        alert("两次输入的密码并不相同,请重新输入");
        return false;
    }
    if ($("SERVICE").checked != true) {
        alert("您是否已阅读网站服务条款?");
        return false;
    }
}