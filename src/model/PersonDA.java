package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDA {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahdi", "myjava123");
    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person (id, name, family, salary) values (?, ? ,? ,?) ");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setLong(4, person.getSalary());
        preparedStatement.executeUpdate();
    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();

        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));
            person.setSalary(resultSet.getLong("salary"));
            personList.add(person);
        }
        return personList;
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
