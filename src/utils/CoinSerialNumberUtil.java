package utils;

import java.util.Arrays;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/15 16:31
 **/

public class CoinSerialNumberUtil {
    public static String createCoinSerialNumber(Integer billId) {
        String billNum = String.valueOf(billId);
        StringBuilder sb = new StringBuilder();
        char[] billNums = billNum.toCharArray();
        System.out.println(Arrays.toString(billNums));
        for (char num : billNums) {
            switch (num) {
                case CoinSerialConstant.ZERO_ASCII :
                    sb.append("A");
                    break;
                case CoinSerialConstant.ONE_ASCII :
                    sb.append("B");
                    break;
                case CoinSerialConstant.TWO_ASCII :
                    sb.append("C");
                    break;
                case CoinSerialConstant.THREE_ASCII :
                    sb.append("D");
                    break;
                case CoinSerialConstant.FOUR_ASCII :
                    sb.append("E");
                    break;
                case CoinSerialConstant.FIVE_ASCII :
                    sb.append("F");
                    break;
                case CoinSerialConstant.SIX_ASCII :
                    sb.append("G");
                    break;
                case CoinSerialConstant.SEVEN_ASCII :
                    sb.append("H");
                    break;
                case CoinSerialConstant.EIGHT_ASCII :
                    sb.append("I");
                    break;
                case CoinSerialConstant.NINE_ASCII :
                    sb.append("J");
                    break;
                default:
                    sb.append("K");
            }
        }
        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        createCoinSerialNumber(799910407);
//        int i = 0;
//        while (true) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("1111");
//        }
    }
}
