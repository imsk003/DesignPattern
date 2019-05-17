package sk.hopvinna.factory;

public class VeggiePizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for veggie pizza.");
    }
}
