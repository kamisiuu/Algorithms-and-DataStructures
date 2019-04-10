package Oblig1.Algdat.Kamil.Lipski;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;

// i denne klassen kan du simulere Flyplassen 
public class AirPort {
	
	public static LinkedList<Plane> planees= new LinkedList<Plane>();
	public static void main(String [] args){
		
		FillWithPlanes(planees, 500);
		Simuler(20, .6, .4);
	
	}
	

	public static void Simuler(int tidsenheter, double gjAnktprTid, double gjAvgprTid){
		
		System.out.println("Velkommen til Halden Airport, tax-free butikken er dessverre stengt.");
		System.out.println("\n");
		System.out.println("Hvor mange tidsenheter skal simuleringen gå: "+tidsenheter);
		System.out.println("Forventet antall ankomster pr. tidsenhet: "+gjAnktprTid);
		System.out.println("Forventet antall avganger pr. tidsenhet: "+gjAvgprTid);
		System.out.println("\n");
		
		CircularArrayQueue<Plane>LandingsKø=new CircularArrayQueue<Plane>(10);
		CircularArrayQueue<Plane>AvgangsKø=new CircularArrayQueue<Plane>(10);
		
		int totalAntFlyBehandlet=0;
		int totalAntFlyTokAv=0;
		int totalAntFlyLandet=0;
		int totalAntFlyAvvist=0;
		int totalAntFlyKlareForLanding=0;
		int totalAntFLyKlareForAvgang=0;
		int totalLedigTid=0;
		float totalVenteTidForLanding=0;
		float totalVenteTidForAvgang=0;
		float totalAntEnhterSomVentetForLanding=0;
		float totalAntEnhterSomVentetForAvgang=0;
		
		for(int i=0;i<tidsenheter;i++){
			
			int TilfAntFly=getPoissonRandom(gjAnktprTid);
			System.out.println(i+":");
			for(int j=0;j<TilfAntFly;j++){
				
				if(!LandingsKø.isFull()){    
					planees.get(0).setAnkomsttid(i);
					LandingsKø.enqueue(planees.get(0));
					System.out.println(" fly "+planees.get(0).getNavn()+" er klar for å lande");
					planees.remove(0);
					totalAntFlyKlareForLanding++;
					totalAntFlyBehandlet++;
				}	
				else if(LandingsKø.isFull()){             
					System.out.println(" Landingskøen er full,fly"+ planees.get(0).getNavn()+"vennligst land på en annen flyplass");
					planees.remove(0);
					totalAntFlyAvvist++;
				}
				}

			int TilfAntFlyTaAv= getPoissonRandom(gjAvgprTid); 

		for(int k=0;k<TilfAntFlyTaAv;k++){
			
				if(!AvgangsKø.isFull()){
					planees.get(0).setAnkomsttid(i);
					AvgangsKø.enqueue(planees.get(0));
					System.out.println(" fly "+planees.get(0).getNavn()+" er klar for å ta av");
					planees.remove(0); 
					totalAntFLyKlareForAvgang++;
					totalAntFlyBehandlet++;
				}
				else if(AvgangsKø.isFull()){
						System.out.println(" Avganskøen er full, avgang for fly: "+planees.get(0).getNavn()+ " må prøves senere");
						totalAntFlyAvvist++;
				}
			}
		if(!LandingsKø.isEmpty()){
				
			int ventetid=i-LandingsKø.first().getAnkomsttid();
					
			if(ventetid>0){
				totalAntEnhterSomVentetForLanding++;
				
			}
			totalVenteTidForLanding+=ventetid;
			System.out.println(" fly "+LandingsKø.first().getNavn()+" landet"+ ", ventetid "+ ventetid+" tidsenheter");
			LandingsKø.dequeue();
			totalAntFlyLandet++;
			}
		else if(!AvgangsKø.isEmpty()&&LandingsKø.isEmpty()){
			
			int ventetidT=i - AvgangsKø.first().getAnkomsttid();
				if(ventetidT>0){
					totalAntEnhterSomVentetForAvgang++;
				}
				totalVenteTidForAvgang+=ventetidT;
				System.out.println(" fly "+AvgangsKø.first().getNavn()+" tok av"+ ", ventetid "+ ventetidT+" tidsenheter");
				AvgangsKø.dequeue();
				totalAntFlyTokAv++;
				}
		else {
				
				System.out.println(i+": Flyplassen er tom");
				totalLedigTid++;
			}
		}
		
		System.out.println("\n");
		System.out.println("Simuleringen ferdig etter: "+tidsenheter+" tidsenheter");
		System.out.println("totalt antall fly behandlet: "+totalAntFlyBehandlet);
		System.out.println("antall fly landet: "+totalAntFlyLandet);
		System.out.println("antall fly tatt av: "+totalAntFlyTokAv);
		System.out.println("antall fly avvist: "+totalAntFlyAvvist);
		System.out.println("antall fly klare for landing: "+totalAntFlyKlareForLanding);
		System.out.println("antall fly klare for avgang: "+totalAntFLyKlareForAvgang);
		int prosentLedigTid=0;
		if (totalLedigTid == 0) {
			prosentLedigTid=0;
		}else{
			prosentLedigTid=tidsenheter/totalLedigTid;
		}
		
		System.out.println("prosent ledig tid: "+prosentLedigTid);
		float gjVentTidLand=0;
		if(totalAntEnhterSomVentetForLanding==0){
			gjVentTidLand=0;
		}else{
			gjVentTidLand=totalVenteTidForLanding/totalAntEnhterSomVentetForLanding;
		}
		System.out.println("Gj.snitt. ventetid, landing: "+gjVentTidLand);
		float gjVentAvg=0;
		if(totalAntEnhterSomVentetForAvgang==0){
			gjVentAvg=0;
		}else {
			gjVentAvg=totalVenteTidForAvgang/totalAntEnhterSomVentetForAvgang;
		}
		System.out.println("Gj.snitt. ventetid, avgang: "+gjVentAvg);
	}
	 private static int getPoissonRandom(double mean)
	    {
		Random r = new Random();
		double L = Math.exp(-mean);
		int k = 0;
		double p = 1.0;
		do
	        {
		    p = p * r.nextDouble();
		    k++;
		} while (p > L);
		return k - 1;
	    }
	 public static void FillWithPlanes(LinkedList<Plane>array, int b){
			
			for(int i=0;i<b;i++){
			array.add(new Plane(i));
			}
	 }
}
