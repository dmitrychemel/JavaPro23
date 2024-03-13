package homework_2024_02_21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockExample {


    @Mock
    List<String> mockList;

    @Test
    public void testMockList() {
        String str = "JAVA";
        mockList.add(str);

        Mockito.verify(mockList).add(str);
        Assertions.assertEquals(0, mockList.size());
    }
}