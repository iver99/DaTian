
      function getGoodCommentInfo(rate)
	  {
        var d1 = new JustGage ({
          id: "div_mgmt_dashboard1", 
          value: getRandomInt(rate,rate), 
          min: 0,
          max: 100,
          title: "好评率",
          label: "%",
		  levelColors: [
			  "#0085c0"
			]    
        });
        
	  }
      function getComplaintRateInfo(rate){
        var d2 = new JustGage ({
          id: "div_mgmt_dashboard2", 
          value: getRandomInt(rate,rate), 
          min: 0,
          max: 100,
          title: "投诉率",
          label: "%",
			levelColors: [
			  "#ffcc00"
			]    
        });
      }
