package search;

import java.util.*;

public class DijkstraPath {

    static class Edge implements Comparable<Edge>{
        String vertex;
        int distance;

        public Edge(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex='" + vertex + '\'' +
                    ", distance=" + distance +
                    '}';
        }
        @Override
        public int compareTo(Edge o) {
            return distance - o.distance;
        }
    }

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, List<Edge>> graph, String start) {
        /**
         *  distance 의 역할: 현재 해당 node 기준 시작점에서 그 해당 node 로 갈 수 있는 최단 경로
         **/
        HashMap<String, Integer> distance = new HashMap<>();// 최적 경로
        graph.keySet().stream().forEach(key ->{
            distance.put(key, Integer.MAX_VALUE);
        });
        /**
         * 최단 경로는 아니고
         * 현재 해당 node 기준 시작점에서 그 해당 node 로 갈 수 있는 경로
         * */
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();// 현재 경로
        priorityQueue.add(new Edge(start, 0));

        while (priorityQueue.size() >0){

            Edge poll = priorityQueue.poll();
            /**
             * !! 이 한줄 때문에 엄청고생 !!
             *
             * 그 때의 거리를 비교해서 더 크다면 수정을 해서는 안됨
             **/
            if (poll.distance > distance.get(poll.vertex)) continue;

            // 더 최적 경로라면 변경을 수행
            distance.put(poll.vertex, poll.distance);

            //자식들을 우선 순위 큐에다가 집어넣기
            graph.get(poll.vertex).stream().forEach(edge -> {
                priorityQueue.add(new Edge(edge.vertex, poll.distance + edge.distance));
            });

            update(distance, priorityQueue);
        }
        return distance;
    }

    public void update(HashMap<String, Integer> distance, PriorityQueue<Edge> priorityQueue) {
        // 현재 경로와 최적 경로를 비교해서 더 작다면 update
        /**
         * 원리
         * !! 현재 경로를 탐색해서 더 작은 것이 있다면 교체 !!
         * --> 이 원리기에 poll 한 것도 비교해서 넣는다.
         * */
        priorityQueue.stream().forEach(edge -> {
            if (distance.get(edge.vertex) > edge.distance ) distance.put(edge.vertex, edge.distance);
        });
    }

    public static void main(String[] args) {
        HashMap<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge("B",8), new Edge( "C", 1), new Edge( "D", 2))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge( "B", 5), new Edge( "D", 2))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge("E", 3), new Edge( "F", 5))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge( "F", 1))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge("A", 5))));

        DijkstraPath dijkstraPath = new DijkstraPath();

        HashMap<String, Integer> hashMap = dijkstraPath.dijkstraFunc(graph, "A");

        System.out.println("hashMap = " + hashMap);




    }
}
