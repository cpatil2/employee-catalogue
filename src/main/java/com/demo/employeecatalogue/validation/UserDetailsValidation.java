package com.demo.employeecatalogue.validation;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import com.demo.employeecatalogue.DTO.UserDetailsDTO;

public class UserDetailsValidation {

	private static final Logger LOG = LoggerFactory.getLogger("UserDetailsValidation.class");

	public static boolean isValid(UserDetailsDTO userDetailsDto) {

		if (userDetailsDto != null && isValidUserIdArgument(userDetailsDto.getUserId())
				&& isValidNameArgument(userDetailsDto.getName()) && isValidDobArgument(userDetailsDto.getDob())
				&& isValidMobileArgument(userDetailsDto.getMobile())
				&& isValidEmailArgument(userDetailsDto.getEmail())) {
			return true;
		}

		LOG.info("UserDetailsDto is not valid");
		return false;
	}

	public static boolean isValidUserIdArgument(int userId) {
		if (userId > 0) {
			return true;
		}
		LOG.info("userid is not valid" + userId);
		return false;
	}

	public static boolean isValidNameArgument(String name) {
		if (StringUtils.isNoneBlank(name)) {
			return true;
		}
		LOG.info("name is not valid" + name);
		return false;
	}

	public static boolean isValidDobArgument(LocalDate dob) {
		if (dob !=null && Period.between(dob, LocalDate.now()).getYears() > 18) {
			return true;
		}
		LOG.info("dob is not valid :" + dob);
		return false;
	}

	public static boolean isValidMobileArgument(String mobile) {
		if( StringUtils.isNotBlank(mobile)) {
			 Pattern p = Pattern.compile("[7-9][0-9]{9}");
			 Matcher m = p.matcher(mobile); 
			    return (m.find() && m.group().equals(mobile)); 
		}
		
		return false;
	}

	public static boolean isValidEmailArgument(String email) {
		if (StringUtils.isNotBlank(email)) {
			return true;
		}
		LOG.info("email is not valid" + email);
		return false;
	}

}
