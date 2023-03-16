package com.kelvin.mercury.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Mobile number cannot be blank")
    private String mobileNumber;

    @Builder.Default
    private LocalDateTime createDate = LocalDateTime.now();
}
