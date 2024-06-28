package com.modsen.pizzeria.token;

import com.modsen.pizzeria.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokens")
@Schema(description = "Tokens Entity")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokens_seq_gen")
    @SequenceGenerator(name = "tokens_seq_gen", sequenceName = "tokens_id_seq", allocationSize = 1)
    @Schema(description = "Id", example = "1")
    public Integer id;

    @Column(unique = true)
    @Schema(description = "Token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
    public String token;

    @Schema(description = "Revoked", example = "true")
    public boolean revoked;

    @Schema(description = "Expired", example = "true")
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Schema(description = "User Id", example = "1")
    public User user;

}
