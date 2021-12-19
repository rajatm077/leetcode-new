package pathshala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedParantheses2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1;
        int M = 2;
        char[] str = new char[2 * (N + M)];
        print(str, N, M, 0, 0, 0, 0);
    }

    private static void print(char[] str, int N, int M, int nOpen, int nClose, int mOpen, int mClose) {
        int currentIndex = nOpen + nClose + mOpen + mClose;
        if (currentIndex == str.length && checkIfValid(str)) {
            System.out.println(str);
            return;
        }
        if (mOpen < M) {
            str[currentIndex] = '{';
            print(str, N, M, nOpen, nClose, mOpen + 1, mClose);
        }
        if (mClose < mOpen && str[currentIndex - 1] != '(') {
            str[currentIndex] = '}';
            print(str, N, M, nOpen, nClose, mOpen, mClose + 1);
        }
        if (nOpen < N) {
            str[currentIndex] = '(';
            print(str, N, M, nOpen + 1, nClose, mOpen, mClose);
        }
        if (nClose < nOpen && str[currentIndex - 1] != '{') {
            str[currentIndex] = ')';
            print(str, N, M, nOpen, nClose + 1, mOpen, mClose);
        }
    }

    private static boolean checkIfValid(char[] str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '{' || str[i] == '(') {
                stk.push(str[i]);
            } else {
                if (stk.isEmpty()) {
                    return false;
                }
                char top = stk.peek();
                if (top == '{' && str[i] != '}') {
                    return false;
                } else if (top == '(' && str[i] != ')') {
                    return false;
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}
