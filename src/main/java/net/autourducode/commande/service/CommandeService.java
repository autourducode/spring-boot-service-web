package net.autourducode.commande.service;

import lombok.AllArgsConstructor;
import net.autourducode.commande.model.Commande;
import net.autourducode.commande.model.dto.CommandeDto;
import net.autourducode.commande.model.mapper.CommandeMapper;
import net.autourducode.commande.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rickenbazolo
 */
@Service
@AllArgsConstructor
public class CommandeService {

    private final CommandeMapper commandeMapper;
    private final CommandeRepository commandeRepository;

    /**
     * Créer une commande
     * @param commandeDto
     * @return une Commande
     */
    public Commande create(CommandeDto commandeDto) {
        Commande commande = commandeMapper.toEntity(commandeDto);
        commande = commandeRepository.save(commande);
        return commande;
    }

    /**
     * Récupérer les commandes
     * @return une liste des commandes
     */
    public List<Commande> read() {
        return commandeRepository.findAll();
    }

    /**
     * Mise à jour d'une commande
     * @param id
     * @param commandeDto
     * @return une commande
     */
    public Commande update(Long id, CommandeDto commandeDto) {
        return commandeRepository.findById(id).map(c -> {
            c.setNom(commandeDto.nom());
            c.setPrix(commandeDto.prix());
            c.setQuantite(commandeDto.quantite());
            return commandeRepository.save(c);
        }).orElseThrow(() -> new IllegalStateException("Erreur !"));
    }

    /**
     * Supprimer une commande
     * @param id
     * @return un message de confirmation
     */
    public String delete(Long id) {
        if (commandeRepository.findById(id).isPresent()) {
            commandeRepository.deleteById(id);
            return "Commande supprimée";
        } else {
            return "Commande invalide!";
        }
    }
}
