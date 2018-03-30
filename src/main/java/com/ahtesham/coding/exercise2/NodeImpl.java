package com.ahtesham.coding.exercise2;

import java.util.HashSet;
import java.util.Set;

public class NodeImpl implements Node {
    private String nodeName;
    private Set<Node> neighbours = new HashSet<>();
    public String name(){
        return this.nodeName;
    }
    public void setName(String nodeName){
        this.nodeName = nodeName;
    }
    public Set<Node> children(){
        return this.neighbours;
    }

    public NodeImpl(String nodeName){
        this.nodeName = nodeName;
    }

    @Override
    public String toString() {
        return "nodeName = " + nodeName ;

    }
}
