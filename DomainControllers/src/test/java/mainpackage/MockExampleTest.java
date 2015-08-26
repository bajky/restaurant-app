package mainpackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * todo how to combine mock and spring tests?
 * @author David david.bajko@senacor.com
 */
@RunWith(MockitoJUnitRunner.class)
public class MockExampleTest {

    @Mock
    private Food foodMock;

    // @InjectMocks

    @Test
    public void mockTest1(){
        Food food = mock(Food.class);
        when(food.isFresh()).thenReturn(false, true);
        assertFalse(food.isFresh());
        assertTrue(food.isFresh());

        verify(food, times(2)).isFresh();
        reset(food);
    }

    @Test
    public void mockTest2(){
        when(foodMock.isFresh()).thenReturn(false, true);
        assertFalse(foodMock.isFresh());
        assertTrue(foodMock.isFresh());

        verify(foodMock, times(2)).isFresh();
    }
}
