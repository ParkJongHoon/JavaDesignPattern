package org.park.javadesignpattern.factorymethod.main;

import org.park.javadesignpattern.factorymethod.framework.Factory;
import org.park.javadesignpattern.factorymethod.framework.Product;
import org.park.javadesignpattern.factorymethod.idcard.IDCard;
import org.park.javadesignpattern.factorymethod.idcard.IDCardFactory;


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
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("ȫ�浿");
		Product cart2 = factory.create("�̼���");
		Product cart3 = factory.create("������");
		
		card1.use();
		cart2.use();
		cart3.use();
		
	}

}
