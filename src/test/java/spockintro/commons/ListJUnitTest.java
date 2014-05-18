package spockintro.commons;

import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author bartosz walacik
 */
public class ListJUnitTest {

    @Test
    public void shouldAddAllItemsFromOneListToAnother() {
        //given:
        List<String> baseList = Lists.newArrayList("one", "two");
        List<String> addMe = Lists.newArrayList("three", "four");

        //when:
        baseList.addAll(addMe);

        //then:
        Assert.assertEquals(Arrays.asList("one", "two", "three", "four"),baseList);
    }
}
