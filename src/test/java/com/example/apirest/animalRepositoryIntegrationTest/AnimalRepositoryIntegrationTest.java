package com.example.apirest;

import com.example.apirest.entity.Animal;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class AnimalRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSaveAnimal() {
        // Guarda el animal en la base de datos utilizando el método saveAnimal
        Animal savedAnimal = Animal.saveAnimal((EntityManager) entityManager, "Tiger", "Mammal");

        // Recupera el animal de la base de datos por su ID
        Animal retrievedAnimal = entityManager.find(Animal.class, savedAnimal.getId());

        // Verifica que el animal recuperado no sea nulo
        assertNotNull(retrievedAnimal);

        // Verifica que los atributos del animal recuperado sean iguales a los del animal guardado
        assertEquals(savedAnimal.getName(), retrievedAnimal.getName());
        assertEquals(savedAnimal.getType(), retrievedAnimal.getType());
    }
}
