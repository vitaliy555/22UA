package ua.twotwo.dao.repository;

import org.springframework.data.repository.CrudRepository;

import ua.twotwo.dao.entity.DaoStation;

/**
 * Stations repository
 */
public interface StationsRepository extends CrudRepository<DaoStation, Integer> {

}
