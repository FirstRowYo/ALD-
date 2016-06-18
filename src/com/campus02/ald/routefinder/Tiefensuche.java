package com.campus02.ald.routefinder;

import java.util.ArrayList;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Tiefensuche {
	
	private int start;
	private int ziel;
	private GraphLoader gl;
	private ListGraph graph;
	private ArrayList<WeightedEdge>edgelist;
	private ArrayList<Integer>visetedNode=new ArrayList<>();;
	
	
	
	//private ListGraph lg=new ListGraph(numVertices, directed)
	
	public Tiefensuche(int start, int ziel, GraphLoader gl) {
		super();
		this.start = start;
		this.ziel = ziel;
		this.gl=gl;
		this.graph=gl.getGraph();
		
	}
	
	public ArrayList<Integer>search()
	{
		edgelist=(ArrayList<WeightedEdge>) graph.getEdges(start);
		for (WeightedEdge weightedEdge : edgelist) 
		{
			search(weightedEdge.vertex);
		}
		return null;	
	}
	
	public ArrayList<Integer>search(int current)
	{
		if(current==ziel)
		{
			return visetedNode;
		}
		visetedNode.add(current);
		search(current+1);
	}
	
	

}
