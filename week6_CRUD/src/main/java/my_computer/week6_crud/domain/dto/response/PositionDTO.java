package my_computer.week6_crud.domain.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionDTO {
    private Long id;
    private String title;
    private String description;
}
