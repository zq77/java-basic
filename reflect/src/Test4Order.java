
public class Test4Order {
//��Ʒ������
	String productname = null;
//��Ʒ������
	int count = 0;
//��Ʒ�ĵ���
	int unitprice = 0;

	public int price () {
		return count * unitprice;
	}
	@Override
	public String toString() {
		return productname + "-" + this.price() ;
	}

	/**
	 * ��װ���۲���
	 * ����ģʽ
	 */
	
	public static void main(String[] args) {
		Test4Order order = new Test4Order();
		order.setCount(10);
		order.setProductname("Apple");
		order.setUnitprice(4500);
		System.out.println(order);

	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	
}
