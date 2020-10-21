package com.demo.employeecatalogue.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.demo.employeecatalogue.DTO.UserDetailsDTO;
import com.demo.employeecatalogue.model.UserDetails;

class ConversionUtilTest {

	@Test
	void testConvertUserDetailsDtoToEntity_withNullDto() {
		UserDetailsDTO userDetailsDto = null;
		assertThrows(NullPointerException.class, () -> ConversionUtil.convertUserDetailsDtoToEntity(userDetailsDto),
				"userDetailsDto cann't be null");
	}

	@Test
	void testConvertUserDetailsDtoToEntity() {

		UserDetailsDTO userDetailsDto = new UserDetailsDTO(3, "Sachin", LocalDate.of(1980, 3, 19), "342142",
				"sdfs@sdf");
		UserDetails userDetails = ConversionUtil.convertUserDetailsDtoToEntity(userDetailsDto);
		assertEquals(new UserDetails("Sachin", LocalDate.of(1980, 3, 19), "342142", "sdfs@sdf"), userDetails);
	}
	
	@Test
	void testConvertUserDetailsEntityToDto_withNullEntity() {
		UserDetails userDetails = null;
		assertThrows(NullPointerException.class, () -> ConversionUtil.convertUserDetailsEntityToDto(userDetails),
				"userDetails entity cann't be null");
	}

	@Test
	void testConvertUserDetailsEntityToDto() {

		UserDetails userDetails = new UserDetails("Sachin", LocalDate.of(1980, 3, 19), "342142",
				"sdfs@sdf");
		UserDetailsDTO userDetailsDto = ConversionUtil.convertUserDetailsEntityToDto(userDetails);
		userDetailsDto.setUserId(3);
		assertEquals(new UserDetailsDTO(3,"Sachin", LocalDate.of(1980, 3, 19), "342142", "sdfs@sdf"), userDetailsDto);
	}

}
