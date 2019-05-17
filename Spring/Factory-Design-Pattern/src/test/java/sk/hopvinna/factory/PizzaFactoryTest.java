package sk.hopvinna.factory;

import org.junit.Test;

import sk.hopvinna.factory.BasePizzaFactory;
import sk.hopvinna.factory.Pizza;
import sk.hopvinna.factory.PizzaFactory;

public class PizzaFactoryTest {
    @Test
    public void testMakePizzas(){
        BasePizzaFactory pizzaFactory = new PizzaFactory();
        Pizza cheesePizza = pizzaFactory.createPizza("cheese");
        Pizza veggiePizza = pizzaFactory.createPizza("veggie");
    }
}
