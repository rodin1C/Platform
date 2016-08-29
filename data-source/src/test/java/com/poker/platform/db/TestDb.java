package com.poker.platform.db;


import com.poker.platform.model.Casino;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:dataSource-test.xml")
@Transactional
public class TestDb {

    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void test() {
        Casino casino = new Casino();
        casino.setName("Test");
        entityManager.persist(casino);
        System.out.println(casino.getName());
    }
}
