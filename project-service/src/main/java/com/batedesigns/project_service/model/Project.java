package com.batedesigns.project_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "project")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private String location;
    private BigDecimal cost;
}