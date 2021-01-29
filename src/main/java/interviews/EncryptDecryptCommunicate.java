package interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description : 课堂交流加密解密问题
 * @Author: niaonao
 * @Date: 2018/11/18 23:20
 */
public class EncryptDecryptCommunicate{

    //加密规则
    private static String[] strsFirst = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    private static String[] strsSecond = {"J", "K", "L", "M", "N", "O", "P", "Q", "R"};
    private static String[] strsThird = {"S", "T", "U", "V", "W", "X", "Y", "Z", "*"};
    private static List<String[]> strsList = new ArrayList<String[]>() {
        {
            add(strsFirst);
            add(strsSecond);
            add(strsThird);
        }
    };

    public static void main(String[] args) {
        //根据输入的日期(月/日)
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();

        Scanner cin = new Scanner(System.in);
        //全大写
        String information = cin.nextLine();

        //经过加密得到加密后数据
        List<String> data = dataEncryption(month, day, information);
        //nums[] 35 25 18 12 29 31 25 23 12 28
        for (String nums : data) {
            System.out.print(nums + " ");
        }
    }


    private static List<String> dataEncryption(int month, int day, String information) {
        //整个分组左移
        int moveByMonth = month - 1;
        movebitList(moveByMonth);

        //每个分组内部左移
        int moveByDay = day - 1;
        movebit(strsList.get(0), moveByDay);
        movebit(strsList.get(1), moveByDay);
        movebit(strsList.get(2), moveByDay);

        //对信息的每个字符进行加密。
        //获取字符串每个字符，
        //比对当前字符在strsList的第几组的第几个位置，比如2，1即该字符加密为21

        //封装加密后数据
        List<String> data = new ArrayList<String>();

        //对数据加密
        for (int i = 0; i < information.length(); i++) {

            //在整组中位置
            //在分组中位置
            int listNum = 0;
            int arrayNum = 0;
            char character = information.charAt(i);
            //空格处理
            if (' ' == character)
                character = '*';

            //字符是否匹配到
            boolean alreadyFind = false;

            for (int j = 0; j < strsList.get(0).length; j++) {
                String charInList = strsList.get(0)[j];
                String charStr = character + "";
                if (charStr.equals(charInList)) {
                    listNum = 1;
                    arrayNum = j + 1;
                    alreadyFind = true;
                }
            }
            if (!alreadyFind) {
                for (int j = 0; j < strsList.get(1).length; j++) {
                    String charInList = strsList.get(1)[j];
                    String charStr = character + "";
                    if (charStr.equals(charInList)) {
                        listNum = 2;
                        arrayNum = j + 1;
                        alreadyFind = true;
                    }
                }
            }
            if (!alreadyFind) {
                for (int j = 0; j < strsList.get(2).length; j++) {
                    String charInList = strsList.get(2)[j];
                    String charStr = character + "";
                    if (charStr.equals(charInList)) {
                        listNum = 3;
                        arrayNum = j + 1;
                        alreadyFind = true;
                    }
                }
            }
            String position = listNum + "" + arrayNum;
            data.add(position);

        }

        return data;
    }


    private static void movebitList(int moveByMonth) {
        if (moveByMonth % 3 == 1) {
            //左移一位
            String[] strsTemp = strsList.get(0);
            strsList.set(0, strsList.get(1));
            strsList.set(1, strsList.get(2));
            strsList.set(2, strsTemp);
        } else if (moveByMonth % 3 == 2) {
            //左移两位
            String[] strsTemp = strsList.get(1);
            strsList.set(0, strsList.get(2));
            strsList.set(1, strsList.get(0));
            strsList.set(2, strsTemp);
        }
    }


    private static void movebit(String array[], int times) {
        while (times > 0) {
            times--;
            String temp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = temp;
        }
    }
}
