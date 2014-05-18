package spockintro.commons

import spock.lang.Specification
import spock.lang.Unroll

import static java.math.MathContext.DECIMAL32

/**
 * @author bartosz walacik
 */
class DataDrivenSpockTest extends Specification {

    /**
     * KEY points:
     * - provide test data using table style or streams style, you pick
     */
    @Unroll
    def """should round #givenValue.class.simpleName #givenValue
           to #expectedValue with scale #scale"""() {

        when:
        def result = Money.round(givenValue, scale)

        then:
        result == expectedValue

        where:
        givenValue                       | scale || expectedValue
        0.339d                           | 2     || 0.34
        0.22d                            | 2     || 0.22
        0.1d                             | 1     || 0.1
        new BigDecimal(2.333, DECIMAL32) | 2     || 2.33
    }

    /**
     * KEY points:
     * - use @Unroll to obtain bunch of tests with extremely readable names
     */
    @Unroll
    def "should round #givenValue.class.simpleName #givenValue to #expectedValue"() {

        when:
        def result = Money.round2(givenValue)

        then:
        result == expectedValue

        where:
        givenValue <<    [0.339d, 0.22d, 0.1d, new BigDecimal (2.333,DECIMAL32)]
        expectedValue << [0.34, 0.22, 0.1, 2.33]
    }

    @Unroll
    def "should round #givenValue.class.simpleName #givenValue to #expectedValue 2"() {

        when:
        def result = Money.round2(givenValue)

        then:
        result == expectedValue
        def sad = ["1", "s"]
        where:
        [givenValue, expectedValue] << [[0.339d, 0.34],  [0.22d, 0.22],  [0.1d, 0.1],  [new BigDecimal(2.333,DECIMAL32), 2.33]]
    }
}
