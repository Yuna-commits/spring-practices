package aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.domain.Product;
import aop.service.ProductService;

public class App {

	public static void main(String[] args) {
		// @Before, @After, @AfterReturning, @Around
		test01();
		
		// @Before, @After, @AfterThrowing, @Around
		// test02();
	}
	
	public static void test01() {
		/**
		 *  Container 구현체
		 *  <<interface>> ConfigurableApplicationContext <-- ClassPathXmlApplicationContext
		 *  class path의 xml 파일 속 application context를 읽어서 컨테이너에 빈 설정
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		Product p = ps.find("TV");
		
		System.out.println(p);
		
		((ConfigurableApplicationContext)ac).close();
	}
	
	public static void test02() {
		/**
		 *  Container 구현체
		 *  <<interface>> ConfigurableApplicationContext <-- ClassPathXmlApplicationContext
		 *  class path의 xml 파일 속 application context를 읽어서 컨테이너에 빈 설정
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		Product p = ps.find(null);
		
		System.out.println(p);
		
		((ConfigurableApplicationContext)ac).close();
	}
	
}
