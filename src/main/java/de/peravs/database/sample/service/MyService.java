package de.peravs.database.sample.service;

import de.peravs.database.sample.entity.Entity1;
import de.peravs.database.sample.entity.Entity2;
import de.peravs.database.sample.repository.Entity1Repo;
import de.peravs.database.sample.repository.Entity2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyService {
    @Autowired
    private Entity1Repo entity1Repo;

    @Autowired
    private Entity2Repo entity2Repo;

    public void createAndSaveEntity1() {
        Entity1 e1 = new Entity1().setId("1_1");
        Entity2 e2_1 = new Entity2().setId("2_1");
        Entity2 e2_2 = new Entity2().setId("2_2");

        e1.getEntity2().add(e2_1);
        e1.getEntity2().add(e2_2);

        e2_1.setEntity1(e1);
        e2_2.setEntity1(e1);

        entity1Repo.save(e1);
    }

    public void deleteEntity2UsingRepo1() {
        Entity1 e1 = entity1Repo.findAll().get(0);

        e1.getEntity2().remove(0);

        entity1Repo.save(e1);
    }

    public void deleteEntity2UsingRepo2() {

        Entity1 e1 = entity1Repo.findAll().get(0);
        Entity2 e2 = e1.getEntity2().get(0);

        entity2Repo.delete(e2);
    }

    public int countEntity2() {

        Entity1 entity1 = entity1Repo.findAll().get(0);
        return entity1.getEntity2().size();
    }

}
