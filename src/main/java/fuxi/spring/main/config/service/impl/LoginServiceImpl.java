package fuxi.spring.main.config.service.impl;

import fuxi.spring.main.config.entity.User;
import fuxi.spring.main.config.service.LoginService;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/2920:01
 */
@Service
public class LoginServiceImpl implements LoginService, BeanNameAware, BeanFactoryAware, InitializingBean,
		BeanPostProcessor {
	private final User user;

	public LoginServiceImpl(User user) {
		this.user = user;
		System.out.println("LoginServiceImpl.LoginServiceImpl"+user.toString());
	}


	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录是否哦成功
	 */
	@Override
	public Boolean login(String username, String password) {
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		System.out.println("user = " + user.toString());
		return true;
	}

	@Override
	public void setBeanName(String s) {
		System.out.println("beanName = " + s);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("LoginServiceImpl.setBeanFactory");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("LoginServiceImpl.afterPropertiesSet");
	}


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("LoginServiceImpl.postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("LoginServiceImpl.postProcessAfterInitialization");
		return bean;
	}

	@PreDestroy
	public void destroy_method() {
		System.out.println("LoginServiceImpl.init");
	}
	@Before
	public void before() {
		System.out.println("LoginServiceImpl.before");
	}
}
