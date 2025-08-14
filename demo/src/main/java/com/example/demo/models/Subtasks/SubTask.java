package com.example.demo.models.Subtasks;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.models.To_do.To_Do;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "deadline", "status", "priority"})
@Entity
@Table(name = "Subtasks")
public class SubTask implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "America/Sao_Paulo")
    private Date deadline;

    @Enumerated(EnumType.STRING)
    private To_DoStatus status;

    @Enumerated(EnumType.STRING)
    private To_DoPriority priority;
    
    private Boolean completed;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "to-do_id")
    private To_Do to_do;

}
