package pathshala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(restoreIpAddresses(br.readLine().trim()));
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        if (s.length() < 4) {
            return ips;
        }
        int count = 3;
        char[] ip = new char[s.length() + count];
        generateIps(s, ips, ip, count, 0, 0);
        return ips;
    }

    public static void generateIps(String s, List<String> ips, char[] ip, int count, int currentIndex, int ipIndex) {
        if (count == 0) {
            if (s.length() - currentIndex > 3) {
                return;
            }
            for (int i = currentIndex; i < s.length(); i++) {
                ip[ipIndex++] = s.charAt(i);
            }
            if (isValidIp(ip)) {
                ips.add(String.valueOf(ip));
            }
            return;
        }
        for (int i = currentIndex; i < s.length() - count; i++) {
            ip[ipIndex++] = s.charAt(i);
            ip[ipIndex] = '.';
            generateIps(s, ips, ip, count - 1, i + 1, ipIndex + 1);
        }
    }

    public static boolean isValidIp (char[] ip) {
        boolean isValid = true;
        int numericValue = 0;
        int lastIndex = -1;
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] == '.' || i == ip.length - 1) {
                if (numericValue >= 0 && numericValue <= 255) {
                    // check for leading zeroes
                    int length = i - lastIndex - 1;
                    if (length > 1 && length < 3 && numericValue < 10) return false;
                    if (length > 2 && numericValue < 100) return false;
                    numericValue = 0;
                    lastIndex = i;
                } else {
                    return false;
                }
            } else {
                numericValue = numericValue * 10 + Character.getNumericValue(ip[i]);
            }
        }
        return isValid;
    }
}
