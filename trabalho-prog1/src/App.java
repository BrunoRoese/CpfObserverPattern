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

        addAllObservers(observable, listOfCpfObservers);

        askForCpfsIfSairIsNotTyped(observable);

        observable.validateAllCpfAtObservers();
    }

    private static void askForCpfsIfSairIsNotTyped(CpfObservable observable) {
        Scanner scanner = new Scanner(System.in);

        if (!observable.getValidators().isEmpty()) {
            String cpf = "";
            while (!Objects.equals(cpf, "sair")) {
                System.out.println("Enter a cpf (type \"sair\" if you want to get out): ");
                cpf = scanner.nextLine();
                observable.setCpf(cpf);
            }
        } else {
            throw new RuntimeException("There are no observers");
        }
    }
}
