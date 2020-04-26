/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw
 */
public class Node {
    private String node;
    private int weight;

    public Node(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    /**
     * @return the node
     */
    public String getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(String node) {
        this.node = node;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
