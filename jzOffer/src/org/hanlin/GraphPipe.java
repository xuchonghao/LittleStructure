package org.hanlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**该图使用邻接表来存储图中的信息
 * 其中只有buildGraph（）和printGraph（）方法，其他为这个服务*/
public class GraphPipe {
    private ArrayList<VexNode> vexArray = null;//顶点采用顺序表

    public void addVertex(int sequence,HashMap<String,Object> vexMap){
        //获得顶点Map中的第sequence个key，也就是结点的id
        Object dataId = vexMap.entrySet().toArray()[sequence];

        VexNode vex = new VexNode();
        vex.dataId = (String)dataId;
        vex.dataObject = vexMap.get(dataId);
        vex.firstEdge = null;
        vexArray.add(vex);
    }
    public VexNode getVexNode(String dataId){
        for(int i=0;i<vexArray.size();i++)
            if(dataId == vexArray.get(i).dataId)
                return vexArray.get(i);
        return null;
    }
    public void linkLast(EdgeNode target,EdgeNode node){
        while(target.nextEdge != null){
            target = target.nextEdge;
        }
        target.nextEdge = node;
    }
    public void addEdges(String[] edge){
        //根据元素的名字ID找到对应的vex  的序号
        int leftSequence = getVexNode(edge[0]).sequence;
        int rightSequence = getVexNode(edge[1]).sequence;
        /**第一步：添加边指向顶点的位置*/
        EdgeNode edgeNode = new EdgeNode();
        edgeNode.adjvex = rightSequence;
        /**第二步：添加指向下一条弧的引用
         * rule：依附于起始顶点的第一条边如果为空，就把这条边设为第一个，否则接入该顶点链表的最后一个*/
        if(vexArray.get(leftSequence).firstEdge == null)
            vexArray.get(leftSequence).firstEdge = edgeNode;
        else
            linkLast(vexArray.get(leftSequence).firstEdge,edgeNode);
    }
    public void buildGraph(HashMap<String,Object> vexMap,String[][] edges){
        /*vexMap 存储的包括它的id和真正的对象*/
        int vlen = vexMap.size();
        int elen = edges.length;
        /**第一步：添加结点*/
        for(int i=0;i<vlen;i++){
            //i表示每个顶点的sequence
            addVertex(i,vexMap);
        }
        /**第二步：添加边*/
        for(int i=0;i<elen;i++){
            //每个边由两个元素构成
            addEdges(edges[i]);
        }
    }

    public void printGraph(){
        for(int i=0;i<vexArray.size();i++){
            //第1步：输出第i结点的Id
            System.out.printf("%s--",vexArray.get(i).dataId);
            //第2步：输出 依附于该结点的 每一条弧 所指向的结点
            EdgeNode node = vexArray.get(i).firstEdge;
            while (node != null){
                System.out.printf("%s(%s)--",node.adjvex,vexArray.get(node.adjvex).dataId);
                node = node.nextEdge;
            }
            System.out.println();
        }
    }

    public GraphPipe() {
        this.vexArray = new ArrayList<>();
    }

    public ArrayList<VexNode> getVexArray() {
        return vexArray;
    }

    public void setVexArray(ArrayList<VexNode> vexArray) {
        this.vexArray = vexArray;
    }

    /**边表(邻接表）结点由临接点域（adjvex）和指向下一条邻接边的指针域nextEdge*/
    class EdgeNode{
        int adjvex;//该弧所指向的顶点的位置
        EdgeNode nextEdge;
    }
    /**顶点表结点由顶点域（data）和指向第一条邻接边的firstEdge指针构成*/
    class VexNode{
        String dataId;//假设顶点信息的类型是String
        int sequence;//顶点在图中对应的编号
        Object dataObject;
        EdgeNode firstEdge;//指向第一条依附于该顶点的弧的指针
    }

}
