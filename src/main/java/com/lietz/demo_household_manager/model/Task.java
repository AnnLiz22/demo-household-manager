package com.lietz.demo_household_manager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;

    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private LocalDateTime completedAt;
    private boolean completed;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}

