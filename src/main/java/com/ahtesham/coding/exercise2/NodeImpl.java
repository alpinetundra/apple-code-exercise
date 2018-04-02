package com.ahtesham.coding.exercise2;

import java.util.HashSet;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeImpl)) return false;
        NodeImpl node = (NodeImpl) o;
        return Objects.equals(nodeName, node.nodeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeName);
    }
}
