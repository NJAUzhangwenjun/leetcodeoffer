package interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1210:56
 */

public class Solution {

	public ArrayList<Box> maxHeight(Box[] boxes) {
		Map<Box, ArrayList<Box>> cache = new HashMap<Box, ArrayList<Box>>();
		return maxHeight(boxes, null, cache);
	}

	private ArrayList<Box> maxHeight(Box[] boxes, Box bottom, Map<Box, ArrayList<Box>> cache) {
		// 用于实现DP的思想，注意每个返回值要clone一份，否则返回去之后cache中结果也会被外界引用的改变而改变。
		if (cache.containsKey(bottom))
			return (ArrayList<Box>) cache.get(bottom).clone();
		int maxHeight = 0;
		ArrayList<Box> res = new ArrayList<Box>();
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canAbove(bottom)) {
				// 递归求解上面的箱子
				ArrayList<Box> tmp = maxHeight(boxes, boxes[i], cache);
				// 计算堆的高度
				int curHeight = calcu(tmp);
				if (curHeight > maxHeight) {
					curHeight = maxHeight;
					res = tmp;
				}
			}
		}

		// 当前箱子加进去
		if (bottom != null)
			res.add(bottom);
		// 结果放入cache中用于dp
		cache.put(bottom, res);

		return res;

	}

	private int calcu(List<Box> list) {
		int res = 0;
		for (Box each : list) {
			res += each.h;
		}
		return res;
	}

	public static void main(String[] args) {
		Box[] boxes = { new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3) };
		System.out.println(new Solution().maxHeight(boxes));

	}
}

class Box {
	int w;
	int h;
	int d;

	public Box(int w, int h, int d) {
		this.w = w;
		this.h = h;
		this.d = d;
	}

	boolean canAbove(Box b) {
		if (b == null)
			return true;
		return w < b.w && h < b.h && d < b.d;
	}

	@Override
	public String toString() {
		return "Box [w=" + w + ", h=" + h + ", d=" + d + "]";
	}

}
