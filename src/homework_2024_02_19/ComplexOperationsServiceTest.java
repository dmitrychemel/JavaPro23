package homework_2024_02_19;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ComplexOperationsServiceTest {
    private final ComplexOperationsService service = new ComplexOperationsService();


    @ParameterizedTest
    @CsvSource({
            "weak, false",
            "strongPassword1@, true",
            "noDigit!, false",
            "NoSpecialChar1, false"
    })
    void validatePasswordStrengthTest(String password, boolean isValid) {
        if(!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void processText(String text) {
        if(text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "one,two,three",
            "10,,20",
            "5.5,6.5"
    })
    void sumOfNumbersInString(String numbers) {
        if(numbers.matches(".*[a-zA-Z]+.*") | numbers.matches(",,")) {
            assertThrows(IllegalArgumentException.class, () -> service.sumOfNumbersInString(numbers));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://valid.com", "https://valid.com", "ftp://invalid.com", "justtext"})
    void validateUrlFormat(String url) {
        if(!url.startsWith("http")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(url));
        }
    }

    public static Stream<Arguments> emailListProvider() {
        return  Stream.of(
                Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
                Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("emailListProvider")
    void checkEmailListConsistency(List<String> emails, boolean isValid) {
        if(!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "weak, false",
            "AlilA, true",
            "Madam1, false",
            "NoSpecialChar1, false"
    })
    void checkStringPalindrome(String word, boolean isValid) {
        if(!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkStringPalindrome(word));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"AB1234562", "AcB123456", "A2B123456", "B123456", "AB123456"})
    void validateIdentificationNumber(String id) {
        if(id.matches("^(?=(?:.*[a-zA-Z]){3}|.{9,}|.*[^a-zA-Z0-9]).*$")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateIdentificationNumber(id));
        }
    }

    public static Stream<Arguments> numbersListProvider() {
        return  Stream.of(
                Arguments.of(Arrays.asList(1, 2, 4, 5, 6, 6, 8, 10), 10, true),
                Arguments.of(Arrays.asList(5, 6, 7, 10, 20), 100, false)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersListProvider")
    void checkSumOfListAgainstThreshold(List<Integer> numbers, int threshold, boolean isValid) {
        if(!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkSumOfListAgainstThreshold(numbers, threshold));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.168.1.1A", "14322.168.1.1", "192.168.1.1"} )
    void validateIPAddress(String ip) {
        if(ip.matches("[^0-9.]") || ip.length() < 11 || ip.length() > 12) {
            assertThrows(IllegalArgumentException.class, () -> service.validateIPAddress(ip));
        }
    }

    public static Stream<Arguments> stringsListProvider() {
        return  Stream.of(
                Arguments.of(Arrays.asList("hello", "world", "Java"), true),
                Arguments.of(Arrays.asList("hello", "world", "hello"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("stringsListProvider")
    void ensureNoDuplicateEntries(List<String> list, boolean isValid) {
        if(!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.ensureNoDuplicateEntries(list));
        }
    }
}