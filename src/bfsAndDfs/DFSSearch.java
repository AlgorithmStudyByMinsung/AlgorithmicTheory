package bfsAndDfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DFSSearch {
    public List<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        List<String> visited =new ArrayList<>();
        List<String> needVisited =new ArrayList<>();

        needVisited.add(startNode);

        while (needVisited.size()>0){
            String remove = needVisited.remove(needVisited.size() - 1);

            if (!visited.contains(remove)) {
                visited.add(remove);
                needVisited.addAll(graph.get(remove));
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

        DFSSearch dObject = new DFSSearch();
        List<String> a = dObject.dfsFunc(graph, "A");

        System.out.println("a = " + a);


    }
}
