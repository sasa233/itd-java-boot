package cn.yd.shop.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.yd.shop.model.Product;
import cn.yd.shop.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Resource
	private ProductServiceImpl productService = null;

	// @RequestMapping("/")
	@RequestMapping("/save")
	public String save(Product product) {
//		@RequestParam("img") MultipartFile file
//		// 实现文件上传
//		String path = request.getServletContext().getRealPath("/images/");
//		// 上传文件名
//		String filename = file.getOriginalFilename();
//		File dest = new File(path, filename);
//		try {
//			file.transferTo(dest);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		product.setPic(filename);
		productService.save(product);
		return "redirect:/query.jsp";
	}
	// @ResponseBody //返回的不是页面而是内容，一版用于ajax请求，此处用于测试
	// public String home(){
	// System.out.println("Testing......");
	// productService.save(new Product());
	// return "Hello World!";
	// }

	@RequestMapping("/query")
	public String query(String keyword) {
		session.setAttribute("keyword", keyword);
		List<Product> proList = productService.queryByName(keyword);
		request.setAttribute("proList", proList);
		return "forward:/query.jsp";
	}

}