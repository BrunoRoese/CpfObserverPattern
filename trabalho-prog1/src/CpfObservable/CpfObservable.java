package CpfObservable;

import CpfObservers.CpfObserver;

import java.util.ArrayList;

public class CpfObservable {
    private ArrayList<String> cpf = new ArrayList<>();
    private ArrayList<CpfObserver> validators = new ArrayList<>();

    public void addValidator(CpfObserver validator) {
        this.validators.add(validator);
    }

    public void deleteValidator(CpfObserver validator) {
        this.validators.remove(validator);
    }

    public void setCpf(String cpf) {
        this.cpf.add(cpf);
        this.validators.forEach(validator -> validator.update(cpf));
    }

    public void validateAllCpfAtObservers() {
       this.validators.forEach(CpfObserver::validateAllCpf);
    }

    public ArrayList<String> getCpf(){
        return this.cpf;
    }

    public ArrayList<CpfObserver> getValidators() {
        return this.validators;
    }

    public void setValidators(ArrayList<CpfObserver> validators) {
        this.validators = validators;
    }
}
