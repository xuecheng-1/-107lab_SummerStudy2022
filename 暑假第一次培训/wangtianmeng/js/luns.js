    //第一获取元素
    var box = document.getElementById("box");
    var screen = box.children[0];
    var arr = box.children[1];
    var ul = screen.children[0];
    var ullis = ul.children;
    var ol = screen.children[1];
    var right = arr.children[1];
    var left = arr.children[0];
    var imgWidth = screen.offsetWidth;
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
    //第四实现左右按钮
    box.onmouseover = function() {
        arr.style.display = "block";
        clearInterval(timer);
    }
    box.onmouseout = function() {
        arr.style.display = "none";
        timer = setInterval(right.onclick, 3000);
        //或timer = setInterval("right.onclick()", 3000);
    }
    var pic = 0; //相当于索引号 ，从0开始 每次加一
    var num = 0; //作用：让那个按钮高亮
    right.onclick = function() {
        if (pic == ollis.length) { //pic 等于ollis.length执行if
            ul.style.left = 0; //复原.
            pic = 0; //复原. 索引号赋值成0第一张图
        }
        pic++;
        var target = -pic * imgWidth;
        getname(ul, target);
        if (num < 2) {
            num++;
        } else {
            num = 0;
        }
        //点亮排他
        for (var i = 0; i < ollis.length; i++) {
            ollis[i].className = "";
        }
        ollis[num].className = "current";


    }
    left.onclick = function() {
            if (pic == 0) {
                ul.style.left = -3 * imgWidth + "px"; //复原成最后一张图*screen获取的宽度
                pic = 3; //复原. 索引号赋值成5第5张图
            }
            pic--;
            var target = -pic * imgWidth;
            getname(ul, target);
            if (num > 0) {
                num--;
            } else {
                num = 2;
            }
            //点亮排他
            for (var i = 0; i < ollis.length; i++) {
                ollis[i].className = "";
            }
            ollis[num].className = "current";

        }
        //第五自动伦播
    var timer = setInterval(right.onclick, 6000);

    function getname(ele, target) {
        clearInterval(ele.timer);
        ele.timer = setInterval(function() {
            var hpwz = ele.offsetLeft;
            var setp = 30;
            setp = target > hpwz ? setp : -setp;

            if (Math.abs(target - hpwz) > Math.abs(setp)) {
                hpwz = hpwz + setp;
                ele.style.left = hpwz + "px";
                //  console.log("1111");
            } else {
                clearInterval(ele.timer);
                //没到10跑一下 没有到10用ele.style.left = target + "px"; 赋值过去
                ele.style.left = target + "px";
            }
        }, 15)
    }