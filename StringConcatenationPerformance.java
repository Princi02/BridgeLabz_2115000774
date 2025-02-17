public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        
        for (int size : sizes) {
            System.out.println("Testing with " + size + " iterations");
            
            long start, end;
            
            // Using String
            start = System.currentTimeMillis();
            String str = "";
            for (int i = 0; i < size; i++) {
                str += "a";
            }
            end = System.currentTimeMillis();
            System.out.println("String: " + (end - start) + " ms");
            
            // Using StringBuilder
            start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append("a");
            }
            end = System.currentTimeMillis();
            System.out.println("StringBuilder: " + (end - start) + " ms");
            
            // Using StringBuffer
            start = System.currentTimeMillis();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sbf.append("a");
            }
            end = System.currentTimeMillis();
            System.out.println("StringBuffer: " + (end - start) + " ms");
            
            System.out.println();
        }
    }
}
