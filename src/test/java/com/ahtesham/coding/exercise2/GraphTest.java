package com.ahtesham.coding.exercise2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class GraphTest {

    Graph testGraph = null;

    @Before public void setUp(){
        testGraph =  Graph.populateGraph();
    }

   @Test
   public void testGraphSize(){

       assertEquals(10, getNodeCount(testGraph));
   }

   @Test
   public void testIsCyclic(){
       assertTrue(hasCyclces(testGraph));
   }

    @Test
    public void testNodesHaveAtleast3Children(){

       assertTrue(has3Children(testGraph));
    }


   private int getNodeCount(Graph graph){
       Node current = graph.root;
       Deque<Node> stack = new ArrayDeque<>();
       List<Node> visited = new LinkedList<>();
       stack.add(current);
       while(!stack.isEmpty()){
           current = stack.pop();
           if(! visited.contains(current)) {
               visited.add(current);
               current.children().stream().forEach(x -> {
                   stack.push(x);
               });
           }
       }
       return visited.size();
   }

    private boolean hasCyclces(Graph graph){
        Node current = graph.root;
        Deque<Node> stack = new ArrayDeque<>();
        List<Node> visited = new LinkedList<>();
        stack.add(current);
        while(!stack.isEmpty()){
            current = stack.pop();
            if(! visited.contains(current)) {
                visited.add(current);
                current.children().stream().forEach(x -> {
                    stack.push(x);
                });
            }else{
                return true;
            }
        }
        return false;
    }

    private boolean has3Children(Graph graph){
        Node current = graph.root;
        Deque<Node> stack = new ArrayDeque<>();
        List<Node> visited = new LinkedList<>();
        stack.add(current);
        while(!stack.isEmpty()){
            current = stack.pop();
            if(! visited.contains(current)) {
                visited.add(current);
                if(current.children().size() < 3){
                    return false;
                }
                current.children().stream().forEach(x -> {
                    stack.push(x);
                });

            }
        }
        return true;
    }

}
