package com.batedesigns.project_service.service;

import com.batedesigns.project_service.dto.ProjectRequest;
import com.batedesigns.project_service.dto.ProjectResponse;
import com.batedesigns.project_service.model.Project;
import com.batedesigns.project_service.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //inject constructor at runtime
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void createProject(ProjectRequest projectRequest) {
        Project project = Project.builder()
                .name(projectRequest.getName())
                .description(projectRequest.getDescription())
                .location(projectRequest.getLocation())
                .cost(projectRequest.getCost())
                .build();
        projectRepository.save(project);
        log.info("Project {} created", project.getName());
    }

    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream().map(this::mapToProjectResponse).toList();
    }

    private ProjectResponse mapToProjectResponse(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .location(project.getLocation())
                .cost(project.getCost())
                .build();
    }
}
