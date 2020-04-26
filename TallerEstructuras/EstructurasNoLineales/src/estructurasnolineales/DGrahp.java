/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author samaniw
 */
public class DGrahp {
    private HashMap<String,LinkedList<Node>> aList;

    public DGrahp() {
        aList= new HashMap<>();
    }
    
    public void addNode(String data){
        aList.putIfAbsent(data, new LinkedList<Node>());
    }
    
    private LinkedList<Node> getDataList(String key){
        return aList.get(key);
    }
    
    public void showAList(){
        for (String node:aList.keySet()) {
            System.out.println(node+": "+ getDataList(node));
        }
    }
    
    public void addEdge(String source,String destination, int weight){
        aList.get(source).add(new Node(destination,weight));
    }
    
    
}
