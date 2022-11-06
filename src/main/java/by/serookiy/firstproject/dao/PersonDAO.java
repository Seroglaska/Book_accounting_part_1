package by.serookiy.firstproject.dao;

import by.serookiy.firstproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final static String SELECT_ALL = "SELECT * FROM Person";
    private final static String SELECT_ID = "SELECT * FROM Person WHERE id_person = ?";
    private final static String SELECT_FIO = "SELECT * FROM Person WHERE fio = ?";
    private final static String INSERT_INTO = "INSERT INTO Person(fio,date) VALUES (?,?)";
    private final static String UPDATE_ID = "UPDATE Person SET fio = ?, date = ? WHERE id_person = ?";
    private final static String DELETE_ID = "DELETE FROM Person WHERE id_person = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<>(Person.class));
    }


    public Person show(int id){
        return jdbcTemplate.query(SELECT_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public Optional<Person> show(String fio){
        return jdbcTemplate.query(SELECT_FIO, new Object[]{fio}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void create(Person person){
        jdbcTemplate.update(INSERT_INTO, person.getFio(), person.getDate());
    }

    public void update(Person person, int id){
        jdbcTemplate.update(UPDATE_ID, person.getFio(), person.getDate(), id);
    }

    public void delete(int id){
        jdbcTemplate.update(DELETE_ID, id);
    }
}
