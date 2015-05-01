
$(document).ready(function() {

    $("#list").tablesorter({
		headers: {
			0: {
				sorter: false
			},
			1: {
				sorter: false
			},
			3: {
				sorter: false
			},
			5: {
				sorter: false
			}
		}
	});

    $("#list1").tablesorter({
		headers: {
			0: {
				sorter: false
			},
			1: {
				sorter: false
			},
			6: {
				sorter: false
			},
			7: {
				sorter: false
			}
		}
	});

//排序：针对一般列表
    $("#trigger1a").click(function() {
        var sorting = [[2,0]];
        $("#list").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger1b").click(function() {
        var sorting = [[2,1]];
        $("#list").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger2a").click(function() {
        var sorting = [[4,0]];
        $("#list").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger2b").click(function() {
        var sorting = [[4,1]];
        $("#list").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger3a").click(function() {
        var sorting = [[6,0]];
        $("#list").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger3b").click(function() {
        var sorting = [[6,1]];
        $("#list").trigger("sorton",[sorting]);
        return false;
        });

//排序：仅针对车辆列表
    $("#trigger1a").click(function() {
        var sorting = [[2,0]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger1b").click(function() {
        var sorting = [[2,1]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger2a").click(function() {
        var sorting = [[3,0]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger2b").click(function() {
        var sorting = [[3,1]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger3a").click(function() {
        var sorting = [[4,0]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger3b").click(function() {
        var sorting = [[4,1]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger4a").click(function() {
        var sorting = [[5,0]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger4b").click(function() {
        var sorting = [[5,1]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger5a").click(function() {
        var sorting = [[8,0]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });
    $("#trigger5b").click(function() {
        var sorting = [[8,1]];
        $("#list1").trigger("sorton",[sorting]);
        return false;
        });

});
