package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import principal.Book;

class BookTest {
	
	private Book bookUnderTest;

	@BeforeEach
	public void AppelAvantChaqueTest() {
		System.out.println("Appel avant chaque test");
		// avant chaque tests : initialisation d'une instance 
		bookUnderTest = new Book();
	}
	
	@ParameterizedTest
	@NullSource
	void testSetTitleWithNullValue(String title) {
		//fail("Not yet implemented");
		
		Exception e = assertThrows(Exception.class, () -> {
			bookUnderTest.setTitle(title);
		});
		assertEquals("Erreur : Null", e.getMessage());
	}
	
	@ParameterizedTest
	@EmptySource
	void testSetTitleWithEmptyValue(String title) {
		//fail("Not yet implemented");
		
		Exception e = assertThrows(Exception.class, () -> {
			bookUnderTest.setTitle(title);
		});
		assertEquals("Erreur : Empty", e.getMessage());
	}

	@ParameterizedTest(name = "testSetTitleWithBlankValue")
	@ValueSource(strings = { " ", "  ", "    " })
	void testSetTitleWithBlankValue(String title) {
		//fail("Not yet implemented");
		
		Exception e = assertThrows(Exception.class, () -> {
			bookUnderTest.setTitle(title);
		});
		assertEquals("Erreur : Blank", e.getMessage());
	}
}
