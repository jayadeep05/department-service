package departmentservice.service;

import departmentservice.entity.Department;
import departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@AllArgsConstructor
//@slf4j

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
		
	}
	
	@Override
	public Department getDepartment(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}
} 
