package tools.dynamiccreate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tools.properties.PropertyManager;

public class DynamicObjectCreater {
	private static List<Object> list = new ArrayList<Object>();
	
	public static Object newInstanceObject(String objectName, List<?> list){
		Object object = null;
		Object[] arglist = new Object[propertiesLength(list)];
		@SuppressWarnings("rawtypes")
		Class[] propertiesClass = new Class[propertiesLength(list)];
		Iterator<?> iterator = list.iterator();
		int num = 0;
		while(iterator.hasNext()){
			Object arg = iterator.next();
			Class<? extends Object> classtype = arg.getClass().getSuperclass();
			arglist[num] = arg;
			propertiesClass[num] = classtype;
			num++;
		}
		String classFullName = PropertyManager.getPropertyManager().getPropertiesValue(objectName);
		try {
			Class<?> classtype = Class.forName(classFullName);
			Constructor<?> construct = classtype.getConstructor(propertiesClass);
			object = construct.newInstance(arglist);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	public static List<Object> getList() {
		return list;
	}

	public static int propertiesLength(List<?> list){
		return list.size();
	}

}
