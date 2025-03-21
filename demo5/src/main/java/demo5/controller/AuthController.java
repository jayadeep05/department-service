package demo5.controller;


import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo5.entity.User;
import demo5.service.JwtService;
import demo5.service.UserService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")


public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
	
	public ResponseEntity<String> login(@RequestBody LoginRequest request){
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			
			String token = jwtService.generateToken(request.getEmail());
			
			return ResponseEntity.ok(token);
		}
		catch (Exception e) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
      }
		
	}
	
}




//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtService jwtService;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
//        try {
//            // Authenticate user credentials
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//            );
//
//            // Generate JWT token
//            String token = jwtService.generateToken(request.getEmail());
//
//            return ResponseEntity.ok(token);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//}
