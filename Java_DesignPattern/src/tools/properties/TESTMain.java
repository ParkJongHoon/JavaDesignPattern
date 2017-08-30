package tools.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import tools.dynamiccreate.DynamicObjectCreater;

public class TESTMain {

	public static void main(String[] args) throws IOException {
		PropertyManager propertyManager = PropertyManager.getPropertyManager();
		List list = DynamicObjectCreater.getList();
		User user = (User)DynamicObjectCreater.newInstanceObject("User", list);
		user.print();
	}

}
