$(function() {

	//document.getElementById("dataContainer").innerHTML='<object type="text/html" data="profileInformation.jsp" ></object>';
	$("#dataContainer").load("jsp/profileInformation.jsp");
	//$("#dataContainer").load("orderList.jsp");
	
	$("li").click(function() {
	      // remove classes from all
	      $("li").removeClass("active");
	      // add class to the one we clicked
	      $(this).addClass("active");
	      
	      if(this.id === "myProfile") {
	    	  $("#dataContainer").load("jsp/profileInformation.jsp");
	      }
	      else {
	    	  $("#dataContainer").load("jsp/orderList.jsp");
	      }
	   });
	
})
