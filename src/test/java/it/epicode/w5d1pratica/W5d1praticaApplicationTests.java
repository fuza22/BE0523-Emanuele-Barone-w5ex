package it.epicode.w5d1pratica;

import it.epicode.w5d1pratica.bean.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class W5d1praticaApplicationTests {

	static AnnotationConfigApplicationContext ctx;
	@Autowired
	private W5d1praticaApplication controller;

	@BeforeAll
	static void accediAlContesto(){

		ctx = new AnnotationConfigApplicationContext(W5d1praticaApplication.class);

	}

	@Test
	void controlloToppingMozzarella(){

		Topping mozzarella = ctx.getBean("mozzarella", Topping.class);
		assertThat(mozzarella).isNotNull();

	}

	@Test
	void controlloTipologiaBean(){

		assertSame("ordine1", "mozzarella");

	}


	@Test
	void controlloNumeroCoperti(){

		Ordine ordine1 = ctx.getBean("ordine1", Ordine.class);
		Assertions.assertEquals(5,ordine1.getNumeroCoperti());

	}

	@Test
	void calcolaCaloriePizzaMargheritaSalame(){

		Pizza pizzaMargheritaSalame = ctx.getBean("margheritaSalame", Pizza.class);
		Assertions.assertEquals(400, pizzaMargheritaSalame.getCalorie());

	}

	@Test
	void controlloCostoCoperto(){

		Ordine ordine1 = ctx.getBean("ordine1", Ordine.class);
		Assertions.assertEquals(2, ordine1.getCostoCoperto());

	}

	@Test
	void verificaStatoOrdine(){

		Ordine ordine1 = ctx.getBean("ordine1", Ordine.class);
		Assertions.assertEquals(StatoOrdine.IN_CORSO, ordine1.getStatoOrdine());

	}

	@Test
	void controlloPizzaMargheritaSalame(){

		Pizza pizzaMargheritaSalame = ctx.getBean("margheritaSalame", Pizza.class);
		int calorie = pizzaMargheritaSalame.getCalorie();
		double prezzo = pizzaMargheritaSalame.getPrezzo();
		assertAll(

				() -> assertEquals(400, pizzaMargheritaSalame.getCalorie()),
				() -> assertEquals(5, pizzaMargheritaSalame.getPrezzo())

		);

	}

	@Test
	void controlloToppingMenu(){

		Menu menu = ctx.getBean("menu", Menu.class);
		Topping mozzarella = ctx.getBean("mozzarella", Topping.class);
		Topping pomodoro = ctx.getBean("pomodoro", Topping.class);
		Topping prosciutto = ctx.getBean("prosciutto", Topping.class);
		Topping salame = ctx.getBean("salame", Topping.class);
		Assertions.assertAll(

				() -> assertTrue(menu.getToppings().contains(mozzarella)),
				() -> assertTrue(menu.getToppings().contains(pomodoro)),
				() -> assertTrue(menu.getToppings().contains(prosciutto)),
				() -> assertTrue(menu.getToppings().contains(prosciutto))

		);

	}


	@ParameterizedTest
	@ValueSource(ints = {200, 250})
	void verificaCalorieProsciutto(int calorie){


		Topping prosciutto = ctx.getBean("prosciutto", Topping.class);
		Assertions.assertEquals(calorie, prosciutto.getCalorie());


	}


	@AfterAll
	static void chiudiContesto(){

		ctx.close();

	}

}
