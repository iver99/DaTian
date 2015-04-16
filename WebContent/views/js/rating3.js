/*评价的星形效果*/
$(function() {
	  $('#rating1').raty({
		half     : false,
		size     : 16,
		starOff  : '../images/star-off-small.png',
		starOn   : '../images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score    : 5
	  });
	  $('#rating2').raty({
		half     : false,
		size     : 16,
		starOff  : '../images/star-off-small.png',
		starOn   : '../images/star-on-small.png',
		starHalf : '../images/star-half-small.png',
		halfShow : true,
		targetKeep: true,
		readOnly : true,
		score    : 4.5
	  });
	  $('#rating3').raty({
		half     : false,
		size     : 16,
		starOff  : '../images/star-off-small.png',
		starOn   : '../images/star-on-small.png',
		starHalf : '../images/star-half-small.png',
		halfShow : true,
		targetKeep: true,
		readOnly : true,
		score    : 4.5
	  });
	  $('#rating4').raty({
		half     : false,
		size     : 16,
		starOff  : '../images/star-off-small.png',
		starOn   : '../images/star-on-small.png',
		targetKeep: true,
		readOnly : true,
		score    : 3
	  });
}); 
