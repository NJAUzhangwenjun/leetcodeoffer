package fuxi.collection;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @Description: TODO
 *
 * @author 张文军 @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/1622:10
 */
public class Arr {
  public static void main(String[] args) {
    int[] a = new int[3];
    a[0] = 0;
    a[1] = 1;
    a[2] = 2;
    int[] b = Arrays.copyOf(a, 12);
    System.out.println("b.length = " + Arrays.toString(b));

    List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
    list.add(1);

    LinkedList<Integer> list2 = new LinkedList<>();
    list2.add(1);

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
  }

  public void ss() throws Exception {
    FileInputStream inputStream = new FileInputStream(new File(""));
  }
}
