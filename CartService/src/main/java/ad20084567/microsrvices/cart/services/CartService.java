package ad20084567.microsrvices.cart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad20084567.microsrvices.cart.entity.Cart;
import ad20084567.microsrvices.cart.repository.CartRepo;

@Service
public class CartService {
	//static int counter = 0;

	@Autowired
	private CartRepo repository;

	// get
	public Cart searchCart(int id) {
		Cart cart = repository.findById(id).get();
		return cart;

	}

	// get all
	public List<Cart> searchAllCart() {
		List<Cart> carts = (List<Cart>) repository.findAll();
		return carts;
	}

	// post
	public Cart addCart(Cart c) {
		Cart cart = c;
		// cart.setCartId(++counter);
		Cart saveCart = repository.save(cart);
		return saveCart;
	}

	// put
	public Cart updateCart(int id, Cart cart) {
		Optional<Cart> carts = repository.findById(id);
		Cart cart2 = carts.get();
		cart2.setLineItem(cart.getLineItem());

		return repository.save(cart2);

	}

	// delete
	public Cart emptyCart(int id) {
		Optional<Cart> carts = repository.findById(id);
		Cart cart = carts.get();
		repository.delete(cart);
		return cart;
	}

}
