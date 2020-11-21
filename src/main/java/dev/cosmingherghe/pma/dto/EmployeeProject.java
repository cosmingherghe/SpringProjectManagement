package dev.cosmingherghe.pma.dto;

public interface EmployeeProject {

    //Need to have property names begin with get - how Spring data know that this data tranfer has to be populate with data that comes from the table from the custom query
    public String getFirstName();
    public int getProjectCount();

}
