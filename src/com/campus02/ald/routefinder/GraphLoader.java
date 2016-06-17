package com.campus02.ald.routefinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class GraphLoader {
	
	private File file;
	private ArrayList<String> list = new ArrayList<>();
	
	public GraphLoader(String path) {
		super();
		File file = new File(path);
	}
	
	public void loadGraph() {
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
			ListGraph graph = new ListGraph(getGraphSize(), false); //getGraphSize gibt die Anzhal der Knoten an
			String line;
			while((line=br.readLine()) != null) {
				String[] array = line.split(";");
				//zugreifen auf baum
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getGraphSize() {
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
				String line;
				while((line=br.readLine()) != null) {
					String[] array = line.split(";");
					if(list.contains(array[0])==false) {
						list.add(array[0]);
					}
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list.size();
	}

}
