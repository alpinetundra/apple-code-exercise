package com.ahtesham.coding.exercise2;

public class Solution {
    public static void main(String[] args) {

        Graph graph = Graph.populateGraph();
        //graph.findConnections(graph.findNode("C"), 3);
        System.out.println("distance between A and C is > "+ graph.connected(graph.findNode("A"), graph.findNode("H")));
       System.out.println(graph.root);
       // graph.root.children().stream().forEach(x -> System.out.println(x  +" "));
    }
}
