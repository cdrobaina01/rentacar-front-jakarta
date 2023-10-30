package cu.edu.cujae.rentacar.front.security.dto;

import cu.edu.cujae.rentacar.front.dto.EntityDTO;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoleDTO extends EntityDTO {
    @Size(min = 2, max = 255)
    private String name;
    @Size(min = 2, max = 255)
    private String description;
}
