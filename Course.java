package homeWorkLesson1;

public class Course {
    private float length;

    public Course(float length) {
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getTimeToOvercome(CanSwim swimming){
        return swimming.swim(this);
    }
}

