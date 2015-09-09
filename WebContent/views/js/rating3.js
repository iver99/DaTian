/*评价的星形效果*/
$(function() {
	 /* $('#rating1').raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
			//alert($('#rating1').attr('id'));
		    //return $('#rating1').attr('data-score');
			alert($("#rate1").val());
			return $("rate1").val();
		}
	  });
	  $('#rating2').raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		starHalf : 'images/star-half-small.png',
		halfShow : true,
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
	  $('#rating3').raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		starHalf : 'images/star-half-small.png',
		halfShow : true,
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
	  $('#rating4').raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });*/
}); 

function rating1(){
	$('#rating1').raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
			//alert($('#rating1').attr('id'));
		    //return $('#rating1').attr('data-score');
			alert($("#rate1").val()+"...");
			return $("#rate1").val();
		}
	  });
}
function rating2(){
	$('#rating2').raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		starHalf : 'images/star-half-small.png',
		halfShow : true,
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
function rating3(){
	 $('#rating3').raty({
			half     : false,
			size     : 16,
			starOff  : 'images/star-off-small.png',
			starOn   : 'images/star-on-small.png',
			starHalf : 'images/star-half-small.png',
			halfShow : true,
			targetKeep: true,
			readOnly : true,
			score: function() { 
			    return $(this).attr('data-score');
			}
		  });
}
function rating4(){
	$('#rating4').raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}


//以下为资源栏详情的评价显示函数
function one_rate(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//1.5星
function one_rate_half(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		starHalf : 'images/star-half-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//2星
function two_rate(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//2.5星
function two_rate_half(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		starHalf : 'images/star-half-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//3星
function three_rate(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//3.5星
function three_rate_half(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		starHalf : 'images/star-half-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//4星
function four_rate(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//4.5星
function four_rate_half(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		starHalf : 'images/star-half-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}
//5星
function five_rate(item_id){
	$('#'+item_id).raty({
		half     : false,
		size     : 16,
		starOff  : 'images/star-off-small.png',
		starOn   : 'images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score: function() { 
		    return $(this).attr('data-score');
		}
	  });
}

