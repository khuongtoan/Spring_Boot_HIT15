package my_computer.springsecurity.domain.dto.response;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private Long id;

    private String username;

    private String email;

    private String fullName;

    private String phoneNumber;

    private LocalDate birthday;

    private String address;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime lastLogin;
}
