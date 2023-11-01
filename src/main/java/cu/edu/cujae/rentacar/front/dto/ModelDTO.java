package cu.edu.cujae.rentacar.front.dto;

import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModelDTO extends EntityDTO {
    private String name;
    private AuxiliaryDTO brand;
}



