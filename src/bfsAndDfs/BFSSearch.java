package bfsAndDfs;

import java.util.*;
import java.util.stream.Collectors;

public class BFSSearch {
    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode){
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        // 노드를 집어넣고 visit 에 집어놓고
        // 노드의 자식들을 need 에 집어넣고
        // need 의 처음을 가져오고

        // 방문 안했으면 visit 에 넣고

        needVisit.add(startNode);

        while (needVisit.size() >0){
            String need = needVisit.remove(0);

            if (!visited.contains(need)) {
                visited.add(need);

                needVisit.addAll(graph.get(need));
            }

        }
        return visited;

    }
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        BFSSearch bObject = new BFSSearch();
        ArrayList<String> a = bObject.bfsFunc(graph, "A");

        System.out.println("a = " + a);

    }
}
