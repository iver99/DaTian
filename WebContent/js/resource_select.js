$(document).ready(function(){
							
	$("#select1 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#selectA").length > 0) {
				$("#selectA a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisA.attr("id", "selectA"));
			}
		}
	});
	
	$("#select2 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectB").remove();
		} else {
			var copyThisB = $(this).clone();
			if ($("#selectB").length > 0) {
				$("#selectB a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisB.attr("id", "selectB"));
			}
		}
	});
	
	$("#select3 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#selectC").length > 0) {
				$("#selectC a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisC.attr("id", "selectC"));
			}
		}
	});
	
	$("#select4 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectD").remove();
		} else {
			var copyThisD = $(this).clone();
			if ($("#selectD").length > 0) {
				$("#selectD a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisD.attr("id", "selectD"));
			}
		}
	});

	
	$("#select5 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectE").remove();
		} else {
			var copyThisE = $(this).clone();
			if ($("#selectE").length > 0) {
				$("#selectE a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisE.attr("id", "selectE"));
			}
		}
	});

	$("#selectA").live("click", function () {
		$(this).remove();
		$("#select1 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectB").live("click", function () {
		$(this).remove();
		$("#select2 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectC").live("click", function () {
		$(this).remove();
		$("#select3 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectD").live("click", function () {
		$(this).remove();
		$("#select4 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectE").live("click", function () {
		$(this).remove();
		$("#select5 .resource_all").addClass("selected").siblings().removeClass("selected");
	});

	$(".resource dd").live("click", function () {
		if ($(".resource_result dd").length > 1) {
			$(".resource_no").hide();
		} else {
			$(".resource_no").show();
		}
	});
});