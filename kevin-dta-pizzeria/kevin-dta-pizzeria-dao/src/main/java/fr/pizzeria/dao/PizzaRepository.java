package fr.pizzeria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
