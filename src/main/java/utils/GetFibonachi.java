package utils;

import java.time.LocalDate;

public class GetFibonachi {
    public static int getNumber() {
        int firstNum = 0;
        int lastNum = 1;
        int getDay = LocalDate.now().getDayOfMonth();
        for (int i = 2; i < getDay + 1; i++) {
            int numToRemember = lastNum;
            lastNum = firstNum + numToRemember;
            firstNum = numToRemember;
        }
        return lastNum;
    }
}
