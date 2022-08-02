// function $(id){
//     return document.getElementById(id);
// }

window.onload=function(){
    updateZJ();
    //当页面加载完成时，我们需要绑定各种事件
    //根据id获取到表格
    var fruitTbl = document.getElementById("tbl_fruit");
    //获取表格中所以的行
    var rows = fruitTbl.rows;
    for(var i=1;i<rows.length-1;i++)
    {
        var tr = rows[i];
        trBindEven(tr);

    }

    document.getElementById("addBtn").onclick=addFruit;
}

function trBindEven(tr){
    //绑定鼠标悬浮以及离开时设置背景颜色事件
    tr.onmouseover=showBGColor;
    tr.onmouseout=clearBGColor;
    //获取tr这一行的所以单元格
    var cells=tr.cells;
    var priceTD=cells[1];
    //绑定鼠标悬浮在单价单元格变手势的事件
    priceTD.onmouseover=showHand;
    //绑定鼠标点击单价单元格事件
    priceTD.onclick=editPrice;

    //7、绑定删除小图标的事件
    var img = cells[4].firstChild;
    if(img && img.tagName=="IMG"){
        //绑定点击事件
        img.onclick = delFruit;
    }
}

//添加水果信息
function addFruit(){
    var fname=document.getElementById("fname").value;
    var price=parseInt(document.getElementById("price").value);
    var fcount=parseInt(document.getElementById("fcount").value);
    var xj = price*fcount;

    var fruitTbl = document.getElementById("tbl_fruit");
    var tr = fruitTbl.insertRow(fruitTbl.rows.length-1);
    var fnameTD = tr.insertCell();
    fcountTD.innerText=fname;

    var priceTD = tr.insertCell();
    priceTD.innerText=price;

    var fcountTD = tr.insertCell();
    fcountTD.innerText=fcount;

    var xjTD = tr.insertCell();
    xjTD.innerText=xj;

    var imgTD = tr.insertCell();
    imgTD.innerHTML="<img src='8.jpg' class='delImg'/>";
    
    updateZJ();
    trBindEven(tr);
}


function delFruit(){
    if(Event && Event.srcElement && Event.srcElement.tagName=="IMG"){
        //alert:弹出对话框,只有确定按钮
        //confirm:弹出一个对话框，只有确定和取消按钮。点击确定，返回true，否则返回false
        if(window.confirm("是否确认删除当前库存记录")){
            var img = Event.srcElement;
            var tr = img.parentElement;
            var fruitTbl = document.getElementById("tbl_fruit");
            fruitTbl.deleteRow(tr.rowIndex);

            updateZJ();
        }
        
    }
}


function updatePrice(){
    if(Event && Event.srcElement && Event.srcElement.tagName=="INPUT"){
        var input=Event.srcElement;
        var newPrice=input.value;
        //input节点的父节点是td
        var priceTD=input.parentElement;
        priceTD.innerText=newPrice;
        //更新小计
        updateXJ(priceTD.parentElement);
    }

}

function updateXJ(){
    if(tr && tr.tagName=="TR"){
        var tds = tr.cells;
        var price=tds[1].innerText;
        var count=tds[2].innerText;
        //类型转换
        var xj = parseInt(price)*parseInt(count);
        tds[3].innerText = xj;

        //更新总计

        updateZJ();
    }
}

function updateZJ(){
    var fruitTbl = document.getElementById("tbl_fruit");
    var rows = fruitTbl.rows;
    var sum=0;
    for(var ii=0;i<rows.length-1;i++){
        var tr = rows[i];
        var xj = parseInt(tr.cells[3].innerText);
        sum = sum+xj;
    }
    rows[rows.length-1].cells[1].innerText = sum;
}

//点击单价单元格时，对价格进行编辑
function editPrice(){
    if(Event && Event.srcElement && Event.srcElement.tagName=="TD"){
        var priceTD=Event.srcElement;
        //判断当前priceTD右子节点，第一个节点时文本节点
        if(priceTD.firstChild && priceTD.firstChild.nodeType==3){
            //innerText 设置或者获取当前节点的内部文件
            var oldPrice = priceTD.innerText;
            //innerHTML  设置当前节点内部HTML
            priceTD.innerHTML="<input type='text' size='4'/>";
            var input = priceTD.firstChild;
            if(input.tagName=="INPUT"){
                input.value = oldPrice;
                input.select();
                //4、绑定输入框失去焦点，更新单价
                input.onblur=updatePrice;

                //8、在输入框上绑定键盘摁下的事件，保证用户输入的是数字
                input.onkeydown=ckInput;
            }
        }
    }
}

function ckInput(){
    var kc=Event.keyCode;
    //0-9:48~57
    //backspace:8
    //enter:13
    console.log(kc);

    if(!((kc>=48&&kc<=57)||kc==8||kc==13)){
        Event.returnValue=false;
    }

    if(kc==13){
        Event.srcElement.blur();
    }
}


//当鼠标悬浮时，现实背景颜色
function showBGColor(){
    //event:当前发生的时间
    //event.srcElement:事件源
    
    if(Event && Event.srcElement && Event.srcElement.tagName=="TD"){
        var td = Event.srcElement;
        //td.parentElement:获取td的父元素tr
        var tr = td.parentElement;
        //如果想要通过js代码设置某节点的样式，加上style
        tr.style.backgroundColor = "navy";
        //tr.cells:获取这个tr中所有的单元格
        var tds = tr.cells;
        for(var i=0;i<tds.length;i++)
        {
            tds[i].style.color="white";
        }
    }
}

//当鼠标离开时，清除背景颜色
function clearBGColor(){
    if(Event && Event.srcElement && Event.srcElement.tagName=="TD"){
        var td = Event.srcElement;

        var tr = td.parentElement;

        tr.style.backgroundColor = "transparent";

        var tds = tr.cells;
        for(var i=0;i<tds.length;i++)
        {
            tds[i].style.color="threeddarkshadow";
        }
    }
}


function showHand(){
    if(Event && Event.srcElement && Event.srcElement.tagName=="TD"){
        var td = Event.srcElement;
        //光标
        td.style.cursor="hand";
    }
}