package com.campus02.ald.routefinder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Breitensuche {
	
	private int start;
	private int ziel;
	private ListGraph graph; //war mal nur "g"
	private GraphLoader gl = new GraphLoader();
	
//______________________________________________VERSUCH________________________________
								private ArrayList<Integer>list=new ArrayList<>();
								
							
								public int getStart() {
									return start;
								}
							
								public int getZiel() {
									return ziel;
								}
							
								public ArrayList<Integer> getList() {
									return list;
								}
								
								public Breitensuche() {
									
								}
								
//_________________________________________________VERSUCH________________________________
	

	public Breitensuche(int start, int ziel, GraphLoader gl) {
		super();
		this.start = start;
		this.ziel = ziel;
		this.graph = gl.getGraph();
	}

	public void findByBreitenSuche()
	{
		ArrayDeque<Integer> nodes = new ArrayDeque<Integer>();
		
		boolean[] visited = new boolean[graph.numVertices()];
		int[] pred = new int[graph.numVertices()];
		boolean found = false;
		
		for(int i=0; i<pred.length; i++)
		{
			pred[i] = -1; 
		}
		
		nodes.add(start);
		
		outer: while(!nodes.isEmpty())
		{
			int current = nodes.poll();
			visited[current] = true;
		
			List<WeightedEdge> nachbarn = graph.getEdges(current);
			for(WeightedEdge nachbar: nachbarn)
			{
				if (!visited[nachbar.vertex])
				{
					nodes.add(nachbar.vertex);
					pred[nachbar.vertex] = current;
					
					if (nachbar.vertex == ziel)
					{
						found = true;
						break outer;
					}
				}
			}
		}
		if (found)
		{
			
			
			//Ausgabe überarbeiten! Von hinten durchgehen (höhö) um kürzesten weg zu finden
			for(int i=0; i<pred.length; i++)
			{
				System.out.println(i + " über " + pred[i]);
//______________________________________VERSUCH________________________________
				list.add(i);
				list.add(pred[i]);
//______________________________________VERSUCH________________________________
			}
		}
		else
		{
			System.out.println("Keine Verbindung gefunden");
		}

	}
	
}
