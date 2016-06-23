package com.campus02.ald.routefinder;

import java.util.ArrayList;
import java.util.List;

import org.campus02.chat.VertexHeap;

import com.campus02.ald.datastructures.Graph;
import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Dijkstra {

	//orientierung an Aufbau Tiefensuche
	private int start;
	private int ziel;
	private ListGraph graph; 
	private GraphLoader gl = new GraphLoader();
	
	public Dijkstra(int start, int ziel, GraphLoader gl) {
		super();
		this.start = start;
		this.ziel = ziel;
		this.graph = gl.getGraph();
	}
	
	public String dijkstra(){
		
		int[] pred = new int[graph.numVertices()];
		int[] dist = new int[graph.numVertices()];
		boolean[] visited = new boolean[graph.numVertices()];
		
		VertexHeap heap = new VertexHeap(graph.numVertices()); //eigen Heapklasse für Prioritätsvergabe nach Gewichtung
		for(int i=0; i<dist.length; i++){
			dist[i] = 99999;
			heap.insert(new WeightedEdge(i, 999999));
			pred[i] = 1;
		}
		
		dist[start] = 0;
        heap.setPriority(start, 0);
        
        while(!heap.isEmpty()) {
            
            WeightedEdge cur = heap.remove();
            
            if (cur.vertex == ziel) break;
            
            List<WeightedEdge> nachbarn = graph.getEdges(cur.vertex);
            
            for(WeightedEdge nachbar: nachbarn) {
                
                
                int distBisHier = dist[cur.vertex]; //Alt: cur.weight
                int distZumNachbar = nachbar.weight;
                
                int distInsg = distBisHier + distZumNachbar;
                
                if (distInsg < dist[nachbar.vertex] ) {
                    
                    dist[nachbar.vertex] = distInsg;
                    heap.setPriority(nachbar.vertex, distInsg);
                    
                    pred[nachbar.vertex] = cur.vertex;
                }
            }
        }
		
        
        //Ausgabe gehört noch geprüft - besonders "predToWay"
        /*
        // pred ausgeben
        for(int i=0; i<pred.length; i++) {
            System.out.println(i + " über " + pred[i]);
        }
        
        
        // Way ausgeben
        System.out.println();
        ArrayList<Integer> way = predToWay(pred,start, ziel);
        for(int vertexNumber: way) {
            System.out.print(vertexNumber + " ");
        }
        System.out.println();
        
    }*/
		return null; 
		
	}
	
}


