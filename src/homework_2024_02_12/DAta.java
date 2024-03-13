package homework_2024_02_12;

import java.util.List;

// Нарушение CODE SMELLS:
public class DAta {
    public double calculateAverage(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / numbers.size();

        double variance = 0;
        for (double num : numbers) {
            variance += Math.pow(num - average, 2);
        }
        double standardDeviation = Math.sqrt(variance / numbers.size());

        return standardDeviation;
    }

    public double calculateAverageFIX(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public double StandardDeviation(List<Double> numbers) {
        double variance = 0;
        double average = calculateAverageFIX(numbers);
        for (double num : numbers) {
            variance += Math.pow(num - average, 2);
        }
        double standardDeviation = Math.sqrt(variance / numbers.size());

        return standardDeviation;
    }
}
