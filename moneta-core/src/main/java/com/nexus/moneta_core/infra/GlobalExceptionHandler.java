package com.nexus.moneta_core.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice // Avisa o Spring que esta classe vai "escutar" todos os erros do sistema
public class GlobalExceptionHandler {

    // Intercepta o erro exato que acontece quando o @Valid do Controller falha
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDTO>> handleValidationErrors(MethodArgumentNotValidException ex) {

        // Pega a lista de campos que falharam e transforma no nosso DTO limpo
        List<ValidationErrorDTO> errors = ex.getFieldErrors().stream()
                .map(ValidationErrorDTO::new)
                .toList();

        // Devolve o Status 400 (Bad Request) e a nossa lista estruturada
        return ResponseEntity.badRequest().body(errors);
    }

    // Criamos um Record (DTO) privado aqui mesmo, só para formatar o erro de saída
    private record ValidationErrorDTO(String campo, String mensagem) {
        public ValidationErrorDTO(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}