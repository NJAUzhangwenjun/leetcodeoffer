package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/8/2719:57
 */
public class JD {
	private List<Integer> list = new ArrayList<>();

	public List<Integer> getPrimeNumber(int[] ints, int n) {
		if (ints == null || ints.length == 0) {
			return list;
		}
		getPrimeNumber(ints, 0, n);

		Collections.sort(list);
		return list;
	}

	private void getPrimeNumber(int[] ints, int k, int n) {
		if (list.size() >= n || ints.length <= k)
			return;


	}
}
