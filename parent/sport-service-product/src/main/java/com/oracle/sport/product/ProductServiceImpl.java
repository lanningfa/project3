package com.oracle.sport.product;


import java.util.List;

import org.mockito.asm.tree.IntInsnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.sport.mapper.BrandMapper;
import com.oracle.sport.mapper.ProductMapper;
import com.oracle.sport.po.Product;
import com.oralce.sport.Utils.Array2String;

import cn.itcast.common.page.Pagination;
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	
	public Pagination selectProducts(Product record) {
		//System.out.println("---------"+record);
		
			if(record.getName()!=null&&"".equals(record.getName())){
				record.setName(null);
			}
			if(record.getBrandId()!=null&&record.getBrandId()==0){
				record.setBrandId(null);
			}
			if(record.getIsShow()!=null&&record.getIsShow()==2){
				record.setIsShow(null);
			}
			if(record.getSize()==null||record.getSize().equals("")){
				record.setSize(8);
			}
			if(record.getPageNo()==null||record.getPageNo().equals("")){
				record.setPageNo(1);
			}
	
		
		record.setFromLine((record.getPageNo()-1)*record.getSize());
		
		List<Product> plist = productMapper.selectProducts(record);
		for (Product product : plist) {
			product.setImgUrls(product.getImgUrl().split(","));
		}
		
		Pagination pagination = new Pagination(record.getPageNo(), record.getSize(), productMapper.selectProductcount(record), plist);
		
        StringBuilder params = new StringBuilder();		
		
		params.append("size=8");
		
		if(record.getName()!=null){
			params.append("&name="+record.getName());
		}
		if(record.getBrandId()!=null){
			params.append("&brandId="+record.getBrandId());
		}
		if(record.getIsShow()!=null){
			params.append("&isShow="+record.getIsShow());
		}
		
		String url = "productList.do";
		
		pagination.pageView(url, params.toString());
		
		
		return pagination;
	}


	public void deleteById(Long id) {
		productMapper.deleteById(id);
	}


	public void deleteByIds(Long[] ids) {
		productMapper.deleteByIds(ids);
	}


	public void groundingByIds(Long[] ids) {
		productMapper.groundingByIds(ids);
	}


	public void undercarriageByIds(Long[] ids) {
		productMapper.undercarriageByIds(ids);
	}


	public void insertSelective(Product record) {
		record.setImgUrl(Array2String.array2String(record.getImgUrls()));
		record.setColors(Array2String.array2String(record.getColorss()));
		record.setSizes(Array2String.array2String(record.getSizess()));
		record.setIsDel(1);
		record.setIsShow(0);
		productMapper.insertSelective(record);
	}

}
