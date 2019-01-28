//创建 iframe 与 列表选
function copyIframeAndLi() {

    var id = $(this).attr("index");
    var text = $(this).children("span:last").text();
    //清除所用 .list 的 active样式
    $(".list").removeClass("active");
    //清除所用 .tab-pane 的 active样式
    $(".tab-pane").removeClass("active");

    //console.log("id: "+id);
    //console.log($("#" + $(this).attr("index"))[0]);

    if($("#"+$(this).attr("index"))[0] == null){
        $("<li class='list active'> </li>")
            .append(
                $("<a href='#"+id+"' data-toggle='tab'>" +text+ "&nbsp; </a>")
                    .append($("<span class='close'>&times;</span>").on("click",removeList)))
            .appendTo($(".nav-tabs"));
        $("<div class='tab-pane active' id='"+id+"'> " +
            "<iframe name='"+id+"' src='' frameborder='0' scrolling='yes' style='max-width: 100%;width: 100%;height: 100%'></iframe> " +
            "</div>").appendTo($(".tab-content"));
    }else {
        $(".list").has("a[href='#"+id+"']").addClass("active");
        $(".tab-pane#"+id).addClass("active");
    }
}
//删除
function removeList(){
    console.log($(".tab-pane").length);
    //获取需要被删除的li节点
    $list = $(this).parents("li.list");
    //获取拥有 .active 的li节点
    $target = $(".list.active");
    //判断删除的节点与拥有 .active节点是否同一节点
    if($list.children("a").attr("href") == $target.children("a").attr("href")){
        //清除所用 .list 的 active样式
        $(".list").removeClass("active");
        //清除所用 .tab-pane 的 active样式
        $(".tab-pane").removeClass("active");
        //判断删除的节点是否为最后一个节点
        if($(".list").last().children("a").attr("href") == $list.children("a").attr("href")){
            $list.prev().addClass("active");
            $(".tab-pane"+$list.prev().children("a").attr("href")).addClass("active");
        }else{
            $list.next().addClass("active");
            $(".tab-pane"+$list.next().children("a").attr("href")).addClass("active");
        }
    }
    //删除需要删除的节点
    $list.remove();
    //删除对应的iframe
    //console.log($(this).parent().attr("href"));
    $($(this).parent().attr("href")).remove();
    return false;
}