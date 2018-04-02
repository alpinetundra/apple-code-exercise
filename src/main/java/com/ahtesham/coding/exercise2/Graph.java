package com.ahtesham.coding.exercise2;

import java.util.*;

public class Graph {
    Node root;
    public Graph(){

    }
    
    //Exercise 1.1
    public Map<Node, List<Node>> findConnections(Node node, int depth){
        Map<Node, List<Node>> connections = initConnectionMap(node);
        connections.entrySet().forEach((e)-> {
            e.getValue().addAll(getLevelNodesUptoDepth(e.getKey(), depth));
        });
        return connections;
    }
    private ArrayList<Node> getLevelNodesUptoDepth(Node node,int depth){
        ArrayList<Node> result = new ArrayList<Node>();
        LinkedList<Node> current =  new LinkedList<Node>();
        if(node != null){
            current.add(findNode(node.name()));
        }
        while(depth > 0){
            result.addAll(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<Node>();
            for(Node nod: parents){
                current.addAll(nod.children());
            }
            depth--;
        }
        return result;
    }

    public int connected(Node node1, Node node2){
        int distance = 0;
        Node current = findNode(node1.name());
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> visited = new ArrayList<>();
        queue.add(current);
        while(!queue.isEmpty()){
            current = queue.remove();
            if(! visited.contains(current)) {
                distance++;
                visited.add(current);
                if(current.children().contains(node2)){
                    return distance;
                }

                current.children().stream().forEach(x -> {
                    queue.add(x);
                });
            }
        }


        return -1;
    }


    private Map<Node, List<Node>> initConnectionMap(Node node){
        Map<Node, List<Node>> connections = new HashMap<>();
        Node current = node;
        Queue<Node> queue = new LinkedList<>();
        List<Node> visited = new ArrayList<>();
        queue.add(current);
        while(!queue.isEmpty()){
            current = queue.remove();
            if(! visited.contains(current)) {
                visited.add(current);
                current.children().stream().forEach(x -> {
                    queue.add(x);

                });
                connections.put(current, new ArrayList<Node>());
            }
        }
        return connections;
    }

    public Node findNode(String id){
        if(root == null){
            return null;
        }
        Node current = root;
        Deque<Node> stack = new ArrayDeque<>();
        List<Node> visited = new LinkedList<>();
        stack.add(current);
        while(!stack.isEmpty()){
            current = stack.pop();
            if(! visited.contains(current)) {
                visited.add(current);
                if (current.name().equals(id)) {
                    return current;
                }
                current.children().stream().forEach(x -> {
                    stack.push(x);
                   // System.out.print(x + ", ");
                });
            }
        }
        return null;
    }

    public void addNode(String n, String toN){

        Node newNode = findNode(n);
        if(newNode == null ){
            newNode = new  NodeImpl(n);
        }
        Node toNode = findNode(toN);
        if(toNode == null) {
            toNode = new NodeImpl(toN);
        }
        toNode.children().add(newNode);
        if(this.root == null){
            root = toNode;
        }
    }

    public static Graph populateGraphEasy(){
        Graph graph = new Graph();
        graph.addNode("B","A");
        graph.addNode("C","B");
        graph.addNode("D","C");
        graph.addNode("E","D");
        graph.addNode("F","E");
        graph.addNode("G","F");
        graph.addNode("H","G");
        graph.addNode("I","H");
        graph.addNode("J","I");
        graph.addNode("A","J");

        graph.addNode("F","A");
        graph.addNode("J","A");

        graph.addNode("G","B");
        graph.addNode("A","B");

        graph.addNode("B","C");
        graph.addNode("H","C");

        graph.addNode("C","D");
        graph.addNode("I","D");

        graph.addNode("D","E");
        graph.addNode("J","E");

        graph.addNode("E","F");
        graph.addNode("A","F");

        graph.addNode("F","G");
        graph.addNode("B","G");

        graph.addNode("G","H");
        graph.addNode("C","H");

        graph.addNode("H","I");
        graph.addNode("D","I");

        graph.addNode("I","J");
        graph.addNode("E","J");


        return graph;
    }
}
