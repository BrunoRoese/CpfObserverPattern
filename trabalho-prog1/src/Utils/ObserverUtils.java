package Utils;

import CpfObservable.CpfObservable;
import CpfObservers.CpfObserver;
import CpfObservers.CpfObserverToConsole;
import CpfObservers.CpfObserverToFile;

import java.util.ArrayList;

public class ObserverUtils {

    public static void addAllObservers(CpfObservable observable, ArrayList<CpfObserver> validators) {
        validators.forEach(observable::addValidator);
    }

    public static void deleteAllObservers(CpfObservable observable, ArrayList<CpfObserver> validators) {
        validators.forEach(observable::deleteValidator);
    }

    public static void addSpecificObserver(CpfObservable observable, CpfObserver validator) {
        observable.addValidator(validator);
    }

    public static void deleteSpecificObserver(CpfObservable observable, CpfObserver validator) {
        observable.deleteValidator(validator);
    }

    public static ArrayList<CpfObserver> createObserversList() {
        CpfObserverToConsole cpfObserverToConsole = new CpfObserverToConsole();
        CpfObserverToFile cpfObserverToFile = new CpfObserverToFile();
        ArrayList<CpfObserver> listOfCpfObservers = new ArrayList<>();

        listOfCpfObservers.add(cpfObserverToConsole);
        listOfCpfObservers.add(cpfObserverToFile);

        return listOfCpfObservers;
    }
}
