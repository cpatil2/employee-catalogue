package com.demo.employeecatalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employeecatalogue.DTO.UserDetailsDTO;
import com.demo.employeecatalogue.exception.InvalidArgumentException;
import com.demo.employeecatalogue.exception.InvalidUserDetailsDTOException;
import com.demo.employeecatalogue.exception.ResourceNotFoundException;
import com.demo.employeecatalogue.model.UserDetails;
import com.demo.employeecatalogue.repository.UserRepository;
import com.demo.employeecatalogue.util.ConversionUtil;
import com.demo.employeecatalogue.validation.UserDetailsValidation;

@Service
public class UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	

	public UserDetailsDTO createUserDetails(UserDetailsDTO userDetailsDto) throws InvalidUserDetailsDTOException {

		if (UserDetailsValidation.isValid(userDetailsDto)) {

			// convert dto to model
			UserDetails userDetails = ConversionUtil.convertUserDetailsDtoToEntity(userDetailsDto);

			// save userw
			userDetails = userRepository.save(userDetails);

			// convert model to dto
			userDetailsDto = ConversionUtil.convertUserDetailsEntityToDto(userDetails);

			// return saved user
			return userDetailsDto;
		} else {
			throw new InvalidUserDetailsDTOException("userDetails data is invalid");
		}

	}

	public List<UserDetailsDTO> getAllUserDetails() {
		// TODO Auto-generated method stub
		List<UserDetails> userDetailsList = userRepository.findAll();
		userDetailsList.forEach(System.out::println);
		List<UserDetailsDTO> userDetailsDtoList = new ArrayList<UserDetailsDTO>();

		for (UserDetails userDetails : userDetailsList) {
			userDetailsDtoList.add(ConversionUtil.convertUserDetailsEntityToDto(userDetails));
		}
		return userDetailsDtoList;
	}

	public UserDetailsDTO getUserDetailsById(int userid) throws ResourceNotFoundException, InvalidArgumentException {

		if (UserDetailsValidation.isValidUserIdArgument(userid)) {
			// check if user exists otherwise throw exception
			UserDetails userDetails = userRepository.findById(userid)
					.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
			return ConversionUtil.convertUserDetailsEntityToDto(userDetails);
		} else {
			throw new InvalidArgumentException("Invalid userid argument");
		}

	}
	

	public UserDetailsDTO updateUserDetails(UserDetailsDTO userDetailsDto)
			throws ResourceNotFoundException, InvalidUserDetailsDTOException {
		if (UserDetailsValidation.isValid(userDetailsDto)) {

			// check if user exists otherwise throw exception
			UserDetails existingUserDetails = userRepository.findById(userDetailsDto.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));

			// convert dto to model
			UserDetails updatedUserDetails = ConversionUtil.convertUserDetailsDtoToEntity(userDetailsDto);

			// modify existingUserDetails properties by updatedUserDetails properties
			BeanUtils.copyProperties(updatedUserDetails, existingUserDetails);

			// save user details
			existingUserDetails = userRepository.save(existingUserDetails);

			// convert model to dto
			userDetailsDto = ConversionUtil.convertUserDetailsEntityToDto(existingUserDetails);

			// return saved user
			return userDetailsDto;
		} else {
			throw new InvalidUserDetailsDTOException("userDetails data is invalid");
		}

	}

	public List<UserDetailsDTO> deleteUserDetailsById(int userid)
			throws ResourceNotFoundException, InvalidArgumentException {

		if (UserDetailsValidation.isValidUserIdArgument(userid)) {
			// check if user exists otherwise throw exception
			userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
			userRepository.deleteById(userid);

			return getAllUserDetails();
		} else {
			throw new InvalidArgumentException("Invalid userid argument");
		}

	}

	public List<UserDetailsDTO> deleteUserDetails() {

		userRepository.deleteAll();

		return getAllUserDetails();

	}

	public UserDetailsDTO getUserDetailsByMobile(String mobile)
			throws ResourceNotFoundException, InvalidArgumentException {

		if (UserDetailsValidation.isValidMobileArgument(mobile)) {
			// check if user exists otherwise throw exception
			UserDetails userDetails = userRepository.findByMobile(mobile)
					.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));

			return ConversionUtil.convertUserDetailsEntityToDto(userDetails);
		} else {
			throw new InvalidArgumentException("Invalid mobile argument");
		}

	}
	
	

}
