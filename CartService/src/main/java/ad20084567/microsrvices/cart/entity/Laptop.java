package ad20084567.microsrvices.cart.entity;

public class Laptop implements Comparable<Laptop> {

	private String brand;
	private int price;
	private double ram;
	
	
	public Laptop(String brand, int price, double ram) {
		super();
		this.brand = brand;
		this.price = price;
		this.ram = ram;
	}
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getRam() {
		return ram;
	}
	public void setRam(double ram) {
		this.ram = ram;
	}
	
	
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", price=" + price + ", ram=" + ram + "]";
	}


	@Override
	public int compareTo(Laptop lap2) {
		
		if (this.getRam()>lap2.getRam()) {   //increasing order
			return 1;
		}
		else if (this.getRam()<lap2.getRam())
			return -1;
		return this.getBrand().compareTo(lap2.getBrand());
			
	}
	
	
	
}
