; (function($) {
  $.fn.drawCircle = function(options) {
    var defaults = {
      size: 0,
      width: 60,
      border: 3,
      delay: 500,
      color: ["#e9e9e9", "#ff7f00"],
      animate: true
    };
    var opts = $.extend({},
    defaults, options);
    return $(this).each(function() {
	  if(typeof Raphael == "undefined") return false
      var rad = opts.width / 2 - opts.border,
      border = opts.border,
      width = opts.width,
      paper = Raphael($(this)[0], width, width),
      size = opts.animate ? 0.01 : opts.size,
      color = opts.color,
      self = $(this),
      flag = true,
      maskCircle,
      drawCircle;
      paper.customAttributes.arc = function(value, total, R) {
        var alpha = 360 / total * value,
        a = (90 - alpha) * Math.PI / 180,
        x = width / 2 + R * Math.cos(a),
        y = width / 2 - R * Math.sin(a),
        path;
        if (total == value) {
          path = [["M", width / 2, width / 2 - R], ["A", R, R, 0, 1, 1, width / 2 - 0.02, width / 2 - R]]
        } else {
          path = [["M", width / 2, width / 2 - R], ["A", R, R, 0, +(alpha > 180), 1, x, y]]
        }
        return {
          path: path
        }
      };
      maskCircle = paper.path().attr({
        arc: [100, 100, rad],
        'stroke-width': border,
        'stroke': color[0]
      });
	  if(opts.size > 0.01){
      drawCircle = paper.path().attr({
        arc: [size, 100, rad],
        'stroke-width': border,
        'stroke': color[1],
        'cursor': "pointer"
      });
	  if(opts.animate){
		  if(self.offset().top < $(window).height()){
			  drawCircle.animate({
			   arc: [opts.size, 100, rad]
			},opts.delay);
		  }
		  $(window).scroll(function() {
			  var scrollTop = $(document).scrollTop();
			  var height = $(window).height();
			  if (scrollTop + height > self.offset().top && flag) {
				  drawCircle.animate({
					  arc: [opts.size, 100, rad]
					  },opts.delay);
			  flag = false
        }
      })
		  
		  }
	  }
    })
  }
})(jQuery);

var sideMenu = {
	el: {
		window: $(window),
		document: $(document),
		menu: ".side-menu",
		contact: ".contact",
		returnTop: ".return",
		share: ".share",
		target:"[data-target='sideMenu']",
		foot:".footer"
	},
	init: function() {
		this.scrollEvent();
		this.clickEvent();
		this.hoverEvent();
	},
	hoverEvent:function(){
		$(this.el.menu).find("li").hover(function(){
			$(".icon-w",this).hide();
			$(".text",this).stop(true,false).fadeIn();
			},function(){
				$(".icon-w",this).stop(true,false).fadeIn();
			    $(".text",this).hide();
				});
		},
	scrollEvent: function() {
		if (!$(this.el.target).length > 0 || !$(this.el.foot).length) return false;
		var $w = this.el.window,
		$m = $(this.el.menu),
		self = this,
		dom = this.el.document,
		mtop,
		ftop = $(this.el.foot).offset().top - $m.outerHeight() - 20;
		mtop = $(this.el.target).offset().top;
		function fix(){
			if($w.width() < 1312){
				$m.show();
				
				}
			else{
				$m.css({left: ($w.width() - 1200) / 2 + 1210,display: "block",right:'auto'});
				if(dom.scrollTop() >= ($(".footer").offset().top - $w.height() - 30)){
				$m.css({position:"absolute",top:($(".footer").offset().top - 194)})
				}
			else{
				$m.css({position:"fixed",top:"auto"})
				}
				}
			}
		fix();
		$w.resize(function(){
			if($w.width() < 1312){
				$m.css({right:0,left:'auto'});
				}
			else{
				$m.css({left: ($w.width() - 1200) / 2 + 1210,right:'auto'});
				}
			});
		$w.scroll(function(){
			var scrollTop = dom.scrollTop();
			if(scrollTop >= ($(".footer").offset().top - $w.height() - 30) && $w.width() > 1312){
				$m.css({position:"absolute",top:($(".footer").offset().top - 194)})
				}
			else{
				$m.css({position:"fixed",top:"auto"})
				}
			});
	},
	clickEvent: function() {
		var $m = this.el.menu;
		$(this.el.returnTop, $m).on("click",function() {
			$('body,html').animate({scrollTop: 0});
			return false;
		});
		$(this.el.contact, $m).hover(function(event) {
			$(".contact-box", $m).show();
		},function(){
			$(".contact-box", $m).hide()
			});
		$(".contact-box", $m).hover(function(){
			   $(this).show();
			},function(){
			   $(this).hide();
		});
	}
};

