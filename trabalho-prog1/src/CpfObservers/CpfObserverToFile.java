package CpfObservers;

import Utils.CpfUtils;
import Validator.CpfValidator;

import java.io.*;
import java.util.ArrayList;

public class CpfObserverToFile implements CpfObserver {
    private ArrayList<String> cpfList = new ArrayList<>();
    private final CpfValidator cpfValidator = new CpfValidator();

    @Override
    public void update(String cpf) {
        CpfUtils.validateCpf(cpf, this.cpfList);
    }

    @Override
    public void validateAllCpf() {
        createFile();
    }

    private void createFile() {
        try {
            FileWriter file = new FileWriter("cpfs.txt");

            validateAllCpfsToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateAllCpfsToFile(FileWriter file) throws IOException {
        for (String cpf : this.cpfList) {
            if (cpfValidator.validateCpf(cpf)) {
                file.write("CPF: " + cpf + " -> V\n");
            } else {
                file.write("CPF: " + cpf + " -> I\n");
            }
        }
        file.close();
    }

    public ArrayList<String> getCpfList() {
        return cpfList;
    }

    public void setCpfList(ArrayList<String> cpfList) {
        this.cpfList = cpfList;
    }
}
