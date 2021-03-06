package cn.yd.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yd.shop.dao.impl.ProductDaoImpl;
import cn.yd.shop.model.Product;


@Service  // (value = "productService") // 默认是当前类名(且第一个字母小写)
public class ProductServiceImpl{

	// 曾与层之间采用接口依赖，具体注入的实现类取决于spring-bean.xml中配置的真实类型
	
	//private ProductDaoImpl productDao = new ProductDaoImpl();
	
	public ProductServiceImpl(){
		System.out.println("ProductServiceImpl()只能执行一次。。。。");
	}
	
	@Resource(name="productDao")
	private ProductDaoImpl productDao = null;
    

	/* (non-Javadoc)
	 * @see cn.yd.shop.service.ProductService#queryByName(java.lang.String, int, int)
	 */
	public List<Product> queryByName(String name, int page, int size) throws Exception {
		return productDao.queryByBame(name, page, size);
	}

	// java中集合不限大小
	// 如果没有给集合制定类型，则默认为object类型，可以指定泛型
	// 数组和集合的区别：数组限制大小、类型（需指定），集合不限大小、类型，泛型集合不限大小、限类型
	/* (non-Javadoc)
	 * @see cn.yd.shop.service.ProductService#queryByName(java.lang.String)
	 */
	public List<Product> queryByName(String name) {
		System.out.print("Query now......");
		return productDao.queryByBame(name);
	}

	// 通过id获取Product
	/* (non-Javadoc)
	 * @see cn.yd.shop.service.ProductService#getById(int)
	 */
	public Product getById(int id) throws Exception {
		return productDao.getById(id);
	}

	// 完成数据的插入操作
	/* (non-Javadoc)
	 * @see cn.yd.shop.service.ProductService#save(cn.yd.shop.model.Product)
	 */

	public void save(Product product) {
		productDao.save(product);
		// 执行其他的数据库操作
		// 配置事务，测试是否回滚
		// 此处动态代理并没有实现代理类与目标类的接口，采用cglib的方式？？？
//		Integer.parseInt("xxx");
//		System.out.println("AOP讲解");
	}

	/* (non-Javadoc)
	 * @see cn.yd.shop.service.ProductService#update(cn.yd.shop.model.Product)
	 */
	public void update(Product product) {
		productDao.update(product);
	}

	// public void delete(Product product) {
	// 方法参数超过1-2个，需要进行封装；只有1个的话，就直接传入——参数设计越简单越好
	/* (non-Javadoc)
	 * @see cn.yd.shop.service.ProductService#delete(int)
	 */
	public void delete(int id) {
		productDao.delete(id);
	}
}

