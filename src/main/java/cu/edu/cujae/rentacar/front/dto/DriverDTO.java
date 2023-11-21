package cu.edu.cujae.rentacar.front.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverDTO implements Serializable {
    private Integer id;
    private String dni;
    private String name;
    private AuxiliaryDTO category;
    private String address;
}
