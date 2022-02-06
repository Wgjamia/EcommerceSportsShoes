package ly.algjamia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="category_name")
	private String categoryName;
	@Column(name="category_desc")
	private String categoryDesc;
	@OneToMany(mappedBy = "category")
	private List<ShoeProduct> products=new ArrayList<ShoeProduct>();
	public Category() {
		super();
	}
	public Category(Long id, String categoryName, String categoryDesc, List<ShoeProduct> products) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public List<ShoeProduct> getProducts() {
		return products;
	}
	public void setProducts(List<ShoeProduct> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", categoryDesc=" + categoryDesc
				+ ", products=" + products + "]";
	}
		
	
}
