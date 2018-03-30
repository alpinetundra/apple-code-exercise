package com.ahtesham.coding.exercise2;

public class Solution {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("B", "A");

        System.out.println(graph.root);
        graph.root.children().stream().forEach(x -> System.out.println(x  +" "));
    }
}
