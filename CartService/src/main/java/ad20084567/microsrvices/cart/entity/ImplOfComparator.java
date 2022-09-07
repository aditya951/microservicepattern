package ad20084567.microsrvices.cart.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImplOfComparator {

	public static void main(String[] args) {

		List<Laptop> lst = new ArrayList<>();

		lst.add(new Laptop("hp", 5200, 4096.25));
		lst.add(new Laptop("dell", 59430, 2096.86));
		lst.add(new Laptop("lenovo", 2300, 3096.48));
		lst.add(new Laptop("apple",500 , 2096.86));
//		lst.add(new Laptop("hp",5200 , 4096.25));

		//System.out.println(lst.toString());

		Collections.sort(lst); // need to implements comparable interface and override method in model class

		for (Laptop laptop : lst) {
			System.out.println(laptop);
		}

		System.out.println("=====================================1");

		Comparator<Laptop> com = new Comparator<Laptop>() {
			@Override
			public int compare(Laptop l1, Laptop l2) {
				if (l1.getPrice() > l2.getPrice()) {return 1;}
				else return -1;
			}
		};

		Collections.sort(lst, com);

		for (Laptop laptop : lst) {
			System.out.println(laptop);
		}
		Comparator<Laptop> revOrd = Collections.reverseOrder(com);
		Collections.sort(lst, revOrd);
		System.out.println("=====================================2");

		lst.forEach(System.out::println);
		
		System.out.println("=====================================");
		Collections.sort(lst, Comparator.comparing(Laptop::getBrand).thenComparing(Laptop::getPrice).reversed());
		
		lst.forEach(System.out::println);
	}
	
}