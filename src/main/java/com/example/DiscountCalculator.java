public class DiscountCalculator {

    public double calculateDiscount(double amount, boolean isPremium) {
        if (amount <= 0) {
            return 0;
        }
        if (isPremium && amount >= 100) {
            return amount * 0.20;
        }
        if (isPremium) {
            return amount * 0.10;
        }
        if (amount >= 200) {
            return amount * 0.05;
        }
        return 0;
    }
}