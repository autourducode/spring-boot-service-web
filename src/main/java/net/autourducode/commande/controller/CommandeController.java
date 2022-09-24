package net.autourducode.commande.controller;

import lombok.AllArgsConstructor;
import net.autourducode.commande.model.Commande;
import net.autourducode.commande.model.dto.CommandeDto;
import net.autourducode.commande.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rickenbazolo
 */
@RestController
@RequestMapping("/commande")
@AllArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping
    public Commande create(@RequestBody  CommandeDto commandeDto) {
        return commandeService.create(commandeDto);
    }

    @GetMapping
    public List<Commande> read() {
        return commandeService.read();
    }

    @PutMapping("/{id}")
    public Commande update(@PathVariable Long id, @RequestBody CommandeDto commandeDto) {
        return commandeService.update(id, commandeDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return commandeService.delete(id);
    }
}
