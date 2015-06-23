
      function getCompletionInfo(first_rate,second_rate)
	  {
        var d1 = new JustGage ({
          id: "div_mgmt_dashboard1", 
          value: getRandomInt(first_rate,first_rate), 
          min: 0,
          max: 100,
          title: "好评率",
          label: "%",
		  levelColors: [
			  "#0085c0"
			]    
        });
        var d2 = new JustGage ({
          id: "div_mgmt_dashboard2", 
          value: getRandomInt(second_rate,second_rate), 
          min: 0,
          max: 100,
          title: "投诉率",
          label: "%",
			levelColors: [
			  "#ffcc00"
			]    
        });
      };
