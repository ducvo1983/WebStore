package com.wap.controller;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.wap.model.Product;

public class TldProductViewController extends SimpleTagSupport {
	private Product product;
	
	@Override
	public void doTag() throws JspException, IOException {
		if (product != null) {
			JspWriter out = getJspContext().getOut();
			StringBuilder builder = new StringBuilder();
			builder.append("<div class='box'>")
				   .append("<form action='/addServlet' method='post'>")
				   .append("<div class='thumbnails'>")
				   .append("<img alt='" + product.getName() + "' ")
				   .append("src='images/" + product.getImage() + ".png' />")
				   .append("<span class='redcolor'>Price " + product.getPrice() + "$.</span>")
				   .append("<span class='sizclass'>" + product.getShortDescription() + "</span><br />")
				   .append("<span class='sizclass'>Quantity:</span>")
				   .append("<input class='sizeclass' required='required' type='number' min='1' maxlength='100'  id='i_number_" + product.getId() + "'/>")
				   .append("</div>")
				   .append("<div class='bwrapper'>")
				   .append("<input class='bclass' type='button' value='Add to Chart' data-id='" + product.getId() + "'/>")
				   .append("</div>")
				   .append("</form>")
				   .append("</div>");
			out.write(builder.toString());	   
		}
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
