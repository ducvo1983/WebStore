/**
 * 
 */
$(function() {
	updateShoppingCard();
	UpdateQuantityAndPrice();
});

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
			'action' : 'add'
		},
		'success' : successResult,
		'error' : ajaxFailure
	});

}


function UpdateQuantityAndPrice(){
	var price_changes = 0;
	  // alert("---called----");
	$('.quantity').on('click', '.btn', function(e) {
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
		
		});
	

}


function successResult(resultData) {
	
}

function ajaxFailure(xhr, status, exception) {
	console.log(xhr, status, exception);
}