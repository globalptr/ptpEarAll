(function($) {
	var zIndex = 100;
	// 消息框
	var $message;
	var messageTimer;
	$.msg = function() {
		var message = {};
		if ($.isPlainObject(arguments[0])) {
			message = arguments[0];
		} else if (typeof arguments[0] === "string" && typeof arguments[1] === "string") {
			message.type = arguments[0];
			message.content = arguments[1];
		} else if (typeof arguments[0] === "string" && typeof arguments[1] === "string" && typeof arguments[2] === "string") {
			message.type = arguments[0];
			message.content = arguments[1];
			message.outtime = arguments[2];
		} else {
			return false;
		}
		
		if (message.type == undefined) {
			message.type = "yes";
		}
		if (message.content == undefined) {
			message.content = "操作成功！";
		}
		if(message.type == null || message.content == null){
			return false;	
		}
		if ($message == null) {
			$message = $('<div class="xxMessage"><div class="messageContent message' + message.type + 'Icon"><\/div><\/div>');
			if (!window.XMLHttpRequest) {
				$message.append('<iframe class="messageIframe"><\/iframe>');
			}
			$message.appendTo("body");
		}
		
		$message.children("div").removeClass("messagewarnIcon messageerrorIcon messagesuccessIcon").addClass("message" + message.type + "Icon").html(message.content);
		$message.css({"margin-left": - parseInt($message.outerWidth() / 2), "z-index": zIndex ++}).show();
		var otime = 3000;
		if(message.outtime != undefined){
			otime = message.outtime;
		}
		clearTimeout(messageTimer);
		messageTimer = setTimeout(function() {$message.hide();}, otime);
		return $message;
	}
	//获取url里的参数
	$.getEcardName = function(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r!=null){ 
			return unescape(r[2]);
		}
			return null;
	}	
})(jQuery);


















