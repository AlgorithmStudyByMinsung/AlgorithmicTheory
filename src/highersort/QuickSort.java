package highersort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        //pivot 을 빼야한다.
        for (int index = 1; index < dataList.size(); index++) {
            if (dataList.get(index) > pivot) {
                rightArr.add(dataList.get(index));
            } else {
                leftArr.add(dataList.get(index));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(this.sort(leftArr));
        //pivot 을 합쳐야한다.
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.sort(rightArr));

        return mergedArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        QuickSort qSort = new QuickSort();
        ArrayList<Integer> sort = qSort.sort(testData);
        System.out.println("sort = " + sort);
    }
}
