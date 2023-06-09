package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.CategoriaEntity;
import com.example.dbd.demodbd.entities.UsuarioEntity;
import com.example.dbd.demodbd.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/usuario")
public class UsuarioController {
    public final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/createUsuario/")
    public UsuarioEntity createUsuario(@RequestBody UsuarioEntity usuarioEntity){
        return usuarioService.createUsuarios(usuarioEntity);
    }

    @GetMapping("/getUsuarios/")
    public List<UsuarioEntity> getUsuarios(){return usuarioService.getAllUsuarios();
    }

    @GetMapping("/getUsuarioById/{id}")
    public Optional<UsuarioEntity> getUsuarioById(@PathVariable(value = "id") Long id){
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioService.getAllUsuariosById(id);
        if(!optionalUsuarioEntity.isPresent()) throw new RuntimeException("El Usuario con el id: " + id + " no existe");
        return optionalUsuarioEntity;
    }

    @PutMapping("/updateUsuario/{id}")
    public UsuarioEntity updateUsuario(@PathVariable(value = "id") Long id, @RequestBody UsuarioEntity usuarioEntity){
        return usuarioService.updateUsuarios(id, usuarioEntity);
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public void deleteUsuario(@PathVariable(value = "id") Long id){
        usuarioService.deleteUsuarios(id);
    }

    @PutMapping("/assignUsuarioToSuscripcion/{id_usuario}/suscripcion/{id_suscripcion}")
    public UsuarioEntity assignUsuarioToSuscripcion(
            @PathVariable(value = "id_usuario") Long id_usuario,
            @PathVariable(value = "id_suscripcion") Long id_suscripcion){
        return usuarioService.assignUsuarioToSuscripcion(id_usuario, id_suscripcion);
    }

    @GetMapping("/loginByNombreUsuario/{nombreUsuario}/contrasena/{contrasena}")
    public String login(@PathVariable(value = "nombreUsuario") String nombreUsuario,@PathVariable(value = "contrasena") String contrasena){
        return usuarioService.login(nombreUsuario,contrasena);
    }
}
