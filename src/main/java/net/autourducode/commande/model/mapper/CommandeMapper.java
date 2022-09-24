package net.autourducode.commande.model.mapper;

import net.autourducode.commande.model.Commande;
import net.autourducode.commande.model.dto.CommandeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * @author rickenbazolo
 */
@Component
public class CommandeMapper {
    public Commande toEntity(CommandeDto commandeDto) {
        Commande toEntity = new Commande();
        toEntity.setNom(commandeDto.nom());
        toEntity.setQuantite(commandeDto.quantite());
        toEntity.setPrix(commandeDto.prix());
        return toEntity;
    }
}
