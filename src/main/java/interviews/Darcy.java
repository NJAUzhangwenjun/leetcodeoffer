package interviews;

import java.util.*;

/**
 * @Description: 达西笔试
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/2222:09
 */
public class Darcy {
	/**
	 * 合并时间区间
	 * 1.首先根据二维数组中每个一维数组的[0]进行升序排序，即根据start进行排序；
	 * ######################》》》》》》》》》》》2.合并条件是前一个的结束 大于等于 后一个的开始
	 * 3.然后建立linkedList作为中间处理对象，当集合为空或者不满足条件，加入集合的末尾；
	 * 4.集合不为空且满足合并条件时，取集合中最后一个元素让它的end为原值和合并区间end中的最大值，
	 * 解决1,5;2,4这样的区间问题。
	 * 5.集合处理完成，对其循环遍历取首元素，放入res结果数组中
	 * @param arr
	 * @return
	 */
	/**
	 * 第一题
	 * @param arr
	 * @return
	 */
	public int[][] merge(int[][] arr) {
		Arrays.parallelSort(arr, Comparator.comparingInt(x -> x[0]));

		LinkedList<int[]> list = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (list.size() == 0 || list.getLast()[1] < arr[i][0]) {
				//集合为空，或不满足条件，向后新增
				list.add(arr[i]);
			} else { // [[x1,y1],[x2,y2]]
				// y1>=y2 此时就需要合并
				//满足条件，集合最后元素的end=最大值
				list.getLast()[1] = Math.max(list.getLast()[1], arr[i][1]);
			}
		}
		//生成结果数组
		int[][] res = new int[list.size()][2];
		int index = 0;
		while (!list.isEmpty()) {
			//删除集合首元素
			res[index++] = list.removeFirst();
		}
		return res;
	}


	/**
	 * 缩写校验
	 * 用指针i,j分别指向s与abbr，若j所指位置为数字，则先求出当前数字的大小times，然后i跳过times个字符。
	 *
	 * 如果j所指位置为字符，则直接判断两指针所指字符是否相等
	 *
	 * 最后判断i，j是否都已经到末尾，若是返回true，否则说明匹配不上，返回false
	 *
	 * 注意处理前导0的情况，在本题中前导0非法
	 * @param word
	 * @param abbr
	 * @return
	 */
	/**
	 * 第二题
	 * @param word
	 * @param abbr
	 * @return
	 */
	public boolean validWordAbbreviation(String word, String abbr) {
		char[] words = word.toCharArray();
		char[] abbrs = abbr.toCharArray();

		int i=0, j=0;
		while(i < words.length && j < abbrs.length){
			//若abbr中包含非前导0的数字
			if(Character.isDigit(abbrs[j]) && abbrs[j] != '0'){
				//当前数字，eg:"i12i"中的12
				int times = 0;
				int cnt = 1;
				while(j < abbrs.length && Character.isDigit(abbrs[j])){
					times = cnt*times + abbrs[j] - '0';
					cnt = 10*cnt;
					j++;
				}
				i = i + times;
			}else{  //否则直接按位判断字符
				if(words[i] != abbrs[j])
					return false;
				i++;
				j++;
			}
		}

		if(i == words.length && j == abbrs.length)
			return true;
		return false;
	}

	/**
	 * 第三题
	 *最⼩惩罚
	 */
	static int beautifulPath(int n, int[][] edges, int start, int end) {
		Map<Integer, Map<Integer, Integer>> edgesMap = getEdgesMap(n, edges);
		int result = minPath(edgesMap, start, end);
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	//获得点到其它的距离集合
	private static Map<Integer, Map<Integer, Integer>> getEdgesMap(int n, int[][] edges) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>(2 * n);
		List<int[]> list = new ArrayList<>(n);
		Collections.addAll(list, edges);
		list.forEach(e -> {
			int start = e[0];
			int end = e[1];
			int distance = e[2];
			map.computeIfAbsent(start, k -> new HashMap<Integer, Integer>(n));
			map.get(start).merge(end, distance, (a, b) -> b < a ? b : a);
		});
		return map;
	}

	//深度优先，获取所有可能的路径及惩罚
	private static int minPath(Map<Integer, Map<Integer, Integer>> edgesMap, int start, int end) {
		Map<Integer, Integer> startMap = edgesMap.get(start);
		int result = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> e : startMap.entrySet()) {
			int next = e.getKey();
			int path = e.getValue();
			if (next != end) {
				edgesMap.remove(start);
				path = path | minPath(edgesMap, next, end);
				edgesMap.put(start, startMap);
			}
			if (path < result) {
				result = path;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 100}};
		System.out.println(beautifulPath(3, edges, 1, 3));
	}

}
