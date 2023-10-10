package model;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PersonServiceImpl extends UnicastRemoteObject implements PersonService{

    public PersonServiceImpl() throws Exception{}
    @Override
    public void register(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.insert(person);
        personDA.close();

        System.out.println("register executed ...");
    }

    @Override
    public List<Person> getAll() throws Exception {
        PersonDA personDA = new PersonDA();
        List<Person> personList = personDA.selectAll();
        personDA.close();
        System.out.println("getAll executed ...");
        return personList;

    }
}
