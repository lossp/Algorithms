package stack.LeftRotationString;


import java.util.Scanner;
import java.util.Stack;


/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 */
public class Solution {

    public boolean outOfLength(String baseString, int number) {
        return number > baseString.length();
    }

    public String reverseLeftWords(String baseString, int number) {
        if (baseString.length() == 1 || number == 0) return baseString;

        Stack<String> firstOne = new Stack<>();
        // put the remaining characters into the first stack
        for (int i = number; i < baseString.length(); i++) {
            firstOne.push(String.valueOf(baseString.charAt(i)));
        }
        // put the specific characters into the first stack
        for (int i = 0; i < number; i++) {
            firstOne.push(String.valueOf(baseString.charAt(i)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < firstOne.size(); i++) {
            stringBuilder.append(firstOne.get(i));
        }
        return stringBuilder.toString();

    }
    public static void main(String[] args) {
        System.out.println("Please enter the base String");
        Scanner in = new Scanner(System.in);
        String baseString = in.nextLine();
        System.out.println("Please enter the number");
        int number = in.nextInt();

        Solution solution = new Solution();


        if (solution.outOfLength(baseString, number)) throw new IllegalArgumentException("out of string index");
        String result = solution.reverseLeftWords(baseString, number);
        System.out.println(result);
    }
}
