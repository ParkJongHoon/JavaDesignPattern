package org.park.javadesignpattern.gday.abstractfactory.factory;

import tools.properties.PropertyManager;

public abstract class Factory {
	public static Factory getFactory(String className){
		Factory factory = null;
		String classFullName = PropertyManager.getPropertyManager().getPropertiesValue(className);
			try {
				factory = (Factory)Class.forName(classFullName).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("클래스" + className + " 이 발견되지 않았습니다.");
			}
			return factory;
		
	}
	public abstract Link createLink(String caption, String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title, String author);
}
