package ly.algjamia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="size_shoe")
public class SizeShoe {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="size_name")
	private String SizeName;
	@OneToMany(mappedBy = "sizeShon")
	private List<ShoeProduct> products=new ArrayList<ShoeProduct>();
	public SizeShoe() {
		super();
	}
	public SizeShoe(Long id, String sizeName, List<ShoeProduct> products) {
		super();
		this.id = id;
		SizeName = sizeName;
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSizeName() {
		return SizeName;
	}
	public void setSizeName(String sizeName) {
		SizeName = sizeName;
	}
	public List<ShoeProduct> getProducts() {
		return products;
	}
	public void setProducts(List<ShoeProduct> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return SizeName;
	}

	
}
