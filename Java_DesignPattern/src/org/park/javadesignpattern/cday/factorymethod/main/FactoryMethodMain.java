package org.park.javadesignpattern.cday.factorymethod.main;

import org.park.javadesignpattern.cday.factorymethod.domain.IDCard;
import org.park.javadesignpattern.cday.factorymethod.domain.IDCardFactory;
import org.park.javadesignpattern.cday.factorymethod.framework.Factory;
import org.park.javadesignpattern.cday.factorymethod.framework.FactoryManager;
import org.park.javadesignpattern.cday.factorymethod.framework.Product;
import org.park.javadesignpattern.cday.factorymethod.framework.SingletonFactoryCreater;


/**
 * �ۼ��� ������
 * �ۼ���¥ 2017-05-08
 * �ۼ�����:
 * 
 * �˰Ե� �� 1) �߻� �޼ҵ�� ������ ���� ����Ŭ�������� ������ �� ����.
 * -> ���� �߻�޼ҵ忡�� ������ Ŭ�������� Ư�� �޼ҵ忡�� �����ϴ� �������
 * ���ȴ�.
 *           2) Factory �߻�Ŭ������ �뷫���� �����ȹ�� ������ �ִ� �����ӿ�ũ�̴�.
 *           �̸� ������ Ŭ����(IDCardFactory)�� �����ȹ�ȿ� �ִ� �޼ҵ带 �����Ѵ�.
 *                  
 *           3) Product �߻�Ŭ������ ������ Ŭ����(IDCard)
 *           �� ��ü�� Model�� �����Ѵ�.
 *            
 * 
 *
 */
public class FactoryMethodMain {

	public static void main(String[] args) {
		
		/*Factory factory = new IDCardFactory();
		Product card1 = factory.create("ȫ�浿");
		Product cart2 = factory.create("�̼���");
		Product cart3 = factory.create("������");
		
		card1.use();
		cart2.use();
		cart3.use();
		*/
		
		SingletonFactoryCreater.getSingletonFactoryCreater();
		FactoryManager factoryManager = SingletonFactoryCreater.getFactoryManager();
		factoryManager.setFactory("IDCardFactory");
		factoryManager.createProduct("ȫ�浿");
		factoryManager.createProduct("�̼���");
		factoryManager.createProduct("������");
		
		factoryManager.betchProcess();
	}

}
