package CpfObservers;

import Utils.CpfUtils;
import Validator.CpfValidator;

import java.util.ArrayList;

public class CpfObserverToConsole implements CpfObserver {
    private ArrayList<String> cpfList = new ArrayList<>();
    private final CpfValidator validateCpf = new CpfValidator();

    @Override
    public void update(String cpf) {
        CpfUtils.validateCpf(cpf, this.cpfList);
    }

    @Override
    public void validateAllCpf() {
        for (String cpf : cpfList) {
            printCpf(cpf);
        }
    }

    private void printCpf(String cpf) {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        if (validateCpf.validateCpf(cpf)) {
            System.out.println(ANSI_GREEN + "CPF is valid!");
        } else {
            System.out.println(ANSI_RED + "CPF is invalid!");
        }
    }

    public ArrayList<String> getCpfList() {
        return cpfList;
    }

    public void setCpfList(ArrayList<String> cpfList) {
        this.cpfList = cpfList;
    }
}
