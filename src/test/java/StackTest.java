import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import ht4.factory.StackFactory;
import ht4.stack.IStack;

public class StackTest {
    private IStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = StackFactory.createStack("arraylist"); 

    }

    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(30);
        assertEquals(30, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(40);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        stack.push(50);
        stack.push(60);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPopOnEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }
}
