    package my_computer.springsecurity.domain.dto.request;


    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.Pattern;
    import jakarta.validation.constraints.Size;
    import lombok.*;

    import java.time.LocalDate;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class RegisterRequestDTO  {

        @NotBlank
        private String username;

        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$")
        private String password;

        private String email;

        private String fullName;

        private String phoneNumber;

        private LocalDate birthday;
    }
