package by.serookiy.firstproject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int idBook;

    @NotEmpty(message = "Данная строка не должна быть пустой")
    @Size(min=2, max=30, message="Количество символов от 2 до 30")
    private String name;

    @NotEmpty(message = "Данная строка не должна быть пустой")
    @Size(min=2, max=30, message="Количество символов от 2 до 30")
    private String author;
    @Min(value = 0, message = "Год должен быть больше 0")
    private int year;

    public Book(){

    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
