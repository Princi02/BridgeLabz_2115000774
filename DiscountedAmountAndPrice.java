public class DiscountedAmountAndPrice {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        int discount = (fee*10)/100;
        int discountedPrice = fee - discount;
        System.out.print("The discount amount is INR " + discount + " and final discountd fee is INR " + discountedPrice);

    }
}
