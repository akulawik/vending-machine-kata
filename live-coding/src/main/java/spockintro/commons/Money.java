package spockintro.commons;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * immutable
 */
public class Money {

    private final BigDecimal value;

    public Money(BigDecimal value) {
        checkArgument(value != null);
        this.value = round2(value);
    }

    @Override
    public String toString() {
        return "Money("+value+")";
    }

    public String format() {
        return value.toString();
    }

    /**
     * @return not null
     */
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Money)) {
            return false;
        }

        return hasSameValue((Money) object);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public static BigDecimal round2(BigDecimal value) {
        return round(value, 2);
    }


    public static BigDecimal round(BigDecimal value, int scale) {
        Preconditions.checkArgument(value != null, "Value cannot be null");

        return value.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    private boolean hasSameValue(Money that) {
        return value.compareTo(that.value) == 0;
    }
}
