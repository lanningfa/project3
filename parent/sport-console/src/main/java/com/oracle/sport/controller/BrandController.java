package com.oracle.sport.controller;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.sport.brand.BrandService;
import com.oracle.sport.po.Brand;

@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	@RequestMapping("brandList.do")
	public String brandList(Model model,String name ,String isDisplay,Integer pageNo,Integer pageSize) {
		
		model.addAttribute("pagination",brandService.selectBrands(name,isDisplay,pageNo,pageSize));
		model.addAttribute("name",name);
		model.addAttribute("isDisplay", isDisplay==null||isDisplay.equals("null")?"1":isDisplay);
		
		return "brand/list";
		
	}
	//删除单个
	@RequestMapping("deleteBrand.do")
	public String deleteBrand(Long id,String name ,String isDisplay,Integer pageNo,Integer pageSize) {
		System.out.println(id);
		brandService.deleteByPrimaryKey(id);
		
		return "redirect:brandList.do?name="+name+"&isDisplay="+isDisplay+"&pageNo="+pageNo+"&pageSize="+pageSize;
	
	}
	//删除所有
	@RequestMapping("deleteBrands.do")
	public String deleteBrands(Long []ids,String name ,String isDisplay,Integer pageNo,Integer pageSize) {
		brandService.deleteBrandsByids(ids);
		String string="redirect:brandList.do?name="+name+"&isDisplay="+isDisplay+"&pageNo="+pageNo+"&pageSize="+pageSize;
		System.out.println(string);
		return "redirect:brandList.do?name="+name+"&isDisplay="+isDisplay+"&pageNo="+pageNo+"&pageSize="+pageSize;
	
	}
	
	//单张图片上传
	@ResponseBody
	@RequestMapping("upload.do")
	public String upload(MultipartFile file,HttpSession session){
		String path = session.getServletContext().getRealPath("upload");
		try {
			file.transferTo(new File(path+File.separator+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "http://localhost:8081/upload/"+file.getOriginalFilename();
	}
	
	//添加图片地址到数据库
	@RequestMapping("addBrand.do")
	public String addBrand(Brand brand){
		brandService.insertSelective(brand);
		return "redirect:brandList.do";
	}
	
	//传参去修改页面，
	@RequestMapping("toUpdate.do")
	public String toUpdate(Long id,String name,Integer isDisplay,Integer pageNo,Model model){
		
		model.addAttribute("brand", brandService.selectByPrimaryKey(id));
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		model.addAttribute("pageNo",pageNo);
		return "brand/edit";
		
	}
	//修改操作
		@RequestMapping("editBrand.do")
		public String editBrand(Brand brand,String name0,Integer isDisplay0,Integer pageNo){
			
			brandService.updateByPrimaryKeySelective(brand);
	       // System.out.println("redirect:brandList.do?name="+name0+"&isDisplay="+isDisplay0+"&pageNo="+pageNo);
			String returnUrl = "";
	        try {
				returnUrl = "redirect:brandList.do?name="+URLEncoder.encode(name0, "utf-8")+"&isDisplay="+isDisplay0+"&pageNo="+pageNo;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return returnUrl;
		}
	
}
