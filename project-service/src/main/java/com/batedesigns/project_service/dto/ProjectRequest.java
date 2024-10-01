package com.batedesigns.project_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
    private String name;
    private String description;
    private String location;
    private BigDecimal cost;
}
