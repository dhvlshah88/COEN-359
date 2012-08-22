/**
 * 
 */
package question1;

/**
 * @author Dhaval
 *
 */
public class PatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Workstation dellWorkstation = new Workstation("W1", 2009, true, "Jim", 800);
		Workstation appleWorkstation = new Workstation("W2", 2012, true, "Sean", 600);
		
		Printer laser = new Printer("P1", 2006, true, "Tim", 75);
		Printer plotter = new Printer("P2", 2005, true, "Henna", 100);
		
		ComputerCluster clusterA = new ComputerCluster("C1", "Ricky", "CC1");
		ComputerCluster clusterB = new ComputerCluster("C2", "James", "CC2");
		
		
		/*
		 * NOTE : When workstation and printer instance are added to clusterA, their supervisor is changed to clusterA's supervisor.
		 * 		  And when clusterA is added to clusterB, supervisor of only clusterA is changed to clusterB's supervisor but the 
		 *  	  instance inside has original clusterA's supervisor.  
		 * 
		 */
		
		//Add two workstation and a printer in cluster A.
		clusterA.add(dellWorkstation);
		clusterA.add(appleWorkstation);
		clusterA.add(laser);
		
		
		//Test Cases for cluster A.
		System.out.println("---------------SHOWING TOTAL COST OF MAINTENANCE OF CLUSTER A--------------------\n");
		System.out.println("The total cost of maintenance/year for cluster A is $" + clusterA.showCostofMaintenance());
		System.out.println("\n");
		
		System.out.println("---------------SHOWING RESOURCE DETAILS OF CLUSTER A--------------------\n");
		clusterA.showResourceDetails();
		
		System.out.println("---------------SHOWING OLD MODEL(S) IN CLUSTER A--------------------\n");
		clusterA.showOlderModel(2010);
		
		System.out.println("---------------SET THE RESOURCE TO INACTIVE IN CLUSTER A--------------------\n");
		clusterA.setInactive("P1");
		laser.showResourceDetails();
		clusterA.showResourceDetails();
		
		
		//Test Cases for workstation.
		System.out.println("\nDell Workstation's model year is older than 2010: " + (dellWorkstation.oldModel(2010)? "Yes":"No"));
		System.out.println("\nDell Workstation's model year is older than 2000: " + (dellWorkstation.oldModel(2000)? "Yes":"No"));
		
		//Test Cases for printer.
		System.out.println("\nLaser Printer's model year is older than 2005: " + (laser.oldModel(2005)? "Yes":"No"));
		System.out.println("\nPlotter Printer's model year is older than 2006: " + (plotter.oldModel(2006)? "Yes":"No"));		
		
		
		
		//Add cluster A and one other printer in cluster B.
		clusterB.add(clusterA);
		clusterB.add(plotter);
		
		
		//Test case for cluster B.
		System.out.println("---------------SHOWING RESOURCE DETAILS OF CLUSTER B--------------------\n");
		clusterB.showResourceDetails();
	
		System.out.println("---------------SHOWING TOTAL COST OF MAINTENANCE OF CLUSTER B--------------------\n");
		System.out.println("The total cost of maintenance/year for cluster B is $" + clusterB.showCostofMaintenance());
		System.out.println("\n");
		
		System.out.println("---------------REMOVE THE RESOURCE FROM CLUSTER B--------------------\n");
		clusterB.remove("P2");
		System.out.println("\n");
		plotter.showResourceDetails();
		
	}

}
