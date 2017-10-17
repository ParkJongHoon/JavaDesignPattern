package org.park.javadesignpattern.nday.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/*
 * �ۼ���: 2017-10-17
 * �ۼ���: ������
 * �ۼ�����: Facade Pattern����
 *  ������ �д��� �Ѵ�.
 *  ���� ������ �����ϴ� Ŭ����
 *  �� �Ʒ� ������ HTML�� �׸��� �����͸� ������ ���� ������ �Ѵ�.
 *  
 *   - PageMaker
 *   -- Database, HtmlWriter
 */


public class PageMaker {
	private PageMaker(){	// �ν��Ͻ��� ������ �ʱ� ������ private �����Ѵ�
	}
	public static void makeWelcomePage(String mailaddr, String filename){
		try{
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph(username + "�� �������� ���� �� ȯ���մϴ�.");
			writer.paragraph("������ ��ٸ��� �ֽ��ϴ�.");
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
			writer.title("���� ����� ����Ʈ �������� ���� �� ȯ���մϴ�.");
			writer.tableStartPoint();
			writer.TRStartPoiont();
			writer.THWriter("�����");
			writer.THWriter("�����ּ�");
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
