package com.demo.employeecatalogue.util;

import com.demo.employeecatalogue.DTO.UserDetailsDTO;
import com.demo.employeecatalogue.model.UserDetails;

public class ConversionUtil {
	
	public static UserDetails convertUserDetailsDtoToEntity(UserDetailsDTO userDetailsDto) {
		UserDetails userDetails = new UserDetails();
		
		userDetails.setName(userDetailsDto.getName());
		userDetails.setDob(userDetailsDto.getDob());
		userDetails.setMobile(userDetailsDto.getMobile());
		userDetails.setEmail(userDetailsDto.getEmail());
		return userDetails;
	}
	
	public static UserDetailsDTO convertUserDetailsEntityToDto(UserDetails userDetails) {
		UserDetailsDTO userDetailsDto = new UserDetailsDTO();
		userDetailsDto.setUserId(userDetails.getUserId());
		userDetailsDto.setName(userDetails.getName());
		userDetailsDto.setDob(userDetails.getDob());
		userDetailsDto.setMobile(userDetails.getMobile());
		userDetailsDto.setEmail(userDetails.getEmail());
		return userDetailsDto;
	}
	
	

}
