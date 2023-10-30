package cu.edu.cujae.rentacar.front.dto;

import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PayMethodDTO extends EntityDTO {
    @Size(min = 2, max = 255)
    private String name;
}
