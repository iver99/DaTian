/**
 * 工具js
 */
//时间转换，返回年月日
function renderTime(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate(); 
} 