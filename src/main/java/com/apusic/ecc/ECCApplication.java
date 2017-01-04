package com.apusic.ecc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECCApplication{

	public static void main(String[] args){
		SpringApplication.run(ECCApplication.class);
	}
	
//	@Autowired
//	private UserRepository repository;

//	@Override
//	public void run(String... args) throws Exception {
//		this.repository.deleteAll();
//
//		// save a couple of customers
//		this.repository.save(new User("Alice", "Smith"));
//		this.repository.save(new User("Bob", "Smith"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (User customer : this.repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(this.repository.findByUserName("Alice"));
//		
//}
}
