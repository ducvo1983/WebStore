$(function(){
	$('#btnAdd').click(addProduct);
	$('#btnUpdate').click(updateProduct);
	function addProduct(){
		$.post('product_controller?command=ADD',
			  {
				id:"0",
				name:$('#productName').val(), 
				price:$('#productPrice').val(),
				image:$('#productImage').val(),
				fullDescription:$('#fullDescription').val(),
				shortDescription:$('#shortDescription').val(),
				quantity:$('#productQuantity').val()
			  }, processAdd)
	}
	
	function processAdd(data){
		data = JSON.parse(data);
		var td1 = $('<td>').text(data.name);
		var td2 = $('<td>').text(data.price);
		var td3 = $('<td>')
		var btnDisplay = $('<button>')
						.addClass('btnDisplay')
						.data("id", data.id)
						.text("Display");
		btnDisplay.click(getProduct);
		btnDisplay.appendTo(td3);
		var btnDel = $('<button>')
		.addClass('btnDel')
		.data("id", data.id)
		.text("Delete");
		btnDel.click(deleteProduct);
		btnDel.appendTo(td3);
		var tr = $('<tr>').append(td1).append(td2).append(td3);
		$('#product_list>tbody').append(tr);
	}
	
	function updateProduct(){
		$.post('product_controller?command=UPDATE',
			  {
				id: $('#productId').val(),
				name:$('#productName').val(), 
				price:$('#productPrice').val(),
				image:$('#productImage').val(),
				fullDescription:$('#fullDescription').val(),
				shortDescription:$('#shortDescription').val(),
				quantity:$('#productQuantity').val()
			  }, processUpdate);
		/*var mydata = {
				id: $('#productId').val(),
				name:$('#productName').val(), 
				price:$('#productPrice').val(),
				image:$('#productImage').val(),
				fullDescription:$('#fullDescription').val(),
				shortDescription:$('#shortDescription').val(),
				quantity:$('#productQuantity').val()
			  };
		$.ajax(
				   {
				      data: mydata,
				      method: 'POST',
				      url: 'product_controller?command=UPDATE',
				      success: processUpdate
				  });*/
	}
	
	function processUpdate(data){
		data = JSON.parse(data);
		$('#name' + data.id).html(data.name);
		$('#price' + data.id).html(data.price);
	}
	
	$('.btnDisplay').click(getProduct);
	function getProduct() {
		$.get('product_controller?command=DISPLAY',
			  {
				id: $(this).data("id")
			  })
			  .done(processGet)
			  .fail(function(){
				  alert("failed!");
			  });
	}
	
	function processGet(data) {
		data = JSON.parse(data);
		//alert("processGet: " + data.id);
		$('#productId').val(data.id);
		$('#productName').val(data.name);
		$('#productImage').val(data.image);
		$('#productPrice').val(data.price);
		$('#productQuantity').val(data.quantity);
		$('#fullDescription').val(data.fullDescription);
		$('#shortDescription').val(data.shortDescription);
	}
	
	$('.btnDel').click(deleteProduct);
	function deleteProduct() {
		$.get('product_controller?command=DELETE',
			  {
				id: $(this).data("id")
			  }, processDelete);
	}
	
	function processDelete(data) {
		data = JSON.parse(data);
		$('#product' + data.id).remove();
	}
})

