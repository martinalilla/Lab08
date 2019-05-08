package it.polito.tdp.dizionariograph.model;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Graph<String, DefaultEdge> g;
	List <String> parole=new ArrayList <String>();
	WordDAO d;

	public void createGraph(int numeroLettere) {
		this.g= new SimpleGraph<>(DefaultEdge.class);
		d=new WordDAO();
		parole.addAll(d.getAllWordsFixedLength(numeroLettere));
		Graphs.addAllVertices(g, parole);
		for(String s1:parole) {
			for(String s2:parole) {
				if(controllaParola(s1,s2)==true && !s1.equals(s2)) {
					g.addEdge(s1,s2);
				}
			}
		}
		

		System.err.println("createGraph -- TODO");
	}

	public Graph<String, DefaultEdge> getG() {
		return g;
	}

	public void setG(Graph<String, DefaultEdge> g) {
		this.g = g;
	}

	public List<String> displayNeighbours(String parolaInserita) {
		return Graphs.neighborListOf(g, parolaInserita);

		//System.err.println("displayNeighbours -- TODO");
		//return new ArrayList<String>();
	}

	public int findMaxDegree() {
		int max=0;
		for(String s: parole) {
		if( g.degreeOf(s)>max) {
			max=g.degreeOf(s);
			
		}
		}
		return max;
	}
	
	public boolean controllaParola(String word1, String word2) {
		boolean b=true;
		int cont=0;
		char parola1[]=word1.toCharArray();
		char parola2[]=word2.toCharArray();
		for(int i=0; i<parola1.length; i++) {
			if(parola1[i]!=parola2[i]) {
				cont++;
				if(cont>=2) {
					b=false;
					break;
				}
			}
		}
		return b;
	}
	public List <String> vertici(){
		List<String> words=new ArrayList<String>();
		for(String s:parole) {
			if(g.degreeOf(s)==findMaxDegree()) {
				words.add(s);
			}
		}
		return words;
	}
}
