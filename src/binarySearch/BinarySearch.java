package binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    // 변수는 n 을 받아야한다.
    // 가운데 값을 뽑아서 비교
    // 크면 오른 쪽 작으면 왼쪽
    // 재귀로 하고 size 가 1이며 종료
    // 같으면 종료

    public boolean searchFunc (int n, List<Integer> dataList) {
        if (dataList.size()==1) return dataList.get(0) == n;
        /**
         * 0일 수 도 있다.
         * */
        if (dataList.size()==0) return false; // 이건 처음에 들어오는 list 의 size 가 0인경우를 표시하는 것
        /**
         * size 는 그냥 나누기 2만 하는 것이 좋음 --> 왜냐면 sublist 는 마지막을 포함을 안함
         * */
        Integer mid = dataList.get(dataList.size() / 2);

        if (mid > n){
            /**
             * 재귀함수가 void 아니라면 일단 왠만하면 return 을 붙여줘야 의미가 있음
             * 왜냐 !! 분기가 있는 경우 ex) if/else 구문은 무조건 저기서 1개만 실행이 된다.
             * 1개의 씩 쭉 타고 진행이 되는 거기 때문에
             * !!!!!   마지막 return 값이 최종 return 값이 된다. !!!!
             *
             *  cf. 분기가 없이 재귀가 2개 이상있으면 다른 값들이 다 return 되겠군
             **/
            return searchFunc(n, dataList.subList(0, dataList.size() / 2));
        } else if (mid < n) {
            return searchFunc(n, dataList.subList(dataList.size() / 2, dataList.size()));
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        Collections.sort(testData);
        System.out.println(testData);

        BinarySearch bSearch = new BinarySearch();
        boolean b = bSearch.searchFunc(2, testData);

        System.out.println("b = " + b);
    }

}


