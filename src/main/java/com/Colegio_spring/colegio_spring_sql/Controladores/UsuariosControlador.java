package com.Colegio_spring.colegio_spring_sql.Controladores;

import com.Colegio_spring.colegio_spring_sql.Entidades.Usuarios;
import com.Colegio_spring.colegio_spring_sql.Servicios.Servicios_Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuariosControlador {

    @Autowired
    private Servicios_Usuarios serviciosUsuarios;

    @GetMapping
    public ResponseEntity<?> getUsuarios() {
        return ResponseEntity.ok(serviciosUsuarios.getLista());
    }

    @PostMapping("/aggusuarios")
    public ResponseEntity<String> addUsuario(@RequestBody Usuarios usuario) {
        String response = serviciosUsuarios.agregar(usuario);
        if (response.contains("ya existe")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return ResponseEntity.ok("Usuario agregado exitosamente.");
    }

    @GetMapping("/{documento}")
    public ResponseEntity<Usuarios> getUsuarioPorDocumento(@PathVariable String documento) {
        Optional<Usuarios> usuario = serviciosUsuarios.buscarPorDocumento(documento);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String documento = credentials.get("documento");
        String password = credentials.get("password");

        Usuarios usuario = serviciosUsuarios.login(documento, password);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
