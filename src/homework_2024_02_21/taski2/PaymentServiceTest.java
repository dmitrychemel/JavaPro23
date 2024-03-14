package homework_2024_02_21.taski2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {


    @Mock
    SimpleNotificationService notificationService;

    @Mock
    SimpleTransactionRepository transactionRepository;

    PaymentService paymentService;

    double originalAmount = 10.0;

    double newAmount = 20.0;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService(notificationService, transactionRepository);
    }

    @Test
    void makePaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true);
        Assertions.assertTrue(paymentService.makePayment(Mockito.anyDouble()));
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());

    }

    @Test
    void makePaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(false);
        Assertions.assertFalse(paymentService.makePayment(Mockito.anyDouble()));
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void refundPaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);
        Assertions.assertTrue(paymentService.refundPayment(Mockito.anyDouble()));
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void refundPaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(false);
        Assertions.assertFalse(paymentService.refundPayment(Mockito.anyDouble()));
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void adjustPaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true);

        paymentService.adjustPayment(originalAmount, newAmount);

        Mockito.verify(transactionRepository).processTransaction(-originalAmount);
        Mockito.verify(transactionRepository).processTransaction(newAmount);
        Mockito.verify(notificationService, Mockito.times(2)).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void adjustPaymentPositiveAndNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(-originalAmount)).thenReturn(true);
        Mockito.when(transactionRepository.processTransaction(newAmount)).thenReturn(false);

        paymentService.adjustPayment(originalAmount, newAmount);

        Mockito.verify(transactionRepository).processTransaction(-originalAmount);
        Mockito.verify(transactionRepository).processTransaction(newAmount);
        Mockito.verify(notificationService, Mockito.times(2)).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void adjustPaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(-originalAmount)).thenReturn(false);

        paymentService.adjustPayment(originalAmount, newAmount);

        Mockito.verify(transactionRepository).processTransaction(-originalAmount);
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }
    @Test
    void verifyPaymentTest() {
        boolean result = paymentService.verifyPayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
        Assertions.assertTrue(result);
    }

    @Test
    void cancelPaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);
        paymentService.cancelPayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void cancelPaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(false);
        paymentService.cancelPayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }
}