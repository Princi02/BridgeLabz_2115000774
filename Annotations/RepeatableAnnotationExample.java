import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "Null pointer exception on save")
    @BugReport(description = "Array index out of bounds on load")
    public void process() {
        System.out.println("Processing data...");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("process");
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
            for (BugReport bug : bugReports) {
                System.out.println("Bug: " + bug.description());
            }
        }
    }
}
