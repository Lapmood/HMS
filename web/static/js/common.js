function refresh(event){
    //alert(event.data.href)
    window.location.href=event.data.href;
}

function checkvalue(node){
    //alert($(node).attr("href"));
    $("#search").attr("action",$(node).attr("href"));
    $("#search").submit();
    return false;
}

// function addAndEditTrigger(event) {
//     var current = event.data.current;
//     var target = event.data.target;
//     var listText = {
//         engageAdd:"添加预订信息",
//         engageList:"预订列表",
//         roomAdd:"客房录入",
//         roomList:"客房列表",
//         memberAdd:"会员录入",
//         memberList:"会员列表",
//         liveAdd:"添加入住信息",
//         liveList:"入住列表",
//         checkoutList:"结算列表",
//         empAdd:"员工添加",
//         empList:"员工列表",
//         goodsAdd:"商品添加",
//         goodsList:"商品列表",
//     };
//
//     var $parent = $(parent.document);
//
//     var $iframes = $parent.find("iframe");
//     var $targetIframe = $parent.find("iframe[name='"+target+"']");
//
//     // console.log(index);
//     //return false;
//
//     if($targetIframe.length == 0){
//         var $a = $parent.find(".list.active a");
//         $a.html(listText[target]+"&nbsp;")
//         $a.append($("<span class='close'>&times;</span>").on("click",removeList));
//         console.log($parent.find("iframe[name='" + current + "']"));
//         $parent.find("iframe[name='"+current+"']").attr("name",target);
//         $parent.find(".tab-pane.active").attr("id",target);
//         $parent.find(".list.active a").attr("href","#"+target);
//     }else{
//
//         var index;
//         $.each($iframes,function(i,value){
//             // console.log($targetIframe[0]);
//             // console.log(value);
//             if($targetIframe[0] == value){
//                 index = i;
//             }
//         })
//
//         $parent.find(".list").removeClass("active");
//         $parent.find(".tab-pane").removeClass("active");
//         $parent.find(".list:eq('"+ index +"')").addClass("active");
//         $parent.find(".tab-pane:eq('"+ index +"')").addClass("active");
//     };
// }