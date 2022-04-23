package Utils;

import java.util.ArrayList;

public class CpfUtils {
    public static void validateCpf(String cpf, ArrayList<String> cpfList) {
        var cleanCpf = cpf.replaceAll("[^0-9]", "");
        if (cleanCpf.chars().allMatch(Character::isDigit) && !cleanCpf.isEmpty()) {
            cpfList.add(cpf);
        }
    }
}
