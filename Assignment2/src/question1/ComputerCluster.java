/**
 * 
 */
package question1;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author Dhaval
 *
 */
public class ComputerCluster implements LabResource {
	
	private String resourceId;
	private String supervisor;
	private double costOfMaintanencePerYear;
	private String clusterId;
	private String resourceType;
	
	//This arraylist will contains the instances of Printer, Workstation and Computer Cluster.
	private ArrayList<LabResource> resourceList = new ArrayList<LabResource>();
	private Iterator<LabResource> iterator;
	
	/*
	 * Constructor to initialize values in instance variable.
	 */
	public ComputerCluster(String resourceId, String supervisor, String clusterId){
		this.resourceId = resourceId;
		this.supervisor = supervisor;
		this.clusterId = clusterId;
		this.costOfMaintanencePerYear = 0;
		resourceType = "Computer Cluster";
	}

	/*
	 * This method is used to add LabResource instance in Computer Cluster instance.
	 */
	public void add(LabResource resource){
		String resourceType;
		
		if(resource instanceof Printer){
			resourceType = "Printer";
		}else if(resource instanceof Workstation){
			resourceType = "Workstation";
		}else{
			resourceType = "Computer Cluster";
		}
		
		System.out.println("Adding a " + resourceType + " to cluster...\n");
		resource.setSupervisor(this.supervisor);
		resourceList.add(resource);
		System.out.println(resourceType + " added!\n");
	}
	
	/*
	 * This method is used to remove or inactive the state of Workstation or Printer instance.
	 */
	public void remove(String resourceId){
		setInactive(resourceId);
	}
	
	/*
	 * This method returns the total cost of maintenance/year of all the LabResource instance within Computer Cluster instance.
	 */
	public double showCostofMaintenance(){
		double totalCostofMaintenancePerYear = 0.0;
		
		iterator = resourceList.iterator();
		while(iterator.hasNext()){
			totalCostofMaintenancePerYear += iterator.next().showCostofMaintenance();
		}
		
		return totalCostofMaintenancePerYear;
	}

	/*
	 * This methods shows details of the particular instance and the instance it contains.
	 */
	public void showResourceDetails(){
		System.out.println("Resource ID of Cluster: " + resourceId);
		System.out.println("Supervisor of Cluster: " + supervisor);
		System.out.println("Cluster ID: " + clusterId);
		System.out.println("Total cost of maintainence/year: $" + showCostofMaintenance());
		System.out.println("\n");
		
		iterator = resourceList.iterator();
		while(iterator.hasNext()){
			iterator.next().showResourceDetails();
		}
	}
	
	/*
	 * This method returns that the instance type is "Computer Cluster".
	 */
	public String getResourceType(){
		return resourceType;	
	}
	
	/*
	 * This method sets status to false for given resource id.
	 */
	public void setInactive(String resourceId){
		iterator = resourceList.iterator();
		LabResource resource;
		
		while(iterator.hasNext()){
			resource = iterator.next();
			
			if(resource instanceof Printer){
				Printer printerInstance = (Printer) resource;
				if(printerInstance.getResourceId() == resourceId){
					printerInstance.setInactive();
					System.out.println("Resource has been inactive.");
				}
			}
			else if(resource instanceof Workstation){
				Workstation workstationInstance = (Workstation) resource;
				if(workstationInstance.getResourceId() == resourceId){
					workstationInstance.setInactive();
					System.out.println("Resource has been inactive.");
				}
			}
		}
	}

	/*
	 * This method shows which lab resource is older than the input parameter model year.
	 */
    public void showOlderModel(int modelYear){
    	iterator = resourceList.iterator();
    	LabResource resource;
    	
    	while(iterator.hasNext()){
    		resource = iterator.next();
    		
    		if(resource instanceof Printer){
				Printer printerInstance = (Printer) resource;
				if(printerInstance.getModelYear() < modelYear){
					printerInstance.showResourceDetails();
				}
			}
			else if(resource instanceof Workstation){
				Workstation workstationInstance = (Workstation) resource;
				if(workstationInstance.getModelYear() < modelYear){
					workstationInstance.showResourceDetails();
				}
			}
    	}
    }

    
    /*
	 * This method sets supervisor.
	 */
	public void setSupervisor(String supervisor){
		this.supervisor = supervisor;
	}
}
