package ly.algjamia.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="shoe_product")
public class ShoeProduct {
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long pid;
	@Column(name = "product_name")
	private String pname;
	@Column(name = "product_Desc")
	private String pDesc;
	@Column(name = "product_photo")
	private String pPhoto;
	private BigDecimal price;
	private int quantity;
	@ManyToOne
	private Category category;
	@ManyToOne
	private SizeShoe sizeShon;
	
	public ShoeProduct() {
		super();
	}

	
	public ShoeProduct(Long pid, String pname, String pDesc, String pPhoto, BigDecimal price, int quantity,
			Category category, SizeShoe sizeShon) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pDesc = pDesc;
		this.pPhoto = pPhoto;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.sizeShon = sizeShon;
	}


	public SizeShoe getSizeShon() {
		return sizeShon;
	}


	public void setSizeShon(SizeShoe sizeShon) {
		this.sizeShon = sizeShon;
	}


	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public String getpPhoto() {
		return pPhoto;
	}

	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Transient
	public String getLogoImageOfProduct() {
		if ( pPhoto == null ) {
			return null;
		}else
			return "/product_images/"+pid+ "/"+pPhoto;
		
	}

	
	
	
}
