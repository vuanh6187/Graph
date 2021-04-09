package Graph3;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Graph3 {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Graphxyz");
        graph.setAttribute("ui.stylesheet", "graph {\n" +
                "\tfill-color: white;\n" +
                "}\n" +
                "\n" +
                "node {\n" +
                "\tsize: 25px;\n" +
                "\tshape: circle;\n" +
                "\tfill-color: white;\n" +
                "\tstroke-mode: plain;\n" +
                "\tstroke-color: black;\n" +
                "}\n" +
                "edge {\n" +
                "\tfill-color: black;\n" +
                "\tshape: line;\n" +
                "}\n" );
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        Integer x1,x2;
        String s1,s2,s;
        boolean ch1,ch2;
        int u,z;
        DFS g = new DFS(100);
        while (true) {
            s1 = sc.next();
            if (s1.equals("Draw")){
                for (Node node : graph) {
                    node.setAttribute("ui.label", node.getId());
                }
                System.out.print("Start & End: ");
                u = sc.nextInt();
                z = sc.nextInt();
                System.out.println("All paths: ");
                g.printAllPaths(u, z);
                graph.display();
                break;
            }
            else {
                ch1 = true;
                ch2 = true;
                s2 =sc.next();
                for (String t : list) {
                    if (t.equals(s1)) ch1 = false;
                    if (t.equals(s2)) ch2 = false;
                }
                if (ch1 == true){
                    graph.addNode(s1);
                    list.add(s1);
                }
                if (ch2 == true){
                    graph.addNode(s2);
                    list.add(s2);
                }
                x1 = Integer.parseInt(s1);
                x2 = Integer.parseInt(s2);
                g.addEd(x1,x2);
                s = s1 + s2;
                graph.addEdge(s,s1,s2,true);
            }
        }
    }
}