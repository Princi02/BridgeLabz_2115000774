class LegacyAPI {
    
    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature. Avoid using this method!");
    }
    
    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature();
        api.newFeature();
    }
}
