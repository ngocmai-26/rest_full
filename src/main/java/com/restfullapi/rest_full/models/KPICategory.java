package com.restfullapi.rest_full.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "kpi_list")
@Data
public class KPICategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "kpi_name")
    private String name;

    @Nullable
    private String description;

    @ManyToMany
    @JoinTable(
            name = "kpis_roles",
            joinColumns = @JoinColumn(name = "kpi_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
