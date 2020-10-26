package com.demo.employeecatalogue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.employeecatalogue.DTO.UserDetailsDTO;
import com.demo.employeecatalogue.exception.InvalidArgumentException;
import com.demo.employeecatalogue.exception.ResourceNotFoundException;
import com.demo.employeecatalogue.model.UserDetails;
import com.demo.employeecatalogue.repository.UserRepository;
import com.demo.employeecatalogue.util.ConversionUtil;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceTest {

	@Autowired
	@InjectMocks
	UserDetailsService userDetailsService;

	@Mock
	UserRepository userRepository;

	@Test
	@DisplayName("testing get all userdetails happy path")
	public void getAllUserDetailsTest_happyPath() {

		List<UserDetails> userDetailsListMock = new ArrayList<>();
		userDetailsListMock.add(new UserDetails("Rishabh", LocalDate.of(2000, 12, 20), "2342", "fm@g"));
		userDetailsListMock.add(new UserDetails("Krunal", LocalDate.of(2001, 12, 20), "2343", "fm@g1"));

		Mockito.when(userRepository.findAll()).thenReturn(userDetailsListMock);

		List<UserDetailsDTO> actualUserDetailsDtoList = userDetailsService.getAllUserDetails();

		List<UserDetailsDTO> expectedUserDetailsDtoListMock = new ArrayList<>();

		for (UserDetails userDetailsMock : userDetailsListMock) {
			expectedUserDetailsDtoListMock.add(ConversionUtil.convertUserDetailsEntityToDto(userDetailsMock));
		}

		assertEquals(expectedUserDetailsDtoListMock, actualUserDetailsDtoList);

		assertEquals(expectedUserDetailsDtoListMock.size(), actualUserDetailsDtoList.size());

		assertEquals(new UserDetails("Rishabh", LocalDate.of(2000, 12, 20), "2342", "fm@g"),
				new UserDetails("Rishabh", LocalDate.of(2000, 12, 20), "2342", "fm@g"));
	}

	@Test
	@DisplayName("testing get userdetails by userId happy path")
	public void getUserDetailsByUserIdTest_happyPath() throws ResourceNotFoundException, InvalidArgumentException {

		UserDetails userDetails = new UserDetails("Rishabh", LocalDate.of(2000, 12, 20), "2342", "fm@g");
		Optional<UserDetails> userOptionalMock = Optional.of(userDetails);

		Mockito.when(userRepository.findById(3)).thenReturn(userOptionalMock);

		UserDetailsDTO actualUserDetailsDto = userDetailsService.getUserDetailsById(3);

		UserDetailsDTO expectedUserDetailsDtoMock = ConversionUtil
				.convertUserDetailsEntityToDto(userOptionalMock.get());

		assertEquals(expectedUserDetailsDtoMock, actualUserDetailsDto);

	}
	
	
	
	@Test
	@DisplayName("testing get userdetails by mobile happy path")
	public void getUserDetailsByMobileTest_happyPath() throws ResourceNotFoundException, InvalidArgumentException {

		UserDetails userDetails = new UserDetails("Rishabh", LocalDate.of(2000, 12, 20), "9876543210", "fm@g");
		Optional<UserDetails> userDetailsOptionalMock = Optional.of(userDetails);

		Mockito.when(userRepository.findByMobile(Mockito.anyString())).thenReturn(userDetailsOptionalMock);
	
		UserDetailsDTO actualUserDetailsDto = userDetailsService.getUserDetailsByMobile("9876543210");

		UserDetailsDTO expectedUserDetailsDtoMock = ConversionUtil
				.convertUserDetailsEntityToDto(userDetailsOptionalMock.get());

		assertEquals(expectedUserDetailsDtoMock, actualUserDetailsDto);

	}
	
	
//	@Test
//	@Disabled
//	@DisplayName("testing delete userdetails by userid happy path")
//	public void deleteUserDetailsByUserIdTest_happyPath() throws ResourceNotFoundException, InvalidArgumentException {
//
//		List<UserDetails> userDetailsListMock = new ArrayList<>();
//		userDetailsListMock.add(new UserDetails("Rishabh", LocalDate.of(2000, 12, 20), "2342", "fm@g"));
//		userDetailsListMock.add(new UserDetails("Krunal", LocalDate.of(2001, 12, 20), "2343", "fm@g1"));
//		
//		//Mockito.when(userRepository.deleteById((Mockito.anyInt())).thenReturn(userDetailsListMock);
//	
//		List<UserDetailsDTO> actualUserDetailsDtoList = userDetailsService.deleteUserDetailsById(3);
//
//		UserDetailsDTO expectedUserDetailsDtoMock = ConversionUtil
//				.convertUserDetailsEntityToDto(userDetailsOptionalMock.get());
//
//		assertEquals(expectedUserDetailsDtoMock, actualUserDetailsDtoList);
//
//	}
	
	
	
	

}
