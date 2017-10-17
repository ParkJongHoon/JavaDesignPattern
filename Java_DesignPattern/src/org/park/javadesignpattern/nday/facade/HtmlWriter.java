package org.park.javadesignpattern.nday.facade;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HtmlWriter {
	private Writer writer;
	private List<String> style;
	public HtmlWriter(Writer writer) {
		this.writer = writer;				// 생성자
	}
	public void title(String title) throws IOException{		// 타이틀 출력
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		if(style != null){
			Iterator<String> it = style.iterator();			
			writer.write("<style>");
			while(it.hasNext()){
				writer.write(it.next());
			}
			writer.write("</style>");
		}
		writer.write("</head>");
		writer.write("<body>\n");
		writer.write("<h1>" + title + "</h1>\n");
	}
	public void paragraph(String msg) throws IOException{	// 단락 출력
		writer.write("<p>" + msg + "</p>\n");
	}
	
	public void paragraphNotenter(String msg) throws IOException{	// 단락 출력
		writer.write("<p>" + msg + "</p>\n");
	}
	
	public void tableStartPoint() throws IOException{
		writer.write("<table style='width:100%'>");	
	}
	public void tableEndPoint() throws IOException{
		writer.write("</table>");
	}
	
	public void TRStartPoiont() throws IOException{
		writer.write("<tr>");
	}
	public void TREndPoiont() throws IOException{
		writer.write("</tr>");
	}
	public void THWriter(String msg) throws IOException{
		writer.write("<th>" + msg + "</th>");
	}
	public void TdWriter(String msg) throws IOException{
		writer.write("<td>" + msg + "</td>");
	}
	public void TdWriterStartPoint() throws IOException{
		writer.write("<td>");
	}
	
	public void TdWriterEndPoint() throws IOException{
		writer.write("</td>");
	}
	
	
	public void link(String href, String caption) throws IOException{
															// 링크 출력
		paragraph("<a href=\"" + href + "\">" + caption + "</a>");
	}
	public void mailto(String mailaddr, String username) throws IOException{
														// 메일 주소 출력
		link("mailto:" + mailaddr, username);
	}
	public void close() throws IOException{				// 닫는다
		writer.write("</body>");
		writer.write("</html>\n");
		writer.close();
	}
	
	public List<String> style(String input){
		if(this.style == null){
			this.style = new ArrayList<String>();
			style.add("table, th, td{");
			style.add(input);
			style.add("}");
		}else{
			style.remove(style.size()-1);
			style.add(input);
			style.add("}");
		}
		return style;
	}

}
