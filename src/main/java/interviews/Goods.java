package interviews;

import java.util.Arrays;

/** @Description :最多商品种类问题 @Author: niaonao */
public class Goods{

  /*public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Scanner cin = new Scanner(System.in);

    int limitMoney = sc.nextInt();

    String numsStr[] = cin.nextLine().split("\\s");

    int goodsPrice[] = new int[numsStr.length];
    for (int i = 0; i < goodsPrice.length; i++) {
      goodsPrice[i] = Integer.parseInt(numsStr[i]);
    }
    int monry = mostGoodsWithinLimit(limitMoney, goodsPrice);

    System.out.println(monry);
  }*/

  private static int mostGoodsWithinLimit(int limitMoney, int[] goodsPrice) {
    int allPrice = 0;
    Arrays.sort(goodsPrice);

    for (int i = 0; i < goodsPrice.length; i++) {
      int price = goodsPrice[i];
      allPrice = allPrice + price;
      if (allPrice > limitMoney) {
        allPrice -= price;
      }
    }

    return allPrice;

  }

	public static void main(String[] args) {

	}
}
