package fr.orionbs.guardian.adapter.view.authentication.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AuthenticateViewRequest {

    @NotBlank(message = "{authenticate-view-request.email.not-blank}")
    @Email(message = "{authenticate-view-request.email.pattern}")
    private String email;

    @NotBlank(message = "{authenticate-view-request.password.not-blank}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "{authenticate-view-request.password.pattern}")
    private String password;

}
