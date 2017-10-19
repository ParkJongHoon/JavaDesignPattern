package tools.dynamiccreate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tools.properties.PropertyManager;

public class DynamicObjectCreater {
	private static List<Object> list = new ArrayList<Object>();
	
	public static Object newInstanceObject(String objectName, Object...objects){
		list.clear();
		int size = objects.length;
		for(int i=0; i<size; i++){
			list.add(objects[i]);
		}
		Object object = null;
		Object[] arglist = new Object[size];
		@SuppressWarnings("rawtypes")
		Class[] propertiesClass = new Class[size];
		Iterator<?> iterator = list.iterator();
		int num = 0;
		Class<? extends Object> storeClasstype = null;
		while(iterator.hasNext()){
			Object arg = iterator.next();
			Class<? extends Object> classtype = arg.getClass().getSuperclass();
			if(arg.getClass() == Integer.class){
				classtype = int.class;
			}else if(arg.getClass() == String.class){
				classtype = String.class;
			}else if(arg.getClass() == Character.class){
				classtype = char.class;
			}else if(arg.getClass() == Boolean.class){
				classtype = boolean.class;
			}else{
				if(classtype.toString().equals("class java.lang.Object")){
					Type[] t = arg.getClass().getGenericInterfaces();
					if(t.length != 0){
						classtype = (Class<?>)arg.getClass().getGenericInterfaces()[0];
							
					}else{
						classtype = arg.getClass();
					}
				}else{
					
					do{
						storeClasstype = classtype;
						classtype = classtype.getSuperclass();
					}while(!classtype.toString().equals("class java.lang.Object"));
					classtype = storeClasstype;
				}
			}
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
}
