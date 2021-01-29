package interviews;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRemoveDuplicate {

    public static void main(String[] args) {
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

    public static List getDuplicatedElementRemove(List list){
        List copyList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if( !copyList.contains(list.get(i))){
                copyList.add(list.get(i));
            }
        }
        return copyList;

    }

}
