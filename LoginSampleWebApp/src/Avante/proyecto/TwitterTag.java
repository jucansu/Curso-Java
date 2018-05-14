package Avante.proyecto;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TwitterTag extends SimpleTagSupport {
	private String message, referer, related, text, tw_p, url;

	public void setMessage(String msg) {
		this.message = msg;
	}

	StringWriter sw = new StringWriter();

	public void doTag() throws JspException, IOException {
		if (message != null) {
			/* Use message from attribute */
			JspWriter out = getJspContext().getOut();
			out.println("<a= ");
			out.println("https://twitter.com/intent/tweet?");
			
			out.print(">retuitea</a>>");
		} else {
			/* use message from the body */
			getJspBody().invoke(sw);
			getJspContext().getOut().println(sw.toString());
		}
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public void setRelated(String related) {
		this.related = related;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTw_p(String tw_p) {
		this.tw_p = tw_p;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
