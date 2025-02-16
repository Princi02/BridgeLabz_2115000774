public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String str = "hello";

        StringBuffer sbf = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbf.append(str);
        }
        long endTime = System.nanoTime();
        long timeStringBuffer = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + timeStringBuffer / 1_000_000 + " ms");

        StringBuilder sb = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        endTime = System.nanoTime();
        long timeStringBuilder = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + timeStringBuilder / 1_000_000 + " ms");

        if (timeStringBuffer > timeStringBuilder) {
            System.out.println("StringBuilder is faster by " + (timeStringBuffer - timeStringBuilder) / 1_000_000 + " ms");
        } else {
            System.out.println("StringBuffer is faster by " + (timeStringBuilder - timeStringBuffer) / 1_000_000 + " ms");
        }
    }
}
