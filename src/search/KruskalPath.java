package search;

import java.util.*;

public class KruskalPath {
    static class Edge implements Comparable<Edge>{
        int weight;// 노드1 과 노드2의 가중치
        String nodeV;// 노드 1
        String nodeU;// 노드 2

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", nodeV='" + nodeV + '\'' +
                    ", nodeU='" + nodeU + '\'' +
                    '}';
        }
    }
    // union find 를 적용한다.
    // find 를 만들고 union 을 만든다.
    // 그리고 초기화 함수를 만든다.
    // 초기화를 시키고 부모가 다른 지 확인한다.

    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> rank = new HashMap<>();

    public String find(String node) {
        /**
         * 재귀의 특징을 잘 살린 메서드
         * - 재귀는 결국 스텍처럼 된다.
         * - 부모를 찾는 모든 애들은 기달렸다가
         * - root 노드로 세팅이 된다.
         * - 재귀에서 재귀함수가 하나만 있거나 if/else 면 return 값은 1개이다.
         **/
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (rank.get(root1) == rank.get(root2)) rank.put(root2, rank.get(root2)+1);
        }
    }

    public void makeSet(String node){
        /**
         * 이렇게 초기화를 해도 union 에서 알아서 바뀐다.
         **/
        parent.put(node, node);
        rank.put(node, 0);
    }

    public List<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        List<Edge> mst = new ArrayList<>();

        vertices.stream().forEach(node -> makeSet(node));

        Collections.sort(edges);

        for (Edge edge : edges) {
            if (find(edge.nodeU) != find(edge.nodeV)) {
                union(edge.nodeU, edge.nodeV);
                mst.add(edge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        KruskalPath kObject = new KruskalPath();
        List<Edge> edges1 = kObject.kruskalFunc(vertices, edges);

        System.out.println("edges1 = " + edges1);
    }
}
