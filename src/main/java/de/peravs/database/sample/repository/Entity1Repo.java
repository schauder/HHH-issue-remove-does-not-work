package de.peravs.database.sample.repository;

import de.peravs.database.sample.entity.Entity1;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface Entity1Repo extends Repository<Entity1, String> {
    List<Entity1> findAll();
    void save(Entity1 entity1);
}
