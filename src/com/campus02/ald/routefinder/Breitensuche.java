package com.campus02.ald.routefinder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Breitensuche 
{
	
	private int start;
	private int ziel;
	private ListGraph graph; //war mal nur "g"
	private GraphLoader gl = new GraphLoader();
	
	public Breitensuche(int start, int ziel, GraphLoader gl) 
	{
		super();
		this.start = start;
		this.ziel = ziel;
		this.graph = gl.getGraph();
	}

	public String findByBreitenSuche()
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
			//Rekursions Methode unten aufrufen
			ArrayList<Integer> wayArray = findWay(pred, ziel, start, ziel);
			
			//Array mit IDs in Strings umwandeln und ausgeben
			String way = "";
			for (int i = wayArray.size()-1; i >= 0; i--) 
			{
				if(i == 0) 
				{
					way += gl.translateID(wayArray.get(i));
				}
				else {
					way += gl.translateID(wayArray.get(i)) + " -> ";
				}
			}
//			for(int i=0; i<pred.length; i++)
//			{
//				System.out.println(i + " über " + pred[i]);
//			}
			return way;
		}
		else
		{
			return "Keine Verbindung gefunden";
		}

	}
	//Gefundenen Weg in eine Array packen von Ziel zum Start
	private ArrayList<Integer> way = new ArrayList<>();
	private ArrayList<Integer> findWay(int[] pred,int current, int start, int ziel) 
	{
			if(current == ziel) 
			{
				way.add(ziel);
				findWay(pred, pred[current], start, ziel);
			}
			else if(current == start) 
			{
				way.add(start);
				return way;
			}
			else if(current != start) 
			{
				way.add(current);
				findWay(pred, pred[current], start, ziel);
			}
		return way;
	}
	
}
