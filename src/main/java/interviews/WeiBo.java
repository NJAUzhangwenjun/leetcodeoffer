package interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/710:13
 */
public class WeiBo {
	private static volatile WeiBo instance;

	private WeiBo() {
	}

	public WeiBo getInstance() {
		if (instance == null) {
			synchronized (WeiBo.class) {
				if (instance == null) {
					instance = new WeiBo();
				}
			}
		}
		return instance;
	}

	public void getIndex(int[] ints, int sum) {
		if (ints == null || ints.length <= 0)
		return;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < ints.length; i++) {
			list.add(ints[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.contains(sum - list.get(i))) {
				System.out.println(i+":"+list.indexOf(sum - list.get(i)));
			}
		}

	}
}


