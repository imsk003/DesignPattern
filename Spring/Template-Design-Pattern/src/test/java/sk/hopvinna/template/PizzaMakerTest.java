package sk.hopvinna.template;

import org.junit.Test;

import sk.hopvinna.template.InHouseAssortedPizzaMaker;
import sk.hopvinna.template.NonVegPizzaMaker;
import sk.hopvinna.template.PizzaMaker;
import sk.hopvinna.template.VegPizzaMaker;

public class PizzaMakerTest {

    @Test
    public void testMakePizza() throws Exception {
        System.out.println("-----Making Veg Pizza-----");
        PizzaMaker vegPizzaMaker = new VegPizzaMaker();
        vegPizzaMaker.makePizza();

        System.out.println("-----Making Non Veg Pizza-----");
        PizzaMaker nonVegPizzaMaker = new NonVegPizzaMaker();
        nonVegPizzaMaker.makePizza();

        System.out.println("-----Making In-House Assorted Pizza-----");
        PizzaMaker inHouseAssortedPizzaMaker = new InHouseAssortedPizzaMaker();
        inHouseAssortedPizzaMaker.makePizza();


    }
}