
import org.example.ListComparator;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListComparatorTest {

    @Test
    void testCompareLists() {
        List<Double> list1 = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> list2 = Arrays.asList(4.0, 5.0, 6.0);

        assertEquals("Второй список имеет большее среднее значение", ListComparator.compareLists(list1, list2));
    }

    @Test
    void testEqualAverage() {
        List<Double> list1 = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> list2 = Arrays.asList(3.0, 2.0, 1.0);

        assertEquals("Средние значения равны", ListComparator.compareLists(list1, list2));
    }

    // Добавьте еще тесты для различных сценариев использования
}
