package org.hanlin;

import java.util.HashMap;

/**构造图所需要的数据顶点和边的数组，是buildGraph（）方法参数的组合类*/
public class ArrayDataOfGraph {
    HashMap<String,Object> vexMap = new HashMap<>();
    String[][] edges;


    public ArrayDataOfGraph(int edgeLen) {
        this.edges = new String[edgeLen][2];
    }

    public HashMap<String, Object> getVexMap() {
        return vexMap;
    }

    public void setVexMap(HashMap<String, Object> vexMap) {
        this.vexMap = vexMap;
    }

    public String[][] getEdges() {
        return edges;
    }

    public void setEdges(String[][] edges) {
        this.edges = edges;
    }
}
