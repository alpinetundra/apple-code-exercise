package com.ahtesham.coding.exercise2;

import java.util.*;

public class Graph {
    Node root;
    public Graph(){

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
                    System.out.print(x + ", ");
                });
            }
        }
        return null;
    }

    public void addNode(String n, String toN){
        Node newNode = new  NodeImpl(n);
        Node toNode = findNode(toN);
        if(toNode == null) {
            toNode = new NodeImpl(toN);
        }
        toNode.children().add(newNode);
        if(this.root == null){
            root = toNode;
        }
    }


}
