import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsurancePolicyManagementSystem2 {
    static class InsurancePolicy {
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
        public String toString() {
            return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate) + ", Type: " + coverageType + ", Premium: " + premiumAmount;
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String, InsurancePolicy> hashMap = new HashMap<>();
        Map<String, InsurancePolicy> linkedHashMap = new LinkedHashMap<>();
        Map<Date, InsurancePolicy> treeMap = new TreeMap<>();

        InsurancePolicy p1 = new InsurancePolicy("P001", "John Doe", "2025-08-15", "Health", 5000);
        InsurancePolicy p2 = new InsurancePolicy("P002", "Jane Smith", "2025-07-10", "Auto", 3000);
        InsurancePolicy p3 = new InsurancePolicy("P003", "Alice Brown", "2025-06-05", "Home", 4500);
        InsurancePolicy p4 = new InsurancePolicy("P004", "Bob White", "2025-05-20", "Health", 2500);
        InsurancePolicy p5 = new InsurancePolicy("P005", "John Doe", "2025-04-10", "Health", 5000);

        hashMap.put(p1.policyNumber, p1);
        hashMap.put(p2.policyNumber, p2);
        hashMap.put(p3.policyNumber, p3);
        hashMap.put(p4.policyNumber, p4);
        hashMap.put(p5.policyNumber, p5);

        linkedHashMap.putAll(hashMap);
        for (InsurancePolicy policy : hashMap.values()) {
            treeMap.put(policy.expiryDate, policy);
        }

        System.out.println("Retrieve by Policy Number (P002): ");
        System.out.println(hashMap.get("P002"));

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        listExpiringPolicies(treeMap);

        System.out.println("\nPolicies for Policyholder 'John Doe':");
        listPoliciesByHolder(hashMap, "John Doe");

        System.out.println("\nRemoving Expired Policies...");
        removeExpiredPolicies(treeMap, hashMap);
        System.out.println("Policies after removal:");
        hashMap.values().forEach(System.out::println);
    }

    public static void listExpiringPolicies(Map<Date, InsurancePolicy> treeMap) {
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date futureDate = cal.getTime();

        for (Map.Entry<Date, InsurancePolicy> entry : treeMap.entrySet()) {
            if (entry.getKey().after(currentDate) && entry.getKey().before(futureDate)) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static void listPoliciesByHolder(Map<String, InsurancePolicy> map, String policyholderName) {
        for (InsurancePolicy policy : map.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                System.out.println(policy);
            }
        }
    }

    public static void removeExpiredPolicies(Map<Date, InsurancePolicy> treeMap, Map<String, InsurancePolicy> hashMap) {
        Date currentDate = new Date();
        Iterator<Map.Entry<Date, InsurancePolicy>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Date, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().before(currentDate)) {
                hashMap.remove(entry.getValue().policyNumber);
                iterator.remove();
            }
        }
    }
}

