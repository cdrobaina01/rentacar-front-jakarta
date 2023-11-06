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
public class UserDTO extends EntityDTO {
    @Size(min = 3, max = 255)
    private String username;
    @Size(min = 4, max = 255)
    private String password;
    private RoleDTO role;
}
