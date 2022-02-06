package ly.algjamia.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class CheckoutCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "order_id")
	private String orderId;
	@Column(name = "payment_type")
	private String paymentType;
	@Column(name = "delivery_address")
	private String deliveryAddress;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "product_id")
	private ShoeProduct shoeProduct;	
	private int quantity;
	private BigDecimal price;
	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	private Date orderDate;
	public CheckoutCart() {
		super();
	}
	public CheckoutCart(long id, String orderId, String paymentType, String deliveryAddress, Users users,
			ShoeProduct shoeProduct, int quantity, BigDecimal price, Date orderDate) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.paymentType = paymentType;
		this.deliveryAddress = deliveryAddress;
		this.users = users;
		this.shoeProduct = shoeProduct;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public ShoeProduct getShoeProduct() {
		return shoeProduct;
	}
	public void setShoeProduct(ShoeProduct shoeProduct) {
		this.shoeProduct = shoeProduct;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
}
