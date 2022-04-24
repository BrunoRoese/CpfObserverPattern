import CpfObservable.CpfObservable;
import CpfObservers.CpfObserver;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static Utils.ObserverUtils.*;

public class App {
    public static void main(String[] args) {
        CpfObservable observable = new CpfObservable();
        ArrayList<CpfObserver> listOfCpfObservers = createObserversList();
        Scanner scanner = new Scanner(System.in);

        addAllObservers(observable, listOfCpfObservers);

        if(!observable.getValidators().isEmpty()) {
            String cpf = "";
            while(!Objects.equals(cpf, "sair")) {
                System.out.println("Enter a cpf: ");
                cpf = scanner.nextLine();
                observable.setCpf(cpf);
            }
        } else {
            throw new RuntimeException("There are no observers");
        }

        observable.validateAllCpfAtObservers();
    }
}
