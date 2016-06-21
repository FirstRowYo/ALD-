package com.campus02.ald.routefinder;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.DMUL;

public class Demo {

	public static void main(String[] args) {
		
		GraphLoader gl = new GraphLoader();

		Tiefensuche t = new Tiefensuche(2, 5, gl);
		String weg = t.findByTiefenSucheRekursiv();
		
		System.out.println(weg);
		System.out.println();
		
		//Weg von hinten durchgehen. 5 �ber 0 - 0 �ber 2 - fertig.
		Breitensuche b = new Breitensuche(2, 5, gl);
		b.findByBreitenSuche();
//___________________________________VERSUCH______________________________________
		System.out.println();
		ArrayList<Integer>list=b.getList();

			System.out.println(list);
			
	}	

}
