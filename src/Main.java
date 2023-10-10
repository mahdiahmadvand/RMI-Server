import model.PersonServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        PersonServiceImpl personService = new PersonServiceImpl();
        Naming.rebind("personService", personService);
        System.out.println("server is running ... ");
    }
}