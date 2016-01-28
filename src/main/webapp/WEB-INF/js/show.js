//获取竖向滚动条宽度
//function getScrollWidth() {
//  var noScroll, scroll, oDiv = document.createElement("DIV");
//  oDiv.style.cssText = "position:absolute; top:-1000px; width:100px; height:100px; overflow:hidden;";
//  noScroll = document.body.appendChild(oDiv).clientWidth;
//  oDiv.style.overflowY = "scroll";
//  scroll = oDiv.clientWidth;
//  document.body.removeChild(oDiv);
//  return noScroll-scroll;
//}


$(document).ready(function(){
	//网页可见区宽度减去滚动条宽度-边框2像素
//	if(getScrollWidth()==0){
//	var width=(document.body.clientWidth);
//}else{
//		var width=(document.body.clientWidth-getScrollWidth());
//	}
//	var mainwidth=document.getElementById("main").style.width=width+"px";
//	var mainheight=document.getElementById("main").style.height="101%";
	$("#main").css("height","101%");
	$("#trtop11").css("display","none");
	$("#trtop12").css("display","none");
	$("#trtop13").css("display","none");
	$("#trtop14").css("display","none");
	$("#trtop15").css("display","none");
	$("#trtop16").css("display","none");
	$("#trtop17").css("display","none");
	$("#trtop18").css("display","none");
	$("#trtop19").css("display","none");
	$("#trtop110").css("display","none");

//	alert(window.screen.width);
//	alert(window.screen.height);
	//alert(document.body.clientWidth);
//	alert(window.screen.availWidth);
//	alert(getScrollWidth());
})
function showinfo(id){
	var value="#"+id;
	$(value).show(1);
	$(value).css("height","100%");
}
function displayinfo(id){
	var value="#"+id;
	$(value).css("display","none");
}