function change_server_apr(changelv,change_id,account){
	var changelv=changelv/100;
	$.ajax({
		type:'POST',
		url:'/?user&q=frontchange',
		dataType: "html",
		data:'id='+change_id+'&change_price='+account+'&changelv='+changelv,
		async:false,
		success:function(msg){
			$("#show_apr_td").html(msg+'%');
		}
	});
}

function showCalculator(obj,default_apr,tender_id,account) {
	var content='<div class="inner"><div class="text">根据<a href="http://bbs.edai.com/forum.php?mod=viewthread&tid=3235&extra=page%3D1" class="c-blue" target="_blank">《易贷网管理费优惠方案》</a>，纯收益率因管理费率不同而不同，不同管理费率对应的纯收益率可通过</div><div class="tit"><span class="fl">下面选择框计算：</span><a href="/?user" class="c-blue fr"  target="_blank">查询您的管理费率>></a></div><table border="0" cellpadding="0" cellspacing="0" width="100%"><tr><th>管理费率</th><th>纯收益率</th></tr><tr><td>';
		content+='<select onchange="change_server_apr(this.value,'+tender_id+','+account+');"><option value=0>免管理费</option>';
		for(var i=1;i<11;i++){
		 content+='<option value='+i+'>'+i+'%</option>';
		}
		content+='</select></td><td id="show_apr_td">'+default_apr+'%</td></tr></table></div>';
	var d = dialog({
		title: "承接人纯收益率计算器",
		content: content,
		width: 380,
		skin:"dialog-calculator",
		quickClose: true
	});
	d.show(obj);
	
};
$(function() {
	$(".circle").each(function(i) {
		var size = $(".total", this).text().replace(/\%/, '');
		$(this).drawCircle({
			size: size
			})
		});
	sideMenu.init();
	$(".nav>ul>li").hover(function() {
		!! $.fn.rotate && $(this).find(".icon-down").rotate({animateTo: 180});
		$("ul", this).show();
		$(this).css({zIndex:"9"});
	},function() {
		!! $.fn.rotate && $(this).find(".icon-down").rotate({animateTo: 0});
		$("ul", this).hide();
		$(this).css({zIndex:""})
	});
	$(".invest-table .item").hover(function(){
		$(this).addClass("odd");
		},function(){
			$(this).removeClass("odd");
			});
	$(".section-receivables tr:gt(0)").hover(function(){
		$(this).addClass("odd");
		},function(){
			$(this).removeClass("odd");
			});
	$(".invest-list .invest-table .item").hover(function(){
		$(this).addClass("hover");
		},function(){
			$(this).removeClass("hover");
		});
	$(".page-select").on("click",function(event){
		event.stopPropagation();
		event.preventDefault();
		$(this).addClass("active");
		$("dd",this).show();
	});
	$(".page-select dd a").on("click",function(event){
		event.stopPropagation();
		event.preventDefault();
		$(".page-select dt span").text($(this).text());
		$(".page-select dd").hide();
		location.href= $(this).attr('href');
		});
	$(document).on("click",function(){
		$(".page-select").removeClass("active");
		$(".page-select dd").hide();
		});
	$(".item-detail-body .hd .icon").each(function(i){
		$(this).css({"margin-left":-$(this).outerWidth()/2})
	});
	$(".site-nav #app").hover(function(){
		$(this).addClass("hover");
		$(".app-con",this).show();
		},function(){
			$(".app-con",this).hide();
			$(this).removeClass("hover");
		})
})