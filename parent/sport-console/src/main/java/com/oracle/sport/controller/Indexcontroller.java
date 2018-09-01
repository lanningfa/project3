package com.oracle.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Service;

@Controller
public class Indexcontroller {
	@RequestMapping("index.do")
	
	public String index() {
		return "index";
	}
	@RequestMapping("top.do")
	
	public String top() {
		return "top";
	}
	@RequestMapping("main.do")
	
	public String main() {
		return "main";
	}
	
	@RequestMapping("left.do")
	
	public String left() {
		return "left";
	}
	@RequestMapping("right.do")
	
	public String right() {
		return "right";
	}
	@RequestMapping("product_main.do")
	public String product_main() {
		return "frame/product_main";
	}
	
	@RequestMapping("product_left")
	public String product_left() {
		return "frame/product_left";
	}
	 //到 添加页面
	@RequestMapping("toBrandAdd.do")
     public String toBrandAdd() {
		return "brand/add";
	}
	
	
}
