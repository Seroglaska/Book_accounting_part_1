package by.serookiy.firstproject.dao;

import by.serookiy.firstproject.model.Book;
import by.serookiy.firstproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final static String SELECT_ALL = "SELECT * FROM Book";
    private final static String SELECT_ID_PERSON = "SELECT * FROM Book where id_person = ?";
    private final static String SELECT_ID = "SELECT * FROM Book WHERE id_book = ?";
    private final static String INSERT_INTO = "INSERT INTO Book(name, author, year) VALUES (?,?,?)";
    private final static String UPDATE_ID = "UPDATE Book SET name = ?, author = ?, year = ? WHERE id_book = ?";
    private final static String DELETE_ID = "DELETE FROM book WHERE id_book = ?";
    private final static String SELECT_PERSON = "SELECT Person.* FROM Book JOIN Person on book.id_person = person.id_person WHERE Book.id_book = ?";
    private final static String UPDATE_ID_PERSON = "UPDATE Book SET id_person = ? WHERE id_book = ?";
    private final static String EDIT_ID_PERSON = "UPDATE Book SET id_person = null WHERE id_book = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Person> showPerson(int id){
        return jdbcTemplate.query(SELECT_PERSON, new Object[]{id},new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }



    public Book show(int id){
        return jdbcTemplate.query(SELECT_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void create(Book book){
        jdbcTemplate.update(INSERT_INTO, book.getName(), book.getAuthor(), book.getYear());
    }

    public void update(Book book, int id){
        jdbcTemplate.update(UPDATE_ID,book.getName(),book.getAuthor(),book.getYear(), id);
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query(SELECT_ID_PERSON, new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }




    public void updateId(int id, Person person){
        jdbcTemplate.update(UPDATE_ID_PERSON, person.getIdPerson(), id);
    }

    public void edit(int id){
        jdbcTemplate.update(EDIT_ID_PERSON,id);
    }


    public void delete(int id){
        jdbcTemplate.update(DELETE_ID, id);
    }
}
