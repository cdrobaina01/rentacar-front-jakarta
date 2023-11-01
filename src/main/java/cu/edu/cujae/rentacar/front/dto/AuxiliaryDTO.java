package cu.edu.cujae.rentacar.front.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuxiliaryDTO extends EntityDTO{
    @Size(min = 2, max = 255)
    private String name;
}
