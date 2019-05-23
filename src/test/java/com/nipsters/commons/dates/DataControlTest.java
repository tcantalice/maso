package com.nipsters.commons.dates;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class DataControlTest {
	@Test
	public void testarData() {
		assertEquals(LocalDate.of(2019, Month.MAY, 11), DataControl.formatData("11/05/2019"));
	}
	
	@Test
	public void testarDataComTraco() {
		assertEquals(LocalDate.of(2019, Month.MAY, 11), DataControl.formatData("11-05-2019"));
	}
	
	@Test
	public void testarDataComPonto() {
		assertEquals(LocalDate.of(2019, Month.MAY, 11), DataControl.formatData("11.05.2019"));
	}

	
	@Test
	public void testarExcecao() {
		try {
			DataControl.formatData("10052019");
		}catch(IllegalArgumentException e) {
			System.out.println("Entrada invalida!");
		}
	}
	
	@Test
	public void testarComparador() {
		assertFalse(DataControl.compareByinterval(DataControl.formatData("10/06/2019"), 7));
		assertFalse(DataControl.compareByinterval(DataControl.formatData("10/06/2019"), 15));
		assertTrue(DataControl.compareByinterval(DataControl.formatData("10/06/2019"), 31));
	}
	
	@Test
	public void testeIdade() {
		System.out.println(DataControl.birthdayDate(DataControl.formatData("17/07/2000")));
		System.out.println(DataControl.birthdayDate(DataControl.formatData("16/03/1997")));
		System.out.println(DataControl.birthdayDate(DataControl.formatData("01/04/2000")));
	}
}
