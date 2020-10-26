package com.demo.employeecatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeecatalogue.DTO.UserDetailsDTO;
import com.demo.employeecatalogue.exception.InvalidArgumentException;
import com.demo.employeecatalogue.exception.InvalidUserDetailsDTOException;
import com.demo.employeecatalogue.exception.ResourceNotFoundException;
import com.demo.employeecatalogue.service.UserDetailsService;


@RestController
public class UserDetailsController {

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/userdetails")
	public ResponseEntity<List<UserDetailsDTO>> loadAllUserDetails() {
		List<UserDetailsDTO> userDetailsDtoList = userDetailsService.getAllUserDetails();
		return new ResponseEntity<>(userDetailsDtoList, HttpStatus.OK);
	}

	@GetMapping("/getuserdetailsbyuserid")
	public ResponseEntity<UserDetailsDTO> getUserdetailsByUserId(@RequestParam("userid") int userid)
			throws ResourceNotFoundException, InvalidArgumentException {
		System.out.println("Hello");
		UserDetailsDTO userDetailsDto = userDetailsService.getUserDetailsById(userid);
		return new ResponseEntity<>(userDetailsDto, HttpStatus.OK);
	}

	@GetMapping("/getuserdetailsbymobile")
	public ResponseEntity<UserDetailsDTO> getUserDetailsByMobile(@RequestParam("mobile") String mobile)
			throws ResourceNotFoundException, InvalidArgumentException {
		System.out.println("Hi");
		UserDetailsDTO userDetailsDto = userDetailsService.getUserDetailsByMobile(mobile);
		return new ResponseEntity<>(userDetailsDto, HttpStatus.OK);
	}

	@GetMapping("/getUserdetailsbymobile/{mobile}")
	public ResponseEntity<UserDetailsDTO> getUserDetailsByMobile1(@PathVariable("mobile") String mobile)
			throws ResourceNotFoundException, InvalidArgumentException {
		System.out.println("Fi");
		UserDetailsDTO userDetailsDto = userDetailsService.getUserDetailsByMobile(mobile);
		return new ResponseEntity<>(userDetailsDto, HttpStatus.OK);
	}

	@PostMapping("/saveuserdetails")
	public ResponseEntity<UserDetailsDTO> createUserDetails(@RequestBody UserDetailsDTO userDetailsDto)
			throws InvalidUserDetailsDTOException {
		userDetailsDto = userDetailsService.createUserDetails(userDetailsDto);
		return new ResponseEntity<>(userDetailsDto, HttpStatus.CREATED);
	}

	@PutMapping("/updateuserdetails")
	public ResponseEntity<UserDetailsDTO> updateUserDetails(@RequestBody UserDetailsDTO userDetailsDto)
			throws InvalidUserDetailsDTOException, ResourceNotFoundException {
		userDetailsDto = userDetailsService.updateUserDetails(userDetailsDto);
		return new ResponseEntity<>(userDetailsDto, HttpStatus.OK);
	}

	@DeleteMapping("/userdetails/{userid}")
	public ResponseEntity<List<UserDetailsDTO>> deleteUserDetailsById(@PathVariable("userid") int userid)
			throws ResourceNotFoundException, InvalidArgumentException {
		List<UserDetailsDTO> userDetailsDtoList = userDetailsService.deleteUserDetailsById(userid);
		return new ResponseEntity<>(userDetailsDtoList, HttpStatus.OK);
	}

	@DeleteMapping("/userdetails")
	public ResponseEntity<List<UserDetailsDTO>> deleteUserDetails() {
		List<UserDetailsDTO> userDetailsDtoList = userDetailsService.deleteUserDetails();
		return new ResponseEntity<>(userDetailsDtoList, HttpStatus.OK);
	}

}
