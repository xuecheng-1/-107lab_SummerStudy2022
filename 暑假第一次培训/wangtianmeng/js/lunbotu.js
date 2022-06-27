//第一获取元素
var lun = document.querySelector(".lun");
// var lun = box.children[0];
// var lis = lun.children[0];
var ul = lun.children[0];
// var ullis = ul.children;
// var ol = lun.children[1];
// var right = arr.children[1];
// var left = arr.children[0];
var imgWidth = lun.offsetWidth;
//第二动态生成ol
// for (var i = 0; i < ul.children.length; i++) {
//     var li = document.createElement("li");
//     li.innerHTML = i + 1;
//     ol.appendChild(li);
// }
//拿到ol里面的所用li标签
var ollis = ol.children;
//第一个li标签点亮
ollis[0].className = "current";
//克隆图片 cloneNode(true)
ul.appendChild(ullis[0].cloneNode(true));
//第三循环绑定事件
for (var j = 0; j < ollis.length; j++) {
    ollis[j].setAttribute("data-index", j);
    ollis[j].onmouseover = function() {
        for (var i = 0; i < ollis.length; i++) {
            ollis[i].className = "";
        }
        this.className = "current";
        var index = this.getAttribute("data-index");
        var target = -index * imgWidth;
        getname(ul, target);
        //每次移入 告诉一下左右按钮我点击呢哪一个
        num = index;
        pic = index;
    }
}
// $(".box-left").click(function(){
//     clearInterval(f);
//     if(index==0){
//         index=$(".box-img").length-1;
//         $(".box-img").css("opacity","0");
//         $(".box-img").eq(index).css("opacity","1");
//         dingshiqi();
//     }
//     else{
//         index--;
//         $(".box-img").css("opacity","0");
//         $(".box-img").eq(index).css("opacity","1");
//         dingshiqi();
//     }  
// })
// $(".box-right").click(function(){
//     clearInterval(f);
//     if(index==$(".box-img").length-1){
//         index=0;
//         $(".box-img").css("opacity","0");
//         $(".box-img").eq(index).css("opacity","1");
//         dingshiqi();
//     }
//     else{
//         index++;
//         $(".box-img").css("opacity","0");
//         $(".box-img").eq(index).css("opacity","1");
//         dingshiqi();
//     }       
// })