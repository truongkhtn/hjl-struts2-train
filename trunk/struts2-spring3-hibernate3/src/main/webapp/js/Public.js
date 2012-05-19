function $$(id) {
    return document.getElementById(id);
}
function $(id)
{
	return document.getElementById(id);
}
function ConverDate(str)
{
    s=str.replace(/\-/g,"/")
    var n=new Date(s);
    return n
}
function is_email(str) {
var pattern = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;

    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}
function is_english(str) {
var pattern = /^[a-zA-Z0-9_-]+$/;

    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}
function is_Mobile(str) {
var pattern = /^1[3,5,8]\d{9}$/;

    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}
function is_Postcode(str,s) {
var pattern = /^\d{6}$/;
    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}

function is_Birthday(str) {
var pattern = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}

function is_Phone(str) {
var pattern = /^(\d{4}|\d{3})-(\d{8}|\d{7})$/;
    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}

function is_PolicyPrice(str) {
var pattern = /^(([1-9]{1}.5)|([1-9]{1})|(1[0-5]{1})|(1[0-5]{1}.5))$/;
    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}

function is_Policy_Rake(str) {
var pattern = /^(([0-9]{1}.[1-9]{1})|([0-9]{1})|([1-9]{1}[0-9]{1})|100)$/;
    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}
function is_AirCode(str) {
var pattern = /^[0-9A-Z]{2}[0-9]{4}$/;
    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}

function is_Cabin(str) {
var pattern = /^[A-Z]{1}$/;
    flag = pattern.test(str);
    if (!flag)
        return false;
    else
        return true;
}
/**
*校验两个日期的先后
*返回值：
*如果起始日期早于等于终止日期，校验通过，   返回true
*如果起始日期晚于终止日期，                 返回false    参考提示信息： 起始日期不能晚于结束日期。
*/
function checkDateEarlier(strStart,strEnd)
{
    var arr1 = strStart.split("-");
    var arr2 = strEnd.split("-");
    var date1 = new Date(arr1[0],parseInt(arr1[1].replace(/^0/,""),10) - 1,arr1[2]);
    var date2 = new Date(arr2[0],parseInt(arr2[1].replace(/^0/,""),10) - 1,arr2[2]);
    if(arr1[1].length == 1)
        arr1[1] = "0" + arr1[1];
    if(arr1[2].length == 1)
        arr1[2] = "0" + arr1[2];
    if(arr2[1].length == 1)
        arr2[1] = "0" + arr2[1];
    if(arr2[2].length == 1)
        arr2[2]="0" + arr2[2];
    var d1 = arr1[0] + arr1[1] + arr1[2];
    var d2 = arr2[0] + arr2[1] + arr2[2];
    if(parseInt(d1,10) >= parseInt(d2,10))
       return false;
    else
       return true;
}//~~~

function OpenWindow(Url,Width,Height)
{
	//window.showModalDialog(Url,"","resizable:no;scroll:off;status:no;dialogWidth="+Width+"px;dialogHeight="+Height+"px;center=yes;help=no");
	var ScreenWidth=screen.width/2-Width/2;
	var ScreenHeight=screen.height/2-Height/2;
	window.open (Url, '', 'height='+Height+', width='+Width+', top='+ScreenHeight+', left='+ScreenWidth+', toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no')  

}
function findObj(theObj, theDoc)    
{    
    var p, i, foundObj;    
  
    if(!theDoc) theDoc = document;    
    if( (p = theObj.indexOf("?")) > 0 && parent.frames.length)    
    {    
        theDoc = parent.frames[theObj.substring(p+1)].document;    
        theObj = theObj.substring(0,p);    
    }    
    if(!(foundObj = theDoc[theObj]) && theDoc.all) foundObj = theDoc.all[theObj];    
    for (i=0; !foundObj && i < theDoc.forms.length; i++)    
        foundObj = theDoc.forms[theObj];    
    for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++)    
        foundObj = findObj(theObj,theDoc.layers.document);    
    if(!foundObj && document.getElementById) foundObj = document.getElementById(theObj);    
  
    return foundObj;    
} 

function stringReplaceAll(val,AFindText,ARepText)
{
	raRegExp = new RegExp(AFindText,"g");
	val.replace(raRegExp,ARepText)
	return val;
}

function CreateHTTPObject() {
    var xmlhttp;

    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch (e) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        try {
            xmlhttp = new XMLHttpRequest();
        }
        catch (e) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && window.createRequest) {
        try {
            xmlhttp = window.createRequest();
        }
        catch (e) {
            xmlhttp = false;
        }
    }
    return xmlhttp;
}
