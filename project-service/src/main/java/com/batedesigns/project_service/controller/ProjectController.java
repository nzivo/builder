package com.batedesigns.project_service.controller;

import com.batedesigns.project_service.dto.ProjectRequest;
import com.batedesigns.project_service.dto.ProjectResponse;
import com.batedesigns.project_service.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor //inject constructor at runtime
public class ProjectController {
    private final ProjectService projectService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@RequestBody ProjectRequest projectRequest) {
        projectService.createProject(projectRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

}
