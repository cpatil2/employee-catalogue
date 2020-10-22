package com.demo.employeecatalogue.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

class UserDetailsServiceTest {

	@Autowired
	UserDetailsService userDetailsService;
	
	MyList listMock = Mockito.mock(MyList.class);
	
	@Test
	public void getAllUserDetailsTest() {
		when(userDetailsService.getAllUserDetails())
			.thenReturn(Stream.of(new UserDetails("sachin","2342","fm@g"),
					new UserDetails("sachin","2342","fm@g"),)new UserDetails("sachin","2342","fm@g"))
			.collect(Collectors.toList());
		
		assertEquals(2,userDetailsService.getAllUserDetails().size());
		
	}
	
	
	@Test
	public void getUserDetailsByUserIdTest() {
		when(userDetailsService.getAllUserDetails())
			.thenReturn(Stream.of(new UserDetails("sachin","2342","fm@g"),
					new UserDetails("sachin","2342","fm@g"),)new UserDetails("sachin","2342","fm@g"))
			.collect(Collectors.toList());
		
		assertEquals(2,userDetailsService.getAllUserDetails().size());
		
	}
	
	
	

}
