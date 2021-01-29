package interviews;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2020/6/913:59
 */
public class NineByNineAlgorithm {

  public void printleft(int num) {

    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        out.print((i * j) + " ");
      }
      out.println();
    }
  }

  public void printright(int num) {
    for (int i = 1; i <= num; i++) {
      int cut = i - 1;
      while (cut != 0) {
        System.out.print("  ");
        cut--;
      }
      for (int j = i; j <= num; j++) {
        System.out.print(i * j + " ");
      }
      System.out.println();
    }
  }


  public static List getDuplicatedElementRemove(List list){
    List copyList = new ArrayList();
    for (int i = 0; i < list.size(); i++) {
      if( !copyList.contains(list.get(i))){
        copyList.add(list.get(i));
      }
    }
    return copyList;

  }

  public static void main(String[] args) {
    NineByNineAlgorithm nineByNineAlgorithm = new NineByNineAlgorithm();
    nineByNineAlgorithm.printright(9);
    nineByNineAlgorithm.printleft(9);

    List<Integer> list = new ArrayList<>();
    list.add(11);
    list.add(11);
    list.add(22);
    list.add(33);
    list.add(44);
    list.add(44);
    list.add(11);
    list.add(55);
    System.out.println("list1:"+list);
    System.out.println("list2:"+getDuplicatedElementRemove(list));
  }
}
