package fuxi.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintDemo {
	public static void main(String[] args) throws IOException {


		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 34, 4));


		list.remove(2);
		System.out.println(list.toString());
	}
}
