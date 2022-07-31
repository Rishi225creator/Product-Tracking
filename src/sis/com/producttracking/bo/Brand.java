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
public class Brand {
 private Long id;
 private String name;
 private String details;
 
 public Brand() {

}
 
 
 
public Brand(Long id) {
	super();
	this.id = id;
}



public Brand(Long id, String name, String details) {
	super();
	this.id = id;
	this.name = name;
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
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
 
 
 
 
 
}
