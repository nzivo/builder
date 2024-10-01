package com.batedesigns.project_service.repository;

import com.batedesigns.project_service.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}