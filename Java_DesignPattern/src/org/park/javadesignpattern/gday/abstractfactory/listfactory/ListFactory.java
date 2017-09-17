package org.park.javadesignpattern.gday.abstractfactory.listfactory;

import org.park.javadesignpattern.gday.abstractfactory.factory.Factory;
import org.park.javadesignpattern.gday.abstractfactory.factory.Link;
import org.park.javadesignpattern.gday.abstractfactory.factory.Page;
import org.park.javadesignpattern.gday.abstractfactory.factory.Tray;

import tools.dynamiccreate.DynamicObjectCreater;

public class ListFactory extends Factory {

	@Override
	public Link createLink(String caption, String url) {
		return (Link)DynamicObjectCreater.newInstanceObject("ListLink", caption, url);
	}

	@Override
	public Tray createTray(String caption) {
		return (Tray)DynamicObjectCreater.newInstanceObject("ListTray", caption);
	}
	
	@Override
	public Page createPage(String title, String author) {
		return (Page)DynamicObjectCreater.newInstanceObject("ListPage", title, author);
	}

}
