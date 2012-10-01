<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="/styles/pager.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
    function pager(num){
//        alert("num:"+num);
        document.getElementById("pageNumber").value = num;
        document.myForm.submit();
    }
</script>

<ul class="pager">
    <li class="pageInfo">共<s:property value="pager.pageCount"/>页，当前为第<s:property value="pager.pageNumber"/>页</li>
    <!--首页-->
    <s:if test="pager.pageNumber > 1">
        <li class="firstPage">
            <a href='javascript:pager(1);'>首页</a>
        </li>
    </s:if>
    <s:else>
        <li class="firstPage">
            <span>首页</span>
        </li>
    </s:else>
    <!--上一页-->
    <s:if test="pager.pageNumber > 1">
        <li class="prePage">
            <a href='javascript:pager(<s:property value="pager.pageNumber - 1"/>);'>上一页</a>
        </li>
    </s:if>
    <s:else>
        <li class="prePage">
            <span>上一页</span>
        </li>
    </s:else>
    <!--下一页-->
    <s:if test="pager.pageNumber < pager.pageCount">
        <li class="nextPage">
            <a href='javascript:pager(<s:property value="pager.pageNumber + 1"/>);'>下一页</a>
        </li>
    </s:if>
    <s:else>
        <li class="nextPage">
            <span>下一页</span>
        </li>
    </s:else>
    <!--末页-->
    <s:if test="pager.pageNumber < pager.pageCount">
        <li class="lastPage">
            <a href='javascript:pager(<s:property value="pager.pageCount"/>);'>末页</a>
        </li>
    </s:if>
    <s:else>
        <li class="lastPage">
            <span>末页</span>
        </li>
    </s:else>
</ul>