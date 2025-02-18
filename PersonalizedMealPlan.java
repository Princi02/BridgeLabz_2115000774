import java.util.ArrayList;
import java.util.List;

// MealPlan interface representing different types of meal plans
interface MealPlan {
    String getMealDetails();
}

// Different meal plan implementations
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: Grilled vegetables with quinoa";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegan Meal: Tofu stir-fry with brown rice";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Keto Meal: Grilled salmon with avocado salad";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "High-Protein Meal: Chicken breast with steamed broccoli";
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    @Override
    public String toString() {
        return meal.getMealDetails();
    }
}

// Meal Plan Generator
class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();

    public void addMeal(Meal<? extends MealPlan> meal) {
        mealPlans.add(meal);
    }

    public void displayMealPlans() {
        for (Meal<? extends MealPlan> meal : mealPlans) {
            System.out.println(meal);
        }
    }

    // Generic method to validate and generate meal plans
    public static <T extends MealPlan> void generatePersonalizedMeal(T meal) {
        System.out.println("Generating Personalized Meal Plan: " + meal.getMealDetails());
    }
}

// Main class to test the implementation
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarian = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> highProtein = new Meal<>(new HighProteinMeal());

        MealPlanGenerator generator = new MealPlanGenerator();
        generator.addMeal(vegetarian);
        generator.addMeal(vegan);
        generator.addMeal(keto);
        generator.addMeal(highProtein);

        System.out.println("Available Meal Plans:");
        generator.displayMealPlans();

        System.out.println("\nGenerating Personalized Meal:");
        MealPlanGenerator.generatePersonalizedMeal(new VeganMeal());
    }
}
