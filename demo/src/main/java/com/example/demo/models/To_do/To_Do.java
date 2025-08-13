package com.example.demo.models.To_do;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.models.Subtasks.SubTask;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "deadline", "status", "priority"})
@Entity
@Table(name = "To_Do")
public class To_Do implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date deadline;
    
    @Enumerated(EnumType.STRING)
    private To_DoStatus status;

    @Enumerated(EnumType.STRING)
    private To_DoPriority priority;

    private Boolean completed;

    @OneToMany(mappedBy = "to_do")
    private List<SubTask> subtask = new ArrayList<>();

    public To_Do(Long id, String title, String description, Date deadline, To_DoStatus status, To_DoPriority priority,
            Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;
        this.completed = completed;
    }
}