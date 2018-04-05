package cn.yd.shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.yd.shop.model.Product;

@Repository("productDao")
public class ProductDaoImpl {
	// ProductDaoImpl依赖jdbcTemplate
	
	@Resource
	private JdbcTemplate jdbcTemplate;


	// 通过id获取制定的商品数据
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.shop.dao.ProductDao#getById(int)
	 */
	public Product getById(int id) {
		String sql = "select * from product where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setRemark(rs.getString("remark"));
				return product;
			}
		}, id);
	}

	// 如果没有给集合指定类型,则默认就是object类型.可以指定泛型<Product>
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.shop.dao.ProductDao#queryByBame(java.lang.String)
	 */
	public List<Product> queryByBame(String name) {
		String sql = "select * from product where name like ?";
		return jdbcTemplate.query(sql, new Object[] { "%" + name + "%" },
				new BeanPropertyRowMapper<Product>(Product.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.shop.dao.ProductDao#queryByBame(java.lang.String, int, int)
	 */
	public List<Product> queryByBame(String name, int page, int size) {
		String sql = "select * from product where name like ? limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { "%" + name + "%", (page - 1) * size, size },
				new BeanPropertyRowMapper<Product>(Product.class));
	}

	// 完成数据的插入操作 ctrl + shift + f
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.shop.dao.ProductDao#save(cn.yd.shop.model.Product)
	 */

	public void save(Product product) {
		String sql = "insert into product (name,price,remark,pic) values (?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getPic() });
		// 执行其他的数据库操作
		// 如下语句执行时会报错，java.lang.NumberFormatException: For input string: "xxx"
		// at
		// java.lang.NumberFormatException.forInputString(NumberFormatException.java:65
		// 此处需要处理异常，否则无法回滚，因此需要关注与核心逻辑相关联的有一定耦合性的代码（AOP），例如异常、事务等
		// Integer.parseInt("xxx");
		// System.out.println("AOP讲解");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.shop.dao.ProductDao#update(cn.yd.shop.model.Product)
	 */
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?   ";
		jdbcTemplate.update(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.shop.dao.ProductDao#delete(int)
	 */
	public void delete(int id) {
		String sql = "delete from product where id = ?";
		jdbcTemplate.update(sql, id);
	}

}
