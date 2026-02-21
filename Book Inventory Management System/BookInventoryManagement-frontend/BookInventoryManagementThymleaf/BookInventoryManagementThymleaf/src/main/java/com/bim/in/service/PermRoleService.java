package com.bim.in.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bim.in.pojo.PermRolePojo;

@Service
public class PermRoleService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<PermRolePojo> getAllPermRole(){
		ResponseEntity<List<PermRolePojo>> response=restTemplate.exchange("http://localhost:9999/api/role",
				HttpMethod.GET,
				null, new ParameterizedTypeReference<List<PermRolePojo>>() {});
		
		return response.getBody();
	}
	
//	public void createPermRole(PermRolePojo permRolePojo) {
//		String apiUrl="http://localhost:9999/api/permrole/post";
//		HttpEntity<PermRolePojo> request=new HttpEntity<>(permRolePojo);
//		ResponseEntity<Void> response=restTemplate.exchange(apiUrl, HttpMethod.POST,request,Void.class);
//		if(response.getStatusCode()==HttpStatus.CREATED) {
//			System.out.print("Success");
//		}else {
//			System.out.println("failed");
//		}
//	}
//	
//	public void createPermRole(PermRolePojo permRolePojo) {
//		String apiUrl="http://localhost:9999/api/permrole/post";
//		restTemplate.postForObject(apiUrl, permRolePojo, PermRolePojo.class);
//	}
	
	public PermRolePojo savePermRole(PermRolePojo permrole) {
        String sql = "INSERT INTO permrole (role_number, perm_role) VALUES (?, ?)";
        jdbcTemplate.update(sql, permrole.getRoleNumber(), permrole.getPermRole());
        return permrole;
    }
	public String updatePermRole(Integer roleNumber, PermRolePojo permRole) {
		String apiUrl="http://localhost:9999/api/permrole/update/permrole/"+roleNumber;
		ResponseEntity<PermRolePojo> response=restTemplate.exchange(apiUrl,
				HttpMethod.PUT,
				new HttpEntity<>(permRole),PermRolePojo.class);
		if(response.getStatusCode()==HttpStatus.OK) {
			PermRolePojo updatePermRole = response.getBody();
			if(updatePermRole!=null) {
				return updatePermRole.getPermRole();
			}else {
				return "error";
			}
		}else {
			return "error";
		}
	}
	
	
//	public PermRolePojo savePermRoleBYRoleNumber(PermRolePojo permrole) {
//        int permRoleRoleNumber = generatePermroleRoleNumber();
// 	        payment.setPayment_id(paymentId);
//        paymentMap.put( paymentId, payment);
// 	        return payment;
//    }
}