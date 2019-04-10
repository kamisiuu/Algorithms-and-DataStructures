package dj;


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.PriorityQueue;



public class dijikstra {
	 
	public static void main(String []args) throws Exception{
		long StartTimeOfMakingGraf=System.nanoTime();
		
		Node a= new Node(1);
		Node b= new Node(2);
		Node c= new Node(3);
		Node d= new Node(4);
		
		  int [] aa= new int [100];
			
			 
			  PQueue.insert(aa,c.name, 2);
			  PQueue.insert(aa,d.name, 3);
			  PQueue.insert(aa,a.name, 0);
			  PQueue.insert(aa,b.name, 1);

	      System.out.println("max: " + PQueue.extractMax(aa, 4));
	      System.out.println("max: " + PQueue.extractMax(aa, 3));
	      System.out.println("max: " + PQueue.extractMax(aa, 2));
	      System.out.println("max: " + PQueue.extractMax(aa, 1));		
		
		// hvis du skal legge til flere noder må du definere siste noden i Node[] Sistenode = {navnet på siste noden} 
		a.edges= new Edge[]{new Edge(b,1),
							new Edge(c,4)};
		b.edges= new Edge[]{new Edge(a,1),
							new Edge(c,1)};
		c.edges= new Edge[]{new Edge(a,4),
							new Edge(b,1),
							new Edge(d,1)
							};
		d.edges=new Edge[]{new Edge(c,1)
		};
		
		long EndTimeOfMakingGraf=System.nanoTime();
		
		long StartTimeOfComputingWay=System.nanoTime();
		//her må man definere siste noden 
		Node[] Lastnode = {d};
        // ComputeWayFrom er hvor man skal starte beregningen fra
		ComputeWayFrom(a);
		 long EndTimeOfComputingWay=System.nanoTime();
        for (Node v : Lastnode)
	{
	    System.out.println("Korteste veien til " + v.name + ": " + v.d);
	    List<Node> path = getShortestPathTo(v);
	   
	    System.out.println("Gjennom nodene: " + path.toArray());
	    System.out.println("det tok "+(EndTimeOfMakingGraf-StartTimeOfMakingGraf)/100000.0 +" ms "+ "å lage grafen");
	    System.out.println("det tok "+(EndTimeOfComputingWay-StartTimeOfComputingWay)/100000.0 +" ms "+ "å finne veien");
	}
	} // init-single source
		public static void ComputeWayFrom(Node source)
	    {
	        source.d = 0;
//	      LinkedList<Node> NodeQueue= new LinkedList<Node>();
//	        
//	      	NodeQueue.add(source);
	      	PriorityQueue<Node> NodeQueue=new PriorityQueue<Node>();
	      	NodeQueue.add(source);
	      	while (!NodeQueue.isEmpty()) {
	    	    Node u = NodeQueue.poll();
	    	    
	                
	                for (Edge e : u.edges)
	                {
	                    Node v = e.target;
	                    int weight = e.weight;
	                    int TotalWeightOrLength = u.d + weight;
	                    // jeg droppet relax metoden og har direkte implementert den her (en del av logikken fra den er over denne linjen også)
	    		if (TotalWeightOrLength < v.d) {
	    		    NodeQueue.remove(v);
	    		    v.d = TotalWeightOrLength ;
	    		    v.previous = u;
	    		    NodeQueue.add(v);
	    		}
	                }
	            }
	        
	
	
	
}
		 public static List<Node> getShortestPathTo(Node target)
		    {
		        List<Node> path = new ArrayList<Node>();
		        for (Node vertex = target; vertex != null; vertex = vertex.previous)
		            path.add(vertex);
		        Collections.reverse(path);
		        return path;
		    }
		 
		}