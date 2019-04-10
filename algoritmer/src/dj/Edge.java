package dj;

public class Edge {

	public final Node target;
	public final int weight;
	
	public Edge(Node target, int weight){
		
		this.target=target;
		this.weight=weight;
	}
}