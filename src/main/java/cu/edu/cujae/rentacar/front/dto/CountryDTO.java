package cu.edu.cujae.rentacar.front.dto;

import java.io.Serializable;


public class CountryDTO implements Serializable
{
    private Integer id;
    private String name;

    public CountryDTO() {

    }
    public CountryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}