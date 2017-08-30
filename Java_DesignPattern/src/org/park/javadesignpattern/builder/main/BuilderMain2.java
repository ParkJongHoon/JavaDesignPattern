package org.park.javadesignpattern.builder.main;



import java.util.List;

import org.park.javadesignpattern.builder.example.ExecutePlan;
import org.park.javadesignpattern.builder.example.InstanceManager;

import tools.dynamiccreate.DynamicObjectCreater;
import tools.properties.PropertyManager;
import tools.properties.User;

public class BuilderMain2 {
	/**
	 * �ۼ���: 2017-05-17
	 * �ۼ���: ������
	 * �ۼ�����: Builder pattern
	 * 1) Builder Ŭ������ �ൿ���Ͽ� ���� �߻�޼ҵ�� �����Ѵ�.
	 * 2) Builder Ŭ������ �߻�޼ҵ带 ������ ������ BuilderŬ������ ��ӹ��� �� �����Ѵ�.
	 * -> HTMLBuilder, TextBuilder Ŭ�����̸� ConcreteBuilder������ ����Ѵ�.
	 * 3) Director Ŭ�������� �����ںκп� BuilderŬ���� ��ü�� �����ϴ� �κ��� �����ϰ�
	 * ���Թ��� ��ü�� ���� �����ȹ�� ������ ����޼ҵ带 �����.(construct()) 
	 * @param args
	 */
	
	public static void main(String[] args) {
		List<Object> list = DynamicObjectCreater.getList();
		InstanceManager instanceManager = (InstanceManager)DynamicObjectCreater.newInstanceObject("InstanceManager", list);
		list.add(instanceManager);
		ExecutePlan executePlan = (ExecutePlan)DynamicObjectCreater.newInstanceObject("ExecutePlan", list);
		list.clear();
		executePlan.execute(args);
	}

}
