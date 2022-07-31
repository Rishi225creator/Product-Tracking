package sis.com.producttracking.bo;

/*
@Author:Surendra Kumar Sao

	>>Software Architect and Corporate Trainer
	>>+13 year exp in (mumbai,pune,hyd,bangaluru)
	>>Java Certified SCJP & SCWCD with 98%
	Trained more than 5k students and employees.
    MCA from (NIT)National Institute of Technology Raipur(C.G.)
	Email : sur.nit.mca@gmail.com
	Mobile 7987234544  , 9009442844
		@copyright  surendra 2022
	https://www.urbanpro.com/raipur/surendra-kumar-sao/reviews/7223178
	https://www.urbanpro.com/raipur/surendra-kumar-sao/1334109?_tp=
 
   CurrentYear ${2022} 
 */
public class Product {
	private Long id;// null;
	private String name; // null;
	private Float price;// null;
	private String details;// null;
	// private Long brandId;//0
	// private Long categoryId;//0
	private Brand brand;// = new Brand(100L); //null;
	private Category category; // =new Category(null); //null;

	public Product() {

	}

	public Product(Long id) {
		this.id = id;
	}

	public Product(Long id, String name, Float price, String details) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Brand brandId() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Brand getBrand() {
		return brand;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
