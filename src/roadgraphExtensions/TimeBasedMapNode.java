package roadgraphExtensions;

import java.util.Comparator;
import geography.GeographicPoint;

public class TimeBasedMapNode implements Comparable<TimeBasedMapNode>, Comparator<TimeBasedMapNode>{
	//private double distance;
	private GeographicPoint location;
	// for A*
	private double heuristicVal;
	// For Extension
	private double duration;
	private double indivDur;
	
	public TimeBasedMapNode(GeographicPoint loc,double t){
		if(t<0 || loc==null)
			throw new IllegalArgumentException();
		duration = t;
		location = loc;
		heuristicVal = 0;
		indivDur = 0;
	}
	public TimeBasedMapNode(GeographicPoint loc){
		if(loc==null)
			throw new IllegalArgumentException();
		duration = Double.POSITIVE_INFINITY;
		location = loc;
		heuristicVal = 0;
		indivDur = 0;
	}
	public TimeBasedMapNode(GeographicPoint loc,double t,  double h){
		if(t<0 || h<0 || loc==null)
			throw new IllegalArgumentException();
		duration = t;
		location = loc;
		heuristicVal = h;
		indivDur = 0;
	}
	
	public void setDuration(double t){
		if(t<0)
			throw new IllegalArgumentException();
		duration = t;
	}
	public double getDuration(){
		return duration;
	}
	
	public GeographicPoint getLocation(){
		return location;
	}
	
	public String toString(){
		double t = duration+heuristicVal;
		return location.toString()+" "+duration+" "+heuristicVal+" sum= "+t;
	}
	public double getHeuristic(){
		return heuristicVal;
	}
	public void setHeuristic(double h){
		if(h<0)
			throw new IllegalArgumentException();
		heuristicVal = h;
	}
	
	@Override
	public int compare(TimeBasedMapNode o1, TimeBasedMapNode o2) {
		return o1.compareTo(o2);
	}

	@Override
	public int compareTo(TimeBasedMapNode o) {
		int comp = Double.compare(this.getDuration()+this.getHeuristic(), o.getDuration()+o.getHeuristic());
		return comp;
	}
	
	// needed for extension
	public void setIndivDur(double t){
		if(t<0)
			throw new IllegalArgumentException();
		this.indivDur = t;
	}
	public double getIndivDur(){
		return this.indivDur; 
	}
	
	
}

