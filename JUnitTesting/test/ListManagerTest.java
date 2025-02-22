import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    ListManager listManager;
    List<Integer> list;

    @BeforeEach
    public void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        assertEquals(2, list.size());
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    public void testRemoveElement() {
        list.add(10);
        list.add(20);
        listManager.removeElement(list, 10);
        assertEquals(1, list.size());
        assertFalse(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    public void testGetSize() {
        assertEquals(0, listManager.getSize(list));
        listManager.addElement(list, 10);
        assertEquals(1, listManager.getSize(list));
        listManager.removeElement(list, 10);
        assertEquals(0, listManager.getSize(list));
    }

    @Test
    public void testNullListHandling() {
        assertEquals(0, listManager.getSize(null));
        listManager.addElement(null, 10); 
        listManager.removeElement(null, 10); 
    }
}
