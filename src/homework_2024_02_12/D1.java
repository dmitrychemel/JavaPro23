package homework_2024_02_12;

import java.util.List;

public class D1 implements CalculatorList{
    @Override
    public double calculatorAverage(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public double calculatorSum(List<Double> numbers) {
        return numbers.stream()
                .reduce(0.0,Double::sum);
    }

//    public double (List<Double> listOfNumbers) {
//        double sumOfAllValues = 0;
//        for (double currentValue : listOfNumbers) {
//            sumOfAllValues += currentValue;
//        }
//        return sumOfAllValues / listOfNumbers.size();
//    }
}