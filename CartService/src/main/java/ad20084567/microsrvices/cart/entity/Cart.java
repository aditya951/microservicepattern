package ad20084567.microsrvices.cart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Cart {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cartId;
	
	@OneToMany(targetEntity =LineItem.class, cascade = CascadeType.ALL )
	@JoinColumn(name = "cart_fk", referencedColumnName = "cartId")
	private List<LineItem> lineItem;
	
	public Cart() {
		super();
	}
	
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public List<LineItem> getLineItem() {
		return lineItem;
	}
	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}


	@Override
	public String toString() {
		return "LineItem [cartId=" + cartId + ", lineItem=" + lineItem + "]";
	}
	

}
