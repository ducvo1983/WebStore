<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="mainHeads.jsp"></jsp:include>
<link href="<c:url  value='/css/productDetails2.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>

	<div class="col-sm-12 col-md-12 col-lg-12">
		<!-- product -->
		<div class="product-content product-wrap clearfix product-deatil">
			<div class="row">
				<div class="col-md-5 col-sm-12 col-xs-12 ">
					<div class="product-image">
						<div class="item active">
							<img src="https://lorempixel.com/300/300/technics/1/" alt="">
						</div>
					</div>
				</div>
				<div class="col-md-7 col-sm-12 col-xs-12">

					<h2 class="name">
						Product Name Title Here <small>Product by <a
							class="fa fa-star fa-2x text-muted"></i> <span class="fa fa-2x"><h5>(109)
										Votes</h5></span> <a href="javascript:void(0);">109 customer reviews</a>
					</h2>
					<hr>
					<h3 class="price-container">
						$129.54 <small>*includes tax</small>
					</h3>
					<div class="certified">
						<ul>
							<li><a href="javascript:void(0);">Delivery time<span>7
										Working Days</span></a></li>
							<li><a href="javascript:void(0);">Certified<span>Quality
										Assured</span></a></li>
						</ul>
					</div>
					<hr>

					<div class="row">
						<div class="col-sm-12 col-md-6 col-lg-6">
							<a href="javascript:void(0);" class="btn btn-success btn-lg">Add
								to cart ($129.54)</a>
						</div>
						<div class="col-sm-12 col-md-6 col-lg-6">
							<div class="btn-group pull-right">
								<button class="btn btn-white btn-default">
									<i class="fa fa-star"></i> Add to wishlist
								</button>
								<button class="btn btn-white btn-default">
									<i class="fa fa-envelope"></i> Contact Seller
								</button>
							</div>
						</div>
					</div>

					<hr>

					<div class="description description-tabs">

						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade active in" id="more-information">
								<br> <strong>Description Title</strong>
								<p>Integer egestas, orci id condimentum eleifend, nibh nisi
									pulvinar eros, vitae ornare massa neque ut orci. Nam aliquet
									lectus sed odio eleifend, at iaculis dolor egestas. Nunc
									elementum pellentesque augue sodales porta. Etiam aliquet
									rutrum turpis, feugiat sodales ipsum consectetur nec.</p>
							</div>
							<!-- End of reviews -->
						</div>
					</div>
					<hr>

				</div>
			</div>
		</div>
		<!-- end product -->
	</div>
</body>
</html>