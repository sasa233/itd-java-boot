package cn.yd.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product extends Object implements Serializable {

	/*
	 * create table product ( id int not null auto_increment, name varchar(20),
	 * price decimal(8,2), pic varchar(100), remark longtext, date timestamp
	 * default CURRENT_TIMESTAMP, primary key (id) );
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -3878976509085351163L;

	// 原始类型int不能存null；引用类型Integer的初始值为null
	// 原始类型无属性和方法
	// 因此在model中通常都采用引用类型
	private Integer id = null;
	private String name;
	// private Double price;
	private BigDecimal price;
	private String pic;
	private String remark;
	private Date date;

	public Product() {
		System.out.println("Product-----");
	}
	
//	public Product(String name, Date date) {
//		this.name = name;
//		this.date = date;
//	}

	// 如果子类的方法与父类相同，则称为重写
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "，pic=" + pic + ", remark=" + remark
				+ ", date=" + date + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setName-----");
	}

	// public Double getPrice() {
	// return price;
	// }
	// public void setPrice(Double price) {
	// this.price = price;
	// }
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

