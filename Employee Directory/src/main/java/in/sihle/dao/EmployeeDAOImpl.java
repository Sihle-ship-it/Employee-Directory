package in.sihle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.sihle.entity.Employee;
import in.sihle.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public List<Employee> get() {
		
		//Create reference variables
		List<Employee> list = null;
		Employee employee = null;
		
		try {
			list = new ArrayList<Employee>();
			
			//Create sql query
			String sql = "SELECT * FROM tbl_employee";
			
			//Get database connection
			connection = DBConnectionUtil.openConnection();
			
			//Create a statement
			statement = connection.createStatement();
			
			//Execute the sql query
			resultSet = statement.executeQuery(sql);
			
			//Process the resultset
			while(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setDob(resultSet.getString("dob"));
				
				//Add employee to list
				list.add(employee);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//return the list
		return list;
	}

}
