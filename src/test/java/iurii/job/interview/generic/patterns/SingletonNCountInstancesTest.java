package iurii.job.interview.generic.patterns;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonNCountInstancesTest {

    @Test
    public void testNumberOfInstances() {
        SingletonNCountInstances firstInstance = SingletonNCountInstances.nextInstance();
        SingletonNCountInstances secondInstance = SingletonNCountInstances.nextInstance();
        SingletonNCountInstances thirdInstance = SingletonNCountInstances.nextInstance();

        assertThat(firstInstance).isEqualByComparingTo(SingletonNCountInstances.ONE);
        assertThat(secondInstance).isEqualByComparingTo(SingletonNCountInstances.TWO);
        assertThat(thirdInstance).isEqualByComparingTo(SingletonNCountInstances.THREE);
    }
}
