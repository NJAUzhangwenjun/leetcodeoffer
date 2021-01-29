package interviews;//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int m=sc.nextInt();
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int x=sc.nextInt();
			List<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < x; j++) {
				tmp.add(sc.nextInt());
			}
			list.add(tmp);
		}
		int res = code1(list);
		System.out.println(res);
	}

	public static int code1(List<List<Integer>> list){
		if (list.size()==0) return -1;
		HashSet<Integer> set = new HashSet<>();
		List<Integer> tmp=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(0)){
				tmp= list.get(i);
			}
		}

		for (int i = 0; i < tmp.size(); i++) {
			set.add(tmp.get(i));
		}

		List<Integer> tmp2=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (ifHas(tmp,list.get(i))){
				List<Integer> xx=list.get(i);
				tmp2.addAll(xx);
				for (int j = 0; j < xx.size(); j++) {
					set.add(xx.get(j));
				}
			}
		}
		List<Integer> tmp3=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (ifHas(tmp2,list.get(i))){
				List<Integer> yy=list.get(i);
				tmp3.addAll(yy);
				for (int j = 0; j < yy.size(); j++) {
					set.add(yy.get(j));
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if (ifHas(tmp3,list.get(i))){
				List<Integer> zz=list.get(i);
				tmp3.addAll(zz);
				for (int j = 0; j < zz.size(); j++) {
					set.add(zz.get(j));
				}
			}
		}
		return set.size();
	}

	public static boolean ifHas(List<Integer> list1,List<Integer> list2){
		for (int i = 0; i < list1.size(); i++) {
			int x=list1.get(i);
			if (list2.contains(x)){
				return true;
			}
		}
		return false;
	}
}
