package homeWorkLesson1;

public class Team extends People implements CanSwim{
    private String teamName = "Lucky";

    public Team(String name, String female, int age, float swimmingSpeed, float maxDistance) {
        super(name, female, age, swimmingSpeed, maxDistance);
    }

    public float swim(Course course){
        System.out.println("Имя: " + getName() + ".  Фамилия: " + getFemale() +
                ".  Возраст: " + getAge() + ".  Скорость плавания: " + getSwimmingSpeed() + " м/с." +
                " Максимальная дистанция: " + getMaxDistance() + " м.");
        float timeToOvercome =course.getLength() / getSwimmingSpeed();
        if (getMaxDistance() > course.getLength()){
        System.out.println("Участник проплыл дистанцию!");
        System.out.println("Время преодоления дистанции: " + timeToOvercome + " с.");
        }
        else System.out.println("Участник не проплыл дистанцию!");
        System.out.println();
        return timeToOvercome;
    }

    public void result(Course course){
        if (getMaxDistance() > course.getLength()){
            System.out.println("Участник проплыл все 3 дистанции!");
        }
    }

    public void teamName(){
        System.out.println("Название команды участников: <" + teamName + ">");
        System.out.println(" ");
    }
}
