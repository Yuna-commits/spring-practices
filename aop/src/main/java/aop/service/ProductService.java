package aop.service;

import org.springframework.stereotype.Service;

import aop.domain.Product;

@Service
public class ProductService {
	
	/* @Around : Before */
	/* @Before */
	public Product find(String name) throws RuntimeException {
		if(name == null) {
			throw new RuntimeException("empty name");
			/* @AfterThrowing */
		}
		System.out.println("finding...");
		return new Product(name);
		/* @AfterReturning */
	} 
	/* @After */
	/* @Around : After */

}
