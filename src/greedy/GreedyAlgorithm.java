package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithm {

    public int coinFunc(int price, List<Integer> coinList){

        int totalCnt=0;
        int totalPrice = price;

        for (Integer coin : coinList) {
            int cnt = totalPrice / coin;
            totalCnt+=cnt;

            totalPrice -= coin*cnt;
        }
        
        return totalCnt;
    }

    public void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, (num1, num2)->
                num2[1]/num2[0] - num1[1]/num1[0] );

        for (Integer[] integers : objectList) {
            if (capacity - (double) integers[0] > 0){
                capacity -= (double) integers[0];
                totalValue += (double) integers[1];
            } else {
                fraction = capacity / integers[0];

                totalValue += integers[1]*fraction;
                break;
            }
        }
        System.out.println("totalValue = " + totalValue);
    }

    public static void main(String[] args) {
        GreedyAlgorithm gObject = new GreedyAlgorithm();

        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30.0);
    }
}
