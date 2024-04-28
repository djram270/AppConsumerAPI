package co.unicauca.microservice.apirest.controller;

import co.unicauca.microservice.apirest.model.entity.User;
import co.unicauca.microservice.apirest.model.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Users")
@RequiredArgsConstructor
public class ProductController {
    //inyectar un servicio (innecesario, ahora se gestinona con @wired)
    @Autowired
    private iUserService userService;

    //@POST requiete una dependecia que no se tiene en el proyecto
    @PostMapping("/post")
    public ResponseEntity<String> postUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.postUser(user));
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putUser(@RequestBody User user, @PathVariable Long id)
    {
        return ResponseEntity.ok(userService.putUser(user, id));
    }
}
