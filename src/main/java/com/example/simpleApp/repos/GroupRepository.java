package com.example.simpleApp.repos;

import com.example.simpleApp.domain.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {

    public Group findByName(String name);
}
