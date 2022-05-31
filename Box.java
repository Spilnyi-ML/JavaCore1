package homeWorkLesson3;

public class Box<T extends Fruit> {
    private T box;

    public Box(T box) {
        this.box = box;
    }

    public T getBox() {
        return box;
    }

    public void setBox(T box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "Box{" +
                "box=" + box +
                '}';
    }

    public boolean compare(Box<?> boxToCompare){
       return getBox().getBoxWeight() == boxToCompare.getBox().getBoxWeight();
    }

    public void pourOverFruit(Box<?> box){
        System.out.println("Коробка №1:");
        System.out.println(getBox().getName() + " " + getBox().getAmount());
        System.out.println("");
        System.out.println("Коробка №2:");
        System.out.println(box.getBox().getName() + " " + box.getBox().getAmount());
        String tempName;
        int tempAmount;
        tempName = getBox().getName();
        tempAmount = getBox().getAmount();
        getBox().setName(box.getBox().getName());
        getBox().setAmount(box.getBox().getAmount());
        box.getBox().setName(tempName);
        box.getBox().setAmount(tempAmount);
        System.out.println("------------------------------------------------");
        System.out.println("Коробка №1:");
        System.out.println(getBox().getName() + " " + getBox().getAmount());
        System.out.println("");
        System.out.println("Коробка №2:");
        System.out.println(box.getBox().getName() + " " + box.getBox().getAmount());
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new Apple("Apple",1.0f, 23));
        Box<Orange> orangeBox = new Box<>(new Orange("Orange",1.5f, 14));
        System.out.println("------------------------------------------------");
        appleBox.getBox().info();
        System.out.println(appleBox.getBox().getBoxWeight());
        orangeBox.getBox().info();
        System.out.println(orangeBox.getBox().getBoxWeight());
        appleBox.getBox().addFruit(19);
        orangeBox.getBox().addFruit(14);
        appleBox.getBox().info();
        System.out.println(appleBox.getBox().getBoxWeight());
        orangeBox.getBox().info();
        System.out.println(orangeBox.getBox().getBoxWeight());
        System.out.println("------------------------------------------------");
        System.out.println(appleBox.compare(orangeBox));
        System.out.println("------------------------------------------------");
        System.out.println();
        appleBox.pourOverFruit(orangeBox);
        orangeBox.pourOverFruit(appleBox);
    }
}