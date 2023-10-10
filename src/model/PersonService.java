package model;

import java.rmi.Remote;
import java.util.List;

public interface PersonService extends Remote {
    public void register(Person person) throws Exception;
    public List<Person> getAll() throws Exception;
}
