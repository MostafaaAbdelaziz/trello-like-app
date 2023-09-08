package com.csci3130_group11.group11_spring_boot.workspace.repository;

import com.csci3130_group11.group11_spring_boot.workspace.model.WorkspaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<WorkspaceModel, Integer> {
}
