package cu.edu.cujae.rentacar.front.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TouristDTO extends EntityDTO{
    @Size(min = 6, max = 25)
    private String passport;
    @Size(min = 1, max = 255)
    private String name;
    @Min(value = 18)
    @Max(value = 150)
    private Integer age;
    private AuxiliaryDTO gender;
    @Size(min = 2, max = 17)
    private String contact;
    private AuxiliaryDTO country;
}