package homework_2024_02_21.taski2;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleTransactionRepositoryTest {
    @Mock
    Transaction transaction;

    SimpleTransactionRepository service = new SimpleTransactionRepository();

    @Test
    void processTransaction() {
        boolean result = service.processTransaction(10.0);
        assertTrue(result);
        service.getAllTransactions().add(transaction);
        assertEquals(1, service.getAllTransactions().size());
    }

    @Test
    void getAllTransactions() {
    }
}