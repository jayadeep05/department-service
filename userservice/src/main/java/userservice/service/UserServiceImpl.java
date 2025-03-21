package userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import userservice.dto.DepartmentDto;
import userservice.dto.ResponseDto;
import userservice.dto.UserDto;
import userservice.entity.User;
import userservice.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user); 
    }

    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8082/departments/" + user.getDepartmentId(),
                DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setEmployeeId(user.getEmployeeId());
        userDto.setEmployeeFirstName(user.getEmployeeFirstName());
        userDto.setEmployeeLastName(user.getEmployeeLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
 