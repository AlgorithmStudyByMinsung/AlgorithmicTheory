package recursive;

import java.util.ArrayList;
import java.util.Arrays;

public class Factorial {
    public int factorialFunc(int data) {
        if (data == 1) {
            return 1;
        } else if (data == 2) {
            return 2;
        } else if (data == 3) {
            return 4;
        }
        return this.factorialFunc(data - 1) + this.factorialFunc(data - 2) + this.factorialFunc(data - 3);
    }
    public class Dynamic {
        public int dynamicFunc(int data) {
            Integer[] cache = new Integer[data + 1];
            cache[0] = 0;
            cache[1] = 1;
            for (int index = 2; index < data + 1; index++) {
                cache[index] = cache[index - 1] + cache[index - 2];
            }
            return cache[data];
        }
    }
}