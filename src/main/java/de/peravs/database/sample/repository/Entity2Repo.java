package de.peravs.database.sample.repository;

import de.peravs.database.sample.entity.Entity2;
import org.springframework.data.repository.Repository;

public interface Entity2Repo extends Repository<Entity2, String> {
    void delete(Entity2 entity2);
}
