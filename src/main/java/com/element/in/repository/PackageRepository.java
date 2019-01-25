package com.element.in.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.element.in.entity.Package;

@Repository
public interface PackageRepository extends CrudRepository<Package, Long>{
	 Package findByCode(String code);
}
