class Food implements Eatable {
    @Override
    public String toString() {
        return "Food";
    }
}

class Chicken extends Food {
    @Override
    public String toString() {
        return "Chicken";
    }
}

class Pizza extends Food {
    @Override
    public String toString() {
        return "Pizza";
    }
}

class Pencil {
    @Override
    public String toString() {
        return "Pencil";
    }
}

interface Eatable {}

public class GenericsEx2 {

    public static void main(String[] args) {
        FoodBox<Food> foodBox = new FoodBox<>();
        FoodBox<Chicken> chickenFoodBox = new FoodBox<>();
        FoodBox<Pizza> pizzaFoodBox = new FoodBox<>();
//        FoodBox<Toy> toyBox = new FoodBox<Toy>(); Toy는 Food의 자손 타입 아니므로 타입 매개변수로 올 수 없다.

        foodBox.add(new Food());
        foodBox.add(new Chicken());
        foodBox.add(new Pizza());

        chickenFoodBox.add(new Chicken());
//        chickenFoodBox.add(new Pizza());

        Food food = new Chicken();
        chickenFoodBox.add((Chicken)food);
        // 부모에서 자식으로의 형 변환은 자동타입변환이 이루어진 인스턴스만 가능?

        pizzaFoodBox.add(new Pizza());
//        pizzaFoodBox.add((Pizza) new Food());

        System.out.println(foodBox);
        System.out.println(chickenFoodBox);
        System.out.println(pizzaFoodBox);
    }

}

class FoodBox<T extends Food & Eatable> extends Box<T> {

}