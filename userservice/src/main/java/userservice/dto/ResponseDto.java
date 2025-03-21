package userservice.dto;

public class ResponseDto {
	private DepartmentDto department;
	private UserDto user;
	
	
//	public Long getEmployeeId() {
//		// TODO Auto-generated method stub
//		return employeeId;
//	}
//	
//	public String getEmail() {
//		// TODO Auto-generated method stub
//		return email;
//		
//	}
	
	public void setUser(UserDto userDto) {
		// TODO Auto-generated method stub
		this.user = userDto;
		
	}
	public void setDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		this.department = departmentDto;
		
	}

}
