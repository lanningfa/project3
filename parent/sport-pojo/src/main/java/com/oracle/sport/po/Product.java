package com.oracle.sport.po;

import java.io.Serializable;
import java.util.Date;

public class Product  implements Serializable{
	private static final long servialVersionUID=1L;
    private Long id;

    private Long brandId;

    private String name;

    private Float weight;

    private Integer isNew;

    private Integer isHot;

    private Integer isCommend;

    private Integer isShow;

    private Integer isDel;

    private String colors;

    private String sizes;

    private Date createTime;
    
    private String imgUrl;
    
    private String[] imgUrls;

    private String[] colorss;
    
    public String[] getColorss() {
		return colorss;
	}

	public void setColorss(String[] colorss) {
		this.colorss = colorss;
	}

	public String[] getSizess() {
		return sizess;
	}

	public void setSizess(String[] sizess) {
		this.sizess = sizess;
	}

	private String[] sizess;
  
	private String description;

    private String packageList;
    
    //分页属性
    private Integer size;//meiye tiaoshu
    private Integer fromLine;//dang hang 
    private Integer pageNo;
    
    public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	  public String[] getImgUrls() {
			return imgUrls;
		}

		public void setImgUrls(String[] imgUrls) {
			this.imgUrls = imgUrls;
		}

    
    public Integer getFromLine() {
		return fromLine;
	}

	public void setFromLine(Integer fromLine) {
		this.fromLine = fromLine;
	}

	
    
    
    public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}


    

    public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPackageList() {
		return packageList;
	}

	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(Integer isCommend) {
        this.isCommend = isCommend;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors == null ? null : colors.trim();
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes == null ? null : sizes.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}