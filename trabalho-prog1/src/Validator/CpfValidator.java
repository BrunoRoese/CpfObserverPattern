package Validator;

import java.util.ArrayList;
import java.util.Arrays;

public class CpfValidator {

    public boolean validateCpf(String cpf) {
        var cleanCpf = cpf.replaceAll("[^0-9]", "");
        var cpfList = new ArrayList<>(Arrays.asList(cleanCpf.split("")));

        if (!validateCpfLength(cleanCpf.length())) {
            return false;
        }

        var cpfArray = convertCpfFromStringToInt(cpfList, cleanCpf.length());
        var result = getResultForBothDigits(cpfArray, 9, 10);

        return result == cpfArray[9] && validateSecondDigit(cpfArray);
    }

    private boolean validateSecondDigit(int[] cpfArray) {
        var result = getResultForBothDigits(cpfArray, 10, 11);

        return result == cpfArray[10];
    }

    private boolean validateCpfLength(int cpfLength) {
        return cpfLength == 11;
    }

    private int[] convertCpfFromStringToInt(ArrayList<String> cpfList, int arrayLength) {
        var cpfArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            cpfArray[i] = Integer.parseInt(cpfList.get(i));
        }

        return cpfArray;
    }

    private int getResultForBothDigits(int[] cpfArray, int digitPlaceToStop, int counter) {
        var sum = 0;
        for (int i = 0; i < digitPlaceToStop; i++) {
            sum += (cpfArray[i] * counter);
            counter--;
        }

        return cpfMath(sum);
    }

    private int cpfMath(int sum) {
        var digitVerifier = (sum * 10) % 11;

        return digitVerifier == 10 ? 0 : digitVerifier;
    }
}

