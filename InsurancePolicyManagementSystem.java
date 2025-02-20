import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsurancePolicyManagementSystem {
    static class InsurancePolicy implements Comparable<InsurancePolicy> {
        String policyNumber;
        String policyholderName;
        Date expiryDate;
        String coverageType;
        double premiumAmount;
        
        public InsurancePolicy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) throws ParseException {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDate);
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        @Override
        public int compareTo(InsurancePolicy other) {
            return this.expiryDate.compareTo(other.expiryDate);
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InsurancePolicy that = (InsurancePolicy) o;
            return Objects.equals(policyNumber, that.policyNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        @Override
        public String toString() {
            return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate) + ", Type: " + coverageType + ", Premium: " + premiumAmount;
        }
    }

    public static void main(String[] args) throws ParseException {
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();
        
        InsurancePolicy p1 = new InsurancePolicy("P001", "John Doe", "2025-08-15", "Health", 5000);
        InsurancePolicy p2 = new InsurancePolicy("P002", "Jane Smith", "2025-07-10", "Auto", 3000);
        InsurancePolicy p3 = new InsurancePolicy("P003", "Alice Brown", "2025-06-05", "Home", 4500);
        InsurancePolicy p4 = new InsurancePolicy("P004", "Bob White", "2025-05-20", "Health", 2500);
        InsurancePolicy p5 = new InsurancePolicy("P001", "John Doe", "2025-08-15", "Health", 5000); // Duplicate
        
        Collections.addAll(hashSet, p1, p2, p3, p4, p5);
        Collections.addAll(linkedHashSet, p1, p2, p3, p4, p5);
        Collections.addAll(treeSet, p1, p2, p3, p4, p5);
        
        System.out.println("HashSet:");
        for (InsurancePolicy policy : hashSet) {
            System.out.println(policy);
        }
        
        System.out.println("\nLinkedHashSet:");
        for (InsurancePolicy policy : linkedHashSet) {
            System.out.println(policy);
        }
        
        System.out.println("\nTreeSet:");
        for (InsurancePolicy policy : treeSet) {
            System.out.println(policy);
        }

        // Performance Comparison
        System.out.println("\nPerformance Comparison:");
        performanceComparison(hashSet, "HashSet");
        performanceComparison(linkedHashSet, "LinkedHashSet");
        performanceComparison(treeSet, "TreeSet");
    }

    public static void performanceComparison(Set<InsurancePolicy> set, String setType) throws ParseException {
        System.out.println("\nTesting " + setType + "...");
        long startTime, endTime;

        InsurancePolicy testPolicy = new InsurancePolicy("P006", "Test User", "2026-01-01", "Health", 2000);

        // Adding
        startTime = System.nanoTime();
        set.add(testPolicy);
        endTime = System.nanoTime();
        System.out.println("Add operation: " + (endTime - startTime) + " ns");

        // Searching
        startTime = System.nanoTime();
        boolean contains = set.contains(testPolicy);
        endTime = System.nanoTime();
        System.out.println("Search operation: " + (endTime - startTime) + " ns (Found: " + contains + ")");

        // Removing
        startTime = System.nanoTime();
        set.remove(testPolicy);
        endTime = System.nanoTime();
        System.out.println("Remove operation: " + (endTime - startTime) + " ns");
    }
}
