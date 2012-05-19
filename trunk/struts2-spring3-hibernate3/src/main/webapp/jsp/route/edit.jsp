<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        $("#btnAddJourney").click(function() {
            var index = $("#journeyInfo tr::last-child").index();
            var num = Number(index) - Number(1);
            $("<tr class='journeyClass'></tr>").appendTo($("#journeyInfo"));
            $lastTr = $("#journeyInfo tr::last-child");
            $('<td class="center">' + index + '<s:hidden name="journeyList[' + num + '].seq" value="' + index + '"/></td>').appendTo($lastTr);
            $('<td><select class="journey-traffic" name="journeyList[' + num + '].traffic"><option selected="selected" value="1">飞机</option><option value="2">大巴</option></select></td>').appendTo($lastTr);
            $('<td><textarea id="editForm_journey_journeyInfo" class="journey-journeyInfo" name="journeyList[' + num + '].journeyInfo"  rows="" cols="80" name="journey.journeyInfo"></textarea></td>').appendTo($lastTr);
            $('<td><input type="text" id="editForm_journey_catering" class="journey-catering" name="journeyList[' + num + '].catering" value="" size="10" name="journey.catering"></td>').appendTo($lastTr);
            $('<td><input type="text" id="editForm_journey_accomodation" class="journey-accomodation" name="journeyList[' + num + '].accomodation" value="" size="10" name="journey.accomodation"></td>').appendTo($lastTr);
            $('<td><input type="button" value="删除" style="width:65px" class="myButton" onclick="delete_journey(this);"></td>').appendTo($lastTr);
            $('<s:hidden name="journeyList[' + num + '].id"/>').appendTo($lastTr);
            $('<s:hidden name="journeyList[' + num + '].version"/>').appendTo($lastTr);
            $('<s:hidden name="journeyList[' + num + '].routeID"/>').appendTo($lastTr);
        });

        $("#editForm").submit(function() {
            if ($("#PRODUCT_NAME").val() == "") {
                alert("请填写产品名称！");
                return false;
            }
            if (!validJourney()) {
                alert('请填写有效行程信息!');
                return false;
            }

            if ($("#RECORD_ID").val() == "") {
                $("#editForm").attr('action', '/route/create.action');
            } else {
                $("#editForm").attr('action', '/route/update.action');
            }
            return true;
        });

    });

    //删除空白的tr
    function trimBlank() {
        $("#journeyInfo .journeyClass").each(function() {
            if (!hasContent($(this))) {
                if ($("#journeyInfo .journeyClass").size() != 1) {
                    $(this).remove();
                    refresh_journey();
                }
            }
        });
    }

    function validJourney() {
        var flg = true;
        $("#journeyInfo .journeyClass").each(function() {
            if ($(this).find('.journey-journeyInfo').val() == "") {
                flg = false;
            }
            if ($(this).find('.journey-catering').val() == "") {
                flg = false;
            }
            if ($(this).find('.journey-traffic').val() == "") {
                flg = false;
            }
        });
        return flg;
    }

    //刷新tr排序
    function refresh_journey() {
        var num = 0;
        $("#journeyInfo .journeyClass").each(function() {
            $(this).children('td').eq(0).text(num+1);
            $(this).children('td').eq(1).children().attr("name", 'journeyList[' + num + '].traffic');
            $(this).children('td').eq(2).children().attr("name", 'journeyList[' + num + '].journeyInfo');
            $(this).children('td').eq(3).children().attr("name", 'journeyList[' + num + '].catering');
            $(this).children('td').eq(4).children().attr("name", 'journeyList[' + num + '].accomodation');
            $(this).children('input').eq(0).attr("name" , 'journeyList[' + num + '].id');
            $(this).children('input').eq(1).attr("name" , 'journeyList[' + num + '].version');
            $(this).children('input').eq(2).attr("name" , 'journeyList[' + num + '].routeID');
            num ++;
        });
    }

    //判断tr中所有输入项都不会空
    function hasAllContent(tr) {
        if (tr.find('.journey-journeyInfo').val() == "" ||
                tr.find('.journey-catering').val() == "" ||
                tr.find('.journey-traffic').val() == "") {
            return false;
        }
        return true;
    }

    //判断tr中是否含有任何一个数据
    function hasContent(tr) {
        if (tr.find('.journey-journeyInfo').val() != "" ||
                tr.find('.journey-catering').val() != "" ||
                tr.find('.journey-traffic').val() != "") {
            return true;
        }
        return false;
    }

    //删除journey tr
    function delete_journey(obj) {
        $tr = $(obj).parent().parent();

        if ($("#journeyInfo .journeyClass").size() == 1) {
            alert("必须有至少一个行程信息!");
            return false;
        }

        if (hasContent($tr)) {
            if (confirm("确认要删除吗？")) {
                $tr.remove();
            }
        } else {
            $tr.remove();
        }
        refresh_journey();
    }

