package ly.algjamia.model;


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class AddToCart {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "product_id")
	private ShoeProduct shoeProduct;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;
	private int quantity;
	private BigDecimal price;
	@Temporal(TemporalType.DATE)
	private Date added_date;
	public AddToCart() {
		super();
	}
	public AddToCart(Long id, ShoeProduct shoeProduct, Users users, int quantity, BigDecimal price, Date added_date) {
		super();
		this.id = id;
		this.shoeProduct = shoeProduct;
		this.users = users;
		this.quantity = quantity;
		this.price = price;
		this.added_date = added_date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ShoeProduct getShoeProduct() {
		return shoeProduct;
	}
	public void setShoeProduct(ShoeProduct shoeProduct) {
		this.shoeProduct = shoeProduct;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}

	
	

}
