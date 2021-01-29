package fuxi.spring.main;

import fuxi.spring.main.config.main.Config;
import fuxi.spring.main.config.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/2919:55
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		LoginService loginService = context.getBean(LoginService.class);
		Boolean zhangsan = loginService.login("zhangsan", "234234234");
//		System.out.println("zhangsan = " + zhangsan);
//		System.out.println("loginService = " + loginService.toString());
		Object user = context.getBean("user");
		System.out.println("user = " + user);
		Object user1 = context.getBean("user");
		System.out.println("user = " + user1);
		Object user2 = context.getBean("user");
		System.out.println("user = " + user2);
		Object user3 = context.getBean("user");
		System.out.println("user = " + user3);

	}
}
