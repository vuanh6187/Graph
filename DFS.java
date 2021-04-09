package Graph3;

import java.util.ArrayList;
import java.util.List;

import java.lang.*;


public class DFS {

    private int v;

    private ArrayList<Integer>[] adjList;

    public DFS(int vertices) {
        this.v = vertices;

        initAdjList();
    }

    private void initAdjList()
    {
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEd(int u, int v) {
        adjList[u].add(v);
    }

    public void printAllPaths(int s, int d) {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        pathList.add(s);
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList)
    {

        if (u.equals(d)) {
            System.out.println(localPathList);
            return;
        }

        isVisited[u] = true;

        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }

        isVisited[u] = false;
    }

}

