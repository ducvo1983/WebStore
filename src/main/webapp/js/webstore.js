/**
 * 
 */
$(function() {
	updateShoppingCard();
	UpdateQuantityAndPrice();
	updateShoppingCard2();
	$('#checkoutbutton').click(checkoutAction);
});

function checkoutAction() {
	$.get('checkout', {
		action: "CHECKQUANTITY"
	}).done(checkResult)
	.fail(ajaxFailure);
	return false;
}

function checkResult(data) {
	data = JSON.parse(data);
	var valid = true;
	//console.log(data);
	$.each(data, function( key, value ) {
	  //alert( key + ": " + value );
	  valid = false;
	  $('#error_message' + key).text("Just remaining " + value + " product(s) in the inventory");
	});
	console.log(data);
	if (valid) {
		//var context_path = "<%=request.getContextPath()%>";
		window.location.replace("/webstore/checkout");
	}
}

function updateShoppingCard() {

	$('.bclass').click(function() {
		var id = $(this).data("id");
		var q = $("#i_number_" + id).val();
		if (q === undefined || q === "") {
			alert("Please, specify a quantity");
		} else {
			var c = $("#i_number").val();
			//alert("---c value is---"+q);
			if (c === undefined || c === "") {
				c = 0;
			} else {
				c = parseInt($("#i_number").val());
			
			}
			$("#i_number_" + id).val("");
			c = parseInt(q)+c;
		    
			$("#i_number").val(c);
			executeAddToChart(id, "+" + q);
		
			
		}

	});

}


function updateShoppingCard2() {

	$('#bpdetail').click(function() {
		var q = $("#pdquantity").val();
		var id = $("#hpid").val();
		if (q === undefined || q === "") {
			alert("Please, specify a quantity");
		} else {
			var c = $("#i_number").val();
			//alert("---c value is---"+q);
			if (c === undefined || c === "") {
				c = 0;
			} else {
				c = parseInt($("#i_number").val());
			
			}
			//$("#pdquantity").val("");
			c = parseInt(q)+c;
		    
			$("#i_number").val(c);
			executeAddToChart(id, q);
		
			
		}

	});

}

function executeAddToChart(id, q) {
	// alert("Please you did it " + q);
	var url = "addServlet";

	$.ajax({
		'url' : url,
		'type' : 'POST',
		'data' : {
			'productID' : id,
			'quantity' : q,
			'action' : 'ADD'
		},
		'success' : successResult,
		'error' : ajaxFailure
	});

}

function UpdateQuantityAndPrice(){
	// alert("---called----");
	$('.quantity').on('click', '.btn1', function(e) {
		var toltal_price = parseInt($('#totalamount').text());
		e.preventDefault();
		var $this = $(this),
		$input = $this.closest('div').find('input'),
		value = parseInt($input.val()),
		btn = $this.data('btn');
		
		p_id = $this.data('id');
		
        totalprice = parseInt($('#itemprice_'+p_id).text());

        unit_price = parseInt($this.data('iprice'));
		if (btn === 'minus') {
		value = value > 1 ? value - 1 : 0;
		toltal_price = toltal_price - (totalprice - (unit_price * value));
		
		} else {
		value = value < 100 ? value + 1 : 100;
		toltal_price = toltal_price + (unit_price * value)
		//totalprice = unit_price * value;
		}
		
		totalprice = unit_price * value;
		$input.val(value);
		$('#itemprice_'+p_id).text(totalprice);
		$('#totalamount').text(toltal_price);
		executeAddToChart(p_id, value);
		});
	

}


function successResult(resultData) {
}

function ajaxFailure(xhr, status, exception) {
	console.log(xhr, status, exception);
}