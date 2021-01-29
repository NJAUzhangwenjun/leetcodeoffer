package fuxi.spring.main.config.service;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/2919:58
 */
public interface LoginService {

	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录是否哦成功
	 */
	Boolean login(String username, String password);
}
