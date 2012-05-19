$(function() {

    $("#itemList1").accordion();
    $("#itemList1 li").draggable({
        appendTo: "body",
        helper: "original",
        cursor: "move", cursorAt: { top:8, right: 100},
        revert:"invalid"
    });
    $("#itemList2 ol").droppable({
        activeClass: "ui-state-default",
        hoverClass: "ui-state-hover",
        accept: ":not(.ui-sortable-helper)",
        drop: function(event, ui) {
//                    $(this).find(".placeholder").remove();
            var id = ui.draggable.attr("id");
            $("<li id=" + id + " class='ui-selectee'></li>").text(ui.draggable.text()).appendTo(this);
            $(ui.draggable).hide(); //隐藏
            setTimeout(function() {
                $(ui.draggable).remove(); //删除
            }, 1);
            $("#editForm").append('<input class="hiddenInput" type="hidden" name="ids" value=' + id + '>');
        }
    }).sortable({
            itemList1: "li:not(.placeholder)",
            placeholder: "ui-state-highlight",
            sort: function() {
                $(this).removeClass("ui-state-default");
            },
            stop: function(event, ui) {
                //移除原有 hidden 域
                $(".hiddenInput").each(function() {
                    $(this).remove();
                });
                //重新添加 hidden 域
                $("#itemList2 li").each(function(){
                    var id = $(this).attr("id");
                    $("#editForm").append('<input class="hiddenInput" type="hidden" name="ids" value=' + id + '>');
                });
            }
        });

    $("#leftDiv ul").droppable({
        drop: function(event, ui) {
            var id = ui.draggable.attr("id");
            $("<li id='" + id + "'></li>").text(ui.draggable.text()).appendTo(this);
            $(ui.helper).remove();
            $("#itemList1 li:last-child").draggable();//启用 drag
//            alert(id);
            $(".hiddenInput").each(function() {
                if ($(this).val() == id) {
                    $(this).remove();
                }
            });
        }
    });
});