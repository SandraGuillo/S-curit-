package fr.ul.dm.repository;

import fr.ul.dm.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPassword extends CrudRepository<Password,Long> {
}
