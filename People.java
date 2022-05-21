package homeWorkLesson1;

public class People {
    private String name;
    private String female;
    private int age;
    private float swimmingSpeed;
    private float maxDistance;

    public People(String name, String female, int age, float swimmingSpeed, float maxDistance) {
        this.name = name;
        this.female = female;
        this.age = age;
        this.swimmingSpeed = swimmingSpeed;
        this.maxDistance = maxDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(float swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public float getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(float maxDistance) {
        this.maxDistance = maxDistance;
    }
}
