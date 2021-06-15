
public class Test4Order {
//产品的名称
	String productname = null;
//产品的数量
	int count = 0;
//产品的单价
	int unitprice = 0;

	public int price () {
		return count * unitprice;
	}
	@Override
	public String toString() {
		return productname + "-" + this.price() ;
	}

	/**
	 * 封装打折策略
	 * 工厂模式
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
