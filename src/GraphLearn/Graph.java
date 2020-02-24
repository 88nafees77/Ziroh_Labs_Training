/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphLearn;

import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nafees Abdullah
 */
public class Graph {

    List list[];
    int distance[];
    int color[];

    public Graph(int v) {
        list = new LinkedList[v];
        distance = new int[v];
        color = new int[v];
        for (int i = 0; i < v; i++) {
            list[i] = new LinkedList();
        }
    }

    public void createGraph(int source, int destination) {
        list[source].add(destination);
        list[destination].add(source);
    }

    public void Bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            Iterator iterator = list[tmp].listIterator();
            while (iterator.hasNext()) {
                Integer point = (Integer) iterator.next();
                if (color[point] == 0) {
                    color[point] = -1;
                    distance[point] = distance[point] + 1;
                }
                queue.add(point);
            }

        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.createGraph(0, 1);
        graph.createGraph(0, 2);
        graph.createGraph(0, 3);
        graph.Bfs(0);
        

    }

}