</script>

<s:form id="editForm" action="create" namespace="/route" method="post">
    <s:hidden id="RECORD_ID" name="route.id"/>
    <s:hidden name="route.version"/>
    <%--标题部分--%>
    <table class="pageHead">
        <tr>
            <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
            <th align="left" class="title_area">当前位置：编辑线路</th>
            <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
        </tr>
    </table>
    <%--产品信息--%>
    <table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
        <tr>
            <td class="pro_color1 f13" colspan="4"><b>基本信息</b></td>
        </tr>
        <tr>
            <td width="10%" class="pro_color2">产品名称:</td>
            <td width="40%">
                <s:textfield name="route.productName" id="PRODUCT_NAME" size="50"/>
                <span class="required">*</span>
            </td>
            <td width="10%" class="pro_color2">出港地点:</td>
            <td width="40%">
                <s:textfield name="route.portOfDeparture" id="portOfDeparture" size="50"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">产品类别:</td>
            <td>
                <s:radio name="route.productType" list="#{'1':'特价','2':'常规','3':'尊品','4':'纯玩','5':'老年团'}"/>
            </td>
            <td class="pro_color2">年龄限制:</td>
            <td>
                <s:textfield name="route.ageLimit" id="ageLimit" size="50"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">购物:</td>
            <td>
                <s:textfield name="route.shopping" id="shopping" size="50"/>
            </td>
            <td class="pro_color2">住宿标准:</td>
            <td>
                <s:textfield name="route.accomodationStandard" id="accomodationStandard" size="50"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">景点:</td>
            <td colspan="3">
                <s:textarea name="route.scenerySpot" id="scenerySpot" cols="120"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">赠送:</td>
            <td colspan="3">
                <s:textarea name="route.present" id="present" cols="120"/>
            </td>
        </tr>
    </table>

    <table id="journeyInfo" width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
        <tr>
            <td class="pro_color1 f13" colspan="5"><b>行程安排</b></td>
            <td class="pro_color1 f13">
                <input id="btnAddJourney" class="myButton" style="width:65px" type="button" value="+ 添加行程">
            </td>
        </tr>
        <tr>
            <th width="30px" class="pro_color3">序号</th>
            <th width="60px" class="pro_color3">交通</th>
            <th class="pro_color3">行程安排</th>
            <th width="80px" class="pro_color3">餐饮</th>
            <th width="80px" class="pro_color3">住宿</th>
            <th width="80px" class="pro_color3">操作</th>
        </tr>
            <%--循环输出 journeyList--%>
        <s:iterator value="journeyList" id="journey" status="st">
            <tr class="journeyClass">
                <td>
                    <s:property value='#st.index + 1'/><s:hidden name="journeyList[%{#st.index}].seq"/>
                </td>
                <td>
                    <s:select name="journeyList[%{#st.index}].traffic" list="#{'1':'飞机','2':'大巴'}" cssClass="journey-traffic"/>
                </td>
                <td>
                    <s:textarea name="journeyList[%{#st.index}].journeyInfo" cols="80" cssClass="journey-journeyInfo"/>
                </td>
                <td>
                    <s:textfield name="journeyList[%{#st.index}].catering" size="10" cssClass="journey-catering"/>
                </td>
                <td>
                    <s:textfield name="journeyList[%{#st.index}].accomodation" size="10"
                                 cssClass="journey-accomodation"/>
                </td>
                <td>
                    <input class="myButton" type="button" style="width:65px" onclick="delete_journey(this);" value="删除">
                </td>
                <s:hidden name="journeyList[%{#st.index}].id"/>
                <s:hidden name="journeyList[%{#st.index}].version"/>
                <s:hidden name="journeyList[%{#st.index}].routeID"/>
            </tr>
        </s:iterator>
    </table>

    <table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
        <tr>
            <td class="pro_color1 f13" colspan="4"><b>其他信息</b></td>
        </tr>
        <tr>
            <td class="pro_color2" width="10%">产品特色：</td>
            <td>
                <s:textarea name="route.productItem" id="productItem" cols="120" rows="8"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">服务标准：</td>
            <td>
                <s:textarea name="route.serviceStandard" id="serviceStandard" cols="120" rows="8"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">特别说明：</td>
            <td>
                <s:textarea name="route.specialInstruction" id="specialInstruction" cols="120" rows="8"/>
            </td>
        </tr>
        <tr>
            <td class="pro_color2">温馨提示：</td>
            <td>
                <s:textarea name="route.friendlyTips" id="friendlyTips" cols="120" rows="8"/>
            </td>
        </tr>
    </table>

    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="page_button">
        <tr>
            <td align="center" colspan="4">
                <input class="myButton" type="submit" style="width:65px" value="确认">
                <input class="myButton" type="button" style="width:65px" onclick="history.go(-1)" value="返回">
            </td>
        </tr>
    </table>

</s:form>
