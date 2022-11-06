package by.serookiy.firstproject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {

    private Integer idPerson;


    @NotEmpty(message = "Данная строка не должна быть пустой")
    @Size(min = 2, max = 50, message = "Количество символов от 2 до 30")
    private String fio;

    @Min(value=0, message="Год должен быть больше 0")
    private int date;

    public Person(){

    }


    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
