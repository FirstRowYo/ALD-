package com.campus02.ald.routefinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

@SuppressWarnings("unused")
public class GraphLoader {
	
	private File file;
	private ArrayList<String> list = new ArrayList<>();
	private BaseTree<Integer,String> ctree = new BaseTree<Integer,String>() {
		@Override
		protected int compareKey(Integer a, Integer b) {
			if (a<b)
				return -1;
			if (a>b)
				return 1;
			else 
				return 0;}
		@Override
		protected int compareValue(String a, String b) {
			return a.compareTo(b);}};
	private BaseTree<String, Integer> stree = new BaseTree<String, Integer>() {
		@Override
		protected int compareKey(String a, String b) {
			return a.compareTo(b);}
		@Override
		protected int compareValue(Integer a, Integer b) {
			if (a<b)
				return -1;
			if (a>b)
				return 1;
			else 
				return 0;}};
	
	public GraphLoader(String path) 
	{
		File file = new File(path);
		buildTree(file);
	}
	
	private void buildTree(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file));)
		{
		String line;
		Integer counter = 0;
		while ((line=br.readLine())!=null)
		{
			String[]array=line.split(";");
			String node = array[0];
			if (ctree.find(node) == null){counter++;}
			ctree.add(counter,node);
			stree.add(node, counter);
		}
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
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
				int idStart = ctree.find(array[0]).key; //Methode(array[0]); 
				int idZiel = ctree.find(array[1]).key; //Methode(array[1]);
				graph.addEdge(idStart, idZiel, Integer.parseInt(array[2]));
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
	
	public void printTrees()
	{
		ctree.printTree();
		stree.printTree();
	}

}
