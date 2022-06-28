
   
    var $panel = $("."+box);
    box_left = 0;
    box_left = $panel.css('left');
    box_left = ($(window).width() -  $panel.width()) / 2;
    $panel.css({'left': box_left,'position':'relative'});
  
        $panel.animate({left:box_left-(100-5)},1500);
        $panel.animate({left:box_left+(100-5)},1500);
 

  