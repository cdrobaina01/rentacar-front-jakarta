package cu.edu.cujae.rentacar.front.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TouristDTO implements Serializable {
    private Integer id;
    private String passport;
    private String name;
    private Integer age;
    private String sex;
    private String contact;
    private CountryDTO country;
}