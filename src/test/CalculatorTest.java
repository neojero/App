package test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import principal.Calculator;

class CalculatorTest {
	
	
	private  static Instant startedAt;
	private Calculator caculatorUnderTest;
	
	@BeforeEach
	public void AppelAvantChaqueTest() {
		System.out.println("Appel avant chaque test");
		startedAt = Instant.now();
		// avant chaque tests : initialisation d'une instance 
		caculatorUnderTest = new Calculator();

	}
	
	@BeforeAll
	public static void AppeleAvantTousLesTests() {}

	@Test
	void testAddTwoPositiveNumbers() {
		//1er étape
		//fail("Not yet implemented");

		// 2eme etape écriture de mon test.
		// Arrange
		int a = 2;
		int b = 3;

		// Act
		//Calculator calculator = new Calculator();
		int somme = caculatorUnderTest.add(a,b);

		// Assert
		///assertEquals(5, somme);
		
		// utilisation de AssertJ
		assertThat(somme).isEqualTo(5);
	}

	@Test 
	void testMultiplyTwoPositiveNumbers() {
		//1er étape
		//fail("Not yet implemented");

		// 2eme etape écriture de mon test.
		// Arrange
		int a = 2;
		int b = 3;

		// Act
		//Calculator calculator = new Calculator();
		int calcul = caculatorUnderTest.multiply(a,b);

		// Assert
		//assertEquals(6, calcul);
		// utilisation de AssertJ
		assertThat(calcul).isEqualTo(6);
	}
	
	@ParameterizedTest(name = "{0} x 0 doit être égal à 0")
	@ValueSource(ints = { 1, 2, 42, 1011, 5089 })
	public void test_Multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
		// Arrange -- Tout est prêt !

		// Act -- Multiplier par zéro
		int actualResult = caculatorUnderTest.multiply(arg, 0);

		// Assert -- ça vaut toujours zéro !
		//assertEquals(0, actualResult);
		
		// utilisation de AssertJ
		assertThat(actualResult).isEqualTo(0);
	}
	
	@ParameterizedTest(name = "{0} + {1} should equal to {2}")
	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
	public void test_add_shouldReturnTheSum_ofMultipleIntegers(
			int arg1, int arg2, int expectResult) {
		// Arrange -- Tout est prêt !

		// Act
		int actualResult = caculatorUnderTest.add(arg1, arg2);

		// Assert
		//assertEquals(expectResult, actualResult);
		
		// utilisation de AssertJ
		assertThat(actualResult).isEqualTo(expectResult);
	}
	
	@AfterEach
	public void AppelApresChaqueTest() {
		System.out.println("Appel après chaque test");
		caculatorUnderTest = null;
	}

	@AfterAll
	static public void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

}
