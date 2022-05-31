package homeWorkLesson3;

public class Fruit {
    private String name;
    private float weight;
    private int amount;

    public Fruit(String name, float weight, int amount) {
        this.name = name;
        this.weight = weight;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", amount=" + amount +
                '}';
    }

    public void addFruit(int count){
        amount = amount + count;
        System.out.println("В коробку с фруктами (" + getName() + ") добавлено " + count + " шт.");
        }

    public float getBoxWeight(){
        return getAmount() * getWeight();
    }

    public void info(){
        System.out.println("Вес коробки с фруктами ("+ getName() + ") составляет:");
    }
}