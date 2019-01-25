package com.element.in.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.element.in.entity.Module;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Long>{
}
