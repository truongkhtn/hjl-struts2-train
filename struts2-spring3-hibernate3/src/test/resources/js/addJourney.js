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
            $("<li class='ui-selectee'></li>").text(ui.draggable.text()).appendTo(this);
            $(ui.helper).remove();
        }
    }).sortable({
            itemList1: "li:not(.placeholder)",
            placeholder: "ui-state-highlight",
            sort: function() {
                $(this).removeClass("ui-state-default");
            }
        });


    $("#leftDiv ul").droppable({
        drop: function(event, ui) {
            $("<li class='ui-draggable' style='position: relative;'></li>").text(ui.draggable.text()).appendTo(this);
            $(ui.helper).remove();
            $("#itemList1 li:last-child").draggable();//启用 drag
            $last = $("#itemList2 li:last-child");
//                    if($last.index() == 0){
//                        //add tip info...
//                    }
        }
    });
});