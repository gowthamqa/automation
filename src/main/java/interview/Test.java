package interview;

import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		String[] array = {"53TPX" ,"53FT DRY VAN" ,"16STRAIGHT TRUCK" ,"26STRAIGHT TRUCK" ,"80STRETCH TRAILER" ,"80STRETCH TRAILER FLAT" ,"STRETCH TRAILER" ,"53FT ELECTRONIC VAN" ,"53BK" ,"48BK" ,"53DV" ,"48DV" ,"56PP" ,"28PP" ,"53FT CONESTOGA" ,"48FT DRY VAN" ,"CARGOVAN" ,"SPRINTERVAN" ,"68BX" ,"53DV" ,"53DV" ,"57VAN" ,"24STRAIGHT TRUCK" ,"35T" ,"40T" ,"48T" ,"40DV" ,"48DV" ,"53DV" ,"53DVS" ,"12DV" ,"20DV" ,"8DV" ,"12DV" ,"20DV" ,"40DV" ,"48DV" ,"53DVS" ,"8DV" ,"53XX"};
		System.out.println(array.length);		
		Set<String> s = new HashSet<String>();
		for (int i = 0; i < array.length; i++) {
			if(!s.contains(array[i])) {
				s.add(array[i]);
			}else {
				System.out.print(array[i]+"  ");
			}
			
		}

		System.out.println();
		System.out.println(s.size());
		for(String s1 : s) {
			System.out.print(s1+"|");
		}
		
	
	}

}
