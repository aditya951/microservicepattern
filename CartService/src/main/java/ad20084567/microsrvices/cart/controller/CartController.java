package ad20084567.microsrvices.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ad20084567.microsrvices.cart.entity.Cart;
import ad20084567.microsrvices.cart.services.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService service;
	

	@GetMapping("/hello")
	public String hello() {
		//throw new CustomException("id not found");
		return "Welcome to TestController";
	}
	@GetMapping("api/jpa/carts")
	public List<Cart> getAccounts(){
		List<Cart> cust = service.searchAllCart();
//		if(cust.size() ==0) {
//			throw new CustomException("No Carts to display");
//		}
		return cust;
	}
	
	@GetMapping("/api/jpa/carts/{id}")
	public Cart getCart(@PathVariable int id) {
		Cart cust=service.searchCart(id);
//		if(cust ==null) {
//			throw new CustomException("id not found");
//		}
	return cust;
	}
	
	
	@PostMapping("/api/jpa/carts")
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
		
		Cart createcust=service.addCart(cart);
		return new ResponseEntity<Cart>(createcust, HttpStatus.CREATED);
	}
	
	@PutMapping("/api/jpa/Carts/{id}")
	public Cart updatedCart(@PathVariable int id,@RequestBody Cart cust) {
		Cart updatecust=service.updateCart(id, cust);
//		if(updatecust==null) {
//			throw new CustomException("id not found");
//		}
		return updatecust;
	}
	
	@DeleteMapping("api/jpa/customers/{id}")
	public Cart deleteCustomer(@PathVariable int id) {
		Cart deletecust=service.emptyCart(id);
//		if(deletecust==null) {
//			throw new CustomException("id not found");
//			}
		return deletecust;
	}

}
