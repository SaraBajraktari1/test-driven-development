import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountCalculatorTest {

    private static final double DELTA = 0.0001;
    private DiscountCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new DiscountCalculator();
    }

    @Test
    void shumaZeroKthenZero() {
        assertEquals(0, calculator.calculateDiscount(0, true), DELTA);
        assertEquals(0, calculator.calculateDiscount(0, false), DELTA);
    }

    @Test
    void shumaNegativeKthenZero() {
        assertEquals(0, calculator.calculateDiscount(-50, true), DELTA);
        assertEquals(0, calculator.calculateDiscount(-50, false), DELTA);
    }

        @Test
    void premiumMeShume100Merr20Perqind() {
        assertEquals(20, calculator.calculateDiscount(100, true), DELTA);
    }

    @Test
    void premiumMeShumeMbi100Merr20Perqind() {
        assertEquals(100, calculator.calculateDiscount(500, true), DELTA);
    }

        @Test
    void premiumMeShumeNen100Merr10Perqind() {
        assertEquals(5, calculator.calculateDiscount(50, true), DELTA);
        assertEquals(9.9, calculator.calculateDiscount(99, true), DELTA);
    }

        @Test
    void joPremiumMeShume200OseMeShumeMerr5Perqind() {
        assertEquals(10, calculator.calculateDiscount(200, false), DELTA);
        assertEquals(50, calculator.calculateDiscount(1000, false), DELTA);
    }

        @Test
    void joPremiumMeShumeNen200NukKaZbritje() {
        assertEquals(0, calculator.calculateDiscount(199, false), DELTA);
        assertEquals(0, calculator.calculateDiscount(100, false), DELTA);
    }
}