package org.park.javadesignpattern.gday.abstractfactory.main;

import org.park.javadesignpattern.gday.abstractfactory.factory.Factory;
import org.park.javadesignpattern.gday.abstractfactory.factory.Link;
import org.park.javadesignpattern.gday.abstractfactory.factory.Page;
import org.park.javadesignpattern.gday.abstractfactory.factory.Tray;

import tools.properties.PropertyManager;

public class G_Main {

	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefacotory.TableFactory");
		}
		Factory factory = Factory.getFactory(args[0]);
		Link joins = factory.createLink("중앙일보", "http://www.joins.com/");
		Link chosun = factory.createLink("조선일보", "http://www.chosun.com/");
		
		Link us_yahoo = factory.createLink("Yahoo", "http://www.yahoo.com/");
		Link kr_yahoo = factory.createLink("Yahoo!Korea", "http://www.yahoo.co.kr/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http://www.google.com/");
		
		Tray trayNews = factory.createTray("신문");
		trayNews.add(joins);
		trayNews.add(chosun);
		
		Tray trayYahoo = factory.createTray("Yahoo!");
		trayYahoo.add(us_yahoo);
		trayYahoo.add(kr_yahoo);
		
		Tray traySearch = factory.createTray("검색엔진");
		traySearch.add(trayYahoo);
		traySearch.add(excite);
		traySearch.add(google);
		
		Page page = factory.createPage("LinkPage", "영진닷컴");
		page.add(trayNews);
		page.add(traySearch);
		page.output();

	}

}
