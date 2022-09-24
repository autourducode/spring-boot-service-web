package net.autourducode.commande.repository;

import net.autourducode.commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rickenbazolo
 */
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
