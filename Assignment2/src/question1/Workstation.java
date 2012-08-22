/**
 * 
 */
package question1;

/**
 * @author Dhaval
 *
 */
public class Workstation implements LabResource {

	private String resourceId;
	private int modelYear;
	private boolean status;
	private String supervisor;
	private double costOfMaintenancePerYear;
	private String resourceType;
	
	/*
	 * Constructor to initialize values in instance variable.
	 */
	public Workstation(String resourceId, int modelYear, boolean status, String supervisor, double cost){
		this.resourceId = resourceId;
		this.modelYear = modelYear;
		this.status = status;
		this.supervisor = supervisor;
		this.costOfMaintenancePerYear = cost;
		resourceType = "Workstation";
	}
	
	/*
	 * This method take model year as parameter to check whether printer instance is older than it.
	 */
	public boolean oldModel(int modelYear){
		if(this.modelYear < modelYear){
			return true;
		}
		return false;
	}
	
	/*
	 * This method set the status of workstation instance to INACTIVE i.e. false.
	 */
	public void setInactive(){
		status = false;
	}
	
	/*
	 * This method returns the cost of maintenance/year of workstation instance.
	 */
	public double showCostofMaintenance(){
		return costOfMaintenancePerYear;
	}
	
	
	/*
	 * This methods shows details of the particular instance.
	 */
	public void showResourceDetails(){
		System.out.println("Resource ID: " + resourceId);
		System.out.println("Model Year: " + modelYear);
		System.out.println("Status: " + (status?"Active":"Inactive"));
		System.out.println("Supervisor: " + supervisor);
		System.out.println("Cost of maintainence/year: $" + costOfMaintenancePerYear);
		System.out.println("\n");
	}
	
	/*
	 * This method returns that the instance type is "Workstation".
	 */
	public String getResourceType(){
		return resourceType;
	}
	
	/*
	 * This method returns the resourceId of the resource.
	 */
	public String getResourceId(){
		return resourceId;
	}

	/*
	 * This method returns the model year of the resource.
	 */
	public int getModelYear(){
		return modelYear;
	}
	
	/*
	 * This method sets supervisor.
	 */
	public void setSupervisor(String supervisor){
		this.supervisor = supervisor;
	}
}
