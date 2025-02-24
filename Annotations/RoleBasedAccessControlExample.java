import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    private String currentUserRole;

    public AccessControl(String currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed!");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed!");
    }

    public void executeMethod(String methodName) throws Exception {
        Method method = this.getClass().getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(currentUserRole)) {
                method.invoke(this);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}

public class RoleBasedAccessControlExample {
    public static void main(String[] args) throws Exception {
        AccessControl adminControl = new AccessControl("ADMIN");
        adminControl.executeMethod("adminTask");
        adminControl.executeMethod("userTask");

        AccessControl userControl = new AccessControl("USER");
        userControl.executeMethod("userTask");
        userControl.executeMethod("adminTask");
    }
}
