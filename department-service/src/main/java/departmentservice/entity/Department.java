package departmentservice.entity;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "departments")
@Setter
@Getter

public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	public Department() {}

	
	public Department(String departmentName, String departmentAddress,String departmentCode) {
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	} 
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}


}
