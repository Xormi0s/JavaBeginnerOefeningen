package dummy.factories;
import model.Course;
import dummy.DummyCourse;
import dummy.RandomGenerator;

public class CourseFactory {
    private static String id;
    private static String subject;
    private static int courseNumber;
    private static String title;
    private static int credits;
    public static Course createDummyCourse(int index) {
        generateDummyData(index);
        return new Course(id, subject,courseNumber,title, credits);
    }

    public static Course createCourse(int index, int courseID){
        generateDummyData(index);
        id = String.valueOf(++courseID);
        return new Course(id, subject,courseNumber,title, credits);
    }
    public static String getCourseId() {
        String courseID = ""+getCourseNumber();
        return courseID;
    }

    public static String getCourseId(int i) {
        String courseID = ""+i;
        return courseID;
    }

    public static int getCourseNumber(){
        return RandomGenerator.random.nextInt(DummyCourse.MAX_COURSES);
    }

    private static void generateDummyData(int i){
        id = DummyCourse.ID[i];
        subject = DummyCourse.SUBJECT[i];
        courseNumber = getCourseNumber();
        title = DummyCourse.TITLE[i];
        credits = 1+RandomGenerator.random.nextInt(7);
    }
}
