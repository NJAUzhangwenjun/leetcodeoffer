import java.util.Arrays;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/8/3019:32
 */
public class Dada {
	//快速排序
	void quickSort(int s[], int l, int r) {
		if (l < r) { //将中间的这个数和第一个数交换，这样的话，第一个数就是中间的数
			int i = l, j = r, x = s[i];
			while (i < j) {
				while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];
				while (i < j && s[i] <= x) // 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];

			}
			s[i] = x;
			quickSort(s, l, i - 1); // 递归调用
			quickSort(s, i + 1, r);

		}
	}

  public static void main(String[] args) {
	  int[] s = {1, 2, 3,102,23, 4, 5, 6, 7, 8, 9, 10};
	  new Dada().quickSort(s,0,s.length-1);
    System.out.println("s = " + Arrays.toString(s));
  }

	//冒泡排序
	void bubbleSort(int s[]) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length - 1 - i; j++) {
				if (s[j] > s[j + 1]) {
					int temp = s[j];
					s[j] = s[j + 1];
					s[j + 1] = temp;
				}
			}
		}
	}


	void process(){
		int[] s = {1, 2, 3,102,23, 4, 5, 6, 7, 8, 9, 10};
		bubbleSort(s);
		System.out.println("s = " + Arrays.toString(s));
	}
}
