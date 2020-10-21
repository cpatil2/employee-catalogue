package com.demo.employeecatalogue.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserDetailsValidationTest {

	Boolean actual;

	@BeforeEach
	public void init_beforeEachTestMethod() {
		actual = false;
	}

	@Nested
	@DisplayName("user id argument validation test")
	class UserIdArgumentValidationTest {

		@Test
		@Tag("negative_scenario")
		@DisplayName("testing user id as negative")
		void testIsValidUserIdArgument_withNegativeValue() {
			actual = UserDetailsValidation.isValidUserIdArgument(-7);
			assertEquals(false, actual, "name can not be null");
		}

		@Test
		@DisplayName("testing user id as happy scenario")
		void testIsValidNameArgument() {
			actual = UserDetailsValidation.isValidUserIdArgument(20);
			assertEquals(true, actual);
		}

	}

	@Nested
	@DisplayName("name argument validation test")
	class NameArgumentValidationTest {
		@Test
		@Tag("negative_scenario")
		@DisplayName("testing name as null")
		void testIsNameArgument_withNullString() {
			actual = UserDetailsValidation.isValidNameArgument(null);
			assertEquals(false, actual, "name can not be null");
		}

		@Test
		@Tag("negative_scenario")
		@DisplayName("testing name as empty string")
		void testIsValidNameArgument_withEmptyString() {
			actual = UserDetailsValidation.isValidNameArgument("");
			assertEquals(false, actual, "name can not be empty");
		}

		@Test
		@DisplayName("testing name as happy scenario")
		void testIsValidNameArgument() {
			actual = UserDetailsValidation.isValidNameArgument("Sachin");
			assertEquals(true, actual);
		}

	}

	@Nested
	@DisplayName("mobile argument validation test")
	class MobileArgumentValidationTest {
		@Test
		@Tag("negative_scenario")
		@DisplayName("testing mobile as null")
		void testIsValidMobileArgument_withNullString() {
			actual = UserDetailsValidation.isValidMobileArgument(null);
			assertEquals(false, actual, "mobile number can not be empty");
		}

		@Test
		@Tag("negative_scenario")
		@DisplayName("testing mobile as empty string")
		void testIsValidMobileArgument_withEmptyString() {
			actual = UserDetailsValidation.isValidMobileArgument("");
			assertEquals(false, actual, "mobile number can not be empty");
		}

		@Test
		@Tag("negative_scenario")
		@DisplayName("testing mobile less than 10 digits")
		void testIsValidMobileArgument_withMobileLengthNotEqualsTen() {
			actual = UserDetailsValidation.isValidMobileArgument("070799");
			assertEquals(false, actual, "mobile number must be 10 digits only");
		}

		@Test
		@DisplayName("testing mobile as happy scenario")
		void testIsValidMobileArgument_withMobileLengthEqualsTen() {
			actual = UserDetailsValidation.isValidMobileArgument("9876543210");
			assertEquals(true, actual);
		}

	}

	@Nested
	@DisplayName("email argument validation test")
	class EmailArgumentValidationTest {
		@Test
		@Tag("negative_scenario")
		@DisplayName("testing email as null")
		void testIsValidEmailArgument_withNullString() {
			actual = UserDetailsValidation.isValidEmailArgument(null);
			assertEquals(false, actual, "mobile number must be 10 digits only");
		}

		@Test
		@Tag("negative_scenario")
		@DisplayName("testing email as empty string")
		void testIsValidEmailArgument_withEmptyString() {
			actual = UserDetailsValidation.isValidEmailArgument("");
			assertEquals(false, actual, "mobile number can not be empty");
		}

		@Test
		@Tag("negative_scenario")
		@Disabled
		@DisplayName("testing email as not following standard email regex pattern")
		void testIsValidEmailArgument_withNotFollowingRegex() {
			actual = UserDetailsValidation.isValidEmailArgument("ascfsdf@sds");
			assertEquals(false, actual, "email must be as per provided regex");
		}

		@Test
		@DisplayName("testing email as happy scenario")
		void testIsValidEmailArgument() {
			actual = UserDetailsValidation.isValidEmailArgument("sdasd@gmail.com");
			assertEquals(true, actual);
		}

	}

	@Nested
	@DisplayName("dob argument validation test")
	class DobArgumentValidationTest {
		@Test
		@Tag("negative_scenario")
		@DisplayName("testing dob as null")
		void testIsValidDobArgument_withNullString() {
			actual = UserDetailsValidation.isValidDobArgument(null);
			assertEquals(false, actual, "dob can not be null");
		}

		@Test
		@Tag("negative_scenario")
		@DisplayName("testing dob as less than 18 years old user")
		void testIsValidDobArgument_withAgeLessThan18() {
			actual = UserDetailsValidation.isValidDobArgument(LocalDate.of(2002, 1, 27));
			assertEquals(false, actual, "dob can not be for less than 18 years");
		}

		@Test
		@DisplayName("testing dob as happy scenario")
		void testIsValidDobArgument() {
			actual = UserDetailsValidation.isValidDobArgument(LocalDate.of(2000, 1, 27));
			assertEquals(true, actual);
		}

	}

}
