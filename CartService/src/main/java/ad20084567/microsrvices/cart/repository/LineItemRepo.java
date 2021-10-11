package ad20084567.microsrvices.cart.repository;

import org.springframework.data.repository.CrudRepository;

import ad20084567.microsrvices.cart.entity.LineItem;

public interface LineItemRepo extends CrudRepository<LineItem,Integer> {

}
