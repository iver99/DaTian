/*评价的星形效果*/
$(function() {
	  $('#rating1').raty({
		half     : false,
		size     : 24,
		starOff  : '../images/star-off-big.png',
		starOn   : '../images/star-on-big.png',
		target   : '#hint1',
		targetKeep: true,
		readOnly : true,
		score    : 5
	  });
	  $('#rating2').raty({
		half     : false,
		size     : 24,
		starOff  : '../images/star-off-big.png',
		starOn   : '../images/star-on-big.png',
		target   : '#hint2',
		targetKeep: true,
		readOnly : true,
		score    : 5
	  });
	  $('#rating3').raty({
		half     : false,
		size     : 24,
		starOff  : '../images/star-off-big.png',
		starOn   : '../images/star-on-big.png',
		target   : '#hint3',
		targetKeep: true,
		readOnly : true,
		score    : 4
	  });
	  $('#rating4').raty({
		half     : false,
		size     : 24,
		starOff  : '../images/star-off-big.png',
		starOn   : '../images/star-on-big.png',
		target   : '#hint4',
		targetKeep: true,
		readOnly : true,
		score    : 3
	  });
}); 
