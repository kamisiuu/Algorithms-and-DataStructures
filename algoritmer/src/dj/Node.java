package dj;





public class Node implements Comparable<Node>{
	
	 public  int name;

	public Edge[] edges;
	public int d = Integer.MAX_VALUE;
	public int pos;
	public Node previous;
	
	public Node (int Aname){
		name=Aname;
	
		}


	public int compareTo(Node other)
    {
        return Integer.compare(d, other.d);
    }
	

	
	
	
}