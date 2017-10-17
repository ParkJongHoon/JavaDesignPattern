package org.park.javadesignpattern.nday.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/*
 * 작성일: 2017-10-17
 * 작성자: 박종훈
 * 작성내용: Facade Pattern에서
 *  역할의 분담을 한다.
 *  높은 레벨은 조합하는 클래스
 *  그 아래 레벨은 HTML을 그리고 데이터를 가지고 오는 역할을 한다.
 *  
 *   - PageMaker
 *   -- Database, HtmlWriter
 */


public class PageMaker {
	private PageMaker(){	// 인스턴스는 만들지 않기 때문에 private 선언한다
	}
	public static void makeWelcomePage(String mailaddr, String filename){
		try{
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph(username + "의 페이지에 오신 걸 환영합니다.");
			writer.paragraph("메일을 기다리고 있습니다.");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename + " is created for " + mailaddr +
					" (" + username + ")");
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void makeLinkPage(String filename){
		try{
			Properties mailprop = Database.getProperties("maildata");
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			Iterator<Object> it = mailprop.keySet().iterator();
			writer.style("border: 1px solid black;");
			writer.style("border-collapse: collapse;");
			writer.style("text-align: left;");
			writer.title("메일 사용자 리스트 페이지에 오신 걸 환영합니다.");
			writer.tableStartPoint();
			writer.TRStartPoiont();
			writer.THWriter("사용자");
			writer.THWriter("메일주소");
			writer.TREndPoiont();
			
			while(it.hasNext()){
				String emailAddress = (String)it.next();
				String userName = mailprop.getProperty(emailAddress);
				writer.TRStartPoiont();
				writer.TdWriter(userName);
				writer.TdWriterStartPoint();
				writer.mailto(emailAddress, emailAddress);
				writer.TdWriterEndPoint();
				writer.TREndPoiont();
			}
			writer.tableEndPoint();
			writer.close();
			System.out.println(filename + " is created for EmailList");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
