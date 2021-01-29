package fuxi.number;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/1321:35
 */
public class CastType {
	public static void main(String[] args) {
		//范围为[-128,127] 即256
		byte a = 1;

		short b = 18;
		short c = 128;
		short d = 200;
		short e = 257;

		a = (byte) b;
		System.out.println("a = " + a);

		a = (byte) c;
		System.out.println("a = " + a);

		a = (byte) d;
		System.out.println("a = " + a);

		a = (byte) e;
		System.out.println("a = " + a);

		short g = 0;
		char x = 0;
		x = (char) g;
		g = (short) x;




	}
}
