package com.campus02.ald.routefinder;

import java.util.ArrayList;

import com.campus02.ald.datastructures.ListGraph;

public class Tiefensuche {
	
	private int start;
	private int ziel;
	private GraphLoader gl=new GraphLoader();
	//private ListGraph lg=new ListGraph(numVertices, directed)
	
	public Tiefensuche(int start, int ziel) {
		super();
		this.start = start;
		this.ziel = ziel;
	}
	
	public ArrayList<Integer>suche()
	{
		ArrayList<Integer>listID=new ArrayList<>();
		
		if(gl.loadGraph())
		
	}
	
	

}
