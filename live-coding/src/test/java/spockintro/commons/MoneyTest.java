package spockintro.commons;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MoneyTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new BigDecimal(0.339) , 2 , new BigDecimal(0.34).setScale(2, RoundingMode.HALF_UP)},
                { new BigDecimal(0.22 ) , 2 , new BigDecimal(0.22).setScale(2, RoundingMode.HALF_UP)},
                { new BigDecimal(0.2  ) , 1 , new BigDecimal(0.1 ).setScale(1, RoundingMode.HALF_UP)},
                { new BigDecimal(2.333) , 2 , new BigDecimal(2.33).setScale(2, RoundingMode.HALF_UP)}
        });
    }

    private BigDecimal givenValue;
    private int scale;
    private BigDecimal expectedValue;

    public MoneyTest(BigDecimal givenValue, int scale, BigDecimal expectedValue) {
        this.givenValue = givenValue;
        this.scale = scale;
        this.expectedValue = expectedValue;
    }

    @Test
    public void shouldRoundMoney() {

        //when
        BigDecimal result = Money.round(givenValue, scale);

        //then
        Assert.assertEquals(expectedValue, result);
    }
}
