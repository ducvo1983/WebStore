$(function(){
	$('#btnAdd').click(addProduct);
	$('#btnUpdate').click(updateProduct);
	function addProduct(){
		var product = {
				id:"0",
				name:$('#productName').val(), 
				price:$('#productPrice').val(),
				image:$('#productImage').val(),
				fullDescription:$('#fullDescription').val(),
				shortDescription:$('#shortDescription').val(),
				quantity:$('#productQuantity').val()
			  };
		$.post('product_controller?command=ADD',
				  {
					product: JSON.stringify(product)
				  }, processAdd, "json");
	}
	
	function processAdd(data){
		try
		   {
		           data = $.parseJSON(data);
		   }
		   catch(err)
		   {
		   }  
		var td1 = $('<td>')
				  .attr('id','name'+data.id)
				  .text(data.name);
		var td2 = $('<td>')
				  .attr('id','price'+data.id)
				  .text(data.price);
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
		var tr = $('<tr>').
				  attr('id', 'product' + data.id).append(td1).append(td2).append(td3);
		$('#product_list>tbody').append(tr);
		reset();
	}
	
	function reset() {
		$('#productId').val("");
		$('#productName').val("");
		$('#productImage').val("");
		$('#productPrice').val("");
		$('#productQuantity').val("");
		$('#fullDescription').val("");
		$('#shortDescription').val("");
	}
	
	function updateProduct(){
		var product = {
				id: $('#productId').val(),
				name:$('#productName').val(), 
				price:$('#productPrice').val(),
				image:$('#productImage').val(),
				fullDescription:$('#fullDescription').val(),
				shortDescription:$('#shortDescription').val(),
				quantity:$('#productQuantity').val()
			  };
		$.post('product_controller?command=UPDATE',
				  {
					product: JSON.stringify(product)
				  }, processUpdate, "json");
	}
	
	function processUpdate(data){
		try
		   {
		           data = $.parseJSON(data);
		   }
		   catch(err)
		   {
		   }  
		$('#name' + data.id).html(data.name);
		$('#price' + data.id).html(data.price);
		reset();
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
	   try
	   {
	           data = $.parseJSON(data);
	   }
	   catch(err)
	   {
	   }                
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
		try
		   {
		           data = $.parseJSON(data);
		   }
		   catch(err)
		   {
		   }  
		$('#product' + data.id).remove();
		if (parseInt($("#productId").val()) == parseInt(data.id)) {
			reset();
		}
	}
})

