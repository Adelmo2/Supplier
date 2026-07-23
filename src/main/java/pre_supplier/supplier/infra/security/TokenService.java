package pre_supplier.supplier.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pre_supplier.supplier.domain.usuario.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}") //passar o nome que esta no "api.security.token.secret" do arquivo application.propertis
    private String secret;

    public String gerarToken(Usuario usuario) {
        System.out.println("**** SECRET: " + secret);
        try {
            //var algoritmo = Algorithm.HMAC256(secret);
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API PreFornecedor")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
//                    .withClaim("id", usuario.getId())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token JWT", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
