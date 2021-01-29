package fuxi.spring.main.config.cfg;

import fuxi.spring.main.config.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/2920:51
 */
@Configuration
public class Cfg {
	@Bean
	public User user() {
		User user = new User();
		user.setUsername("涨停");
		user.setPassword("32317128");
		return user;
	}
}
