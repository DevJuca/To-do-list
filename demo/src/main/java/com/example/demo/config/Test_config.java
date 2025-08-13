package com.example.demo.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.models.Subtasks.SubTask;
import com.example.demo.models.To_do.To_Do;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;
import com.example.demo.repository.SubTaskRepository;
import com.example.demo.repository.To_DoRepository;

@Configuration
@Profile("test")
public class Test_config implements CommandLineRunner {
    DateFormat dateform = new SimpleDateFormat("MM-dd-yyyy");

    @Autowired
    private To_DoRepository tDoRepository;

    @Autowired
    private SubTaskRepository subTaskRepository;

    @Override
    public void run(String... args) throws Exception {

        // To-do...
        To_Do to_do1 = new To_Do(null, "Limpar a casa", "Limpar toda a casa", dateform.parse("08-22-2025"),To_DoStatus.IN_PROGRESS, To_DoPriority.HIGH, false);
        To_Do to_do2 = new To_Do(null, "Estudar Java", "Revisar conceitos de orientação a objetos", dateform.parse("08-25-2025"), To_DoStatus.TO_DO, To_DoPriority.MEDIUM, false);
        To_Do to_do3 = new To_Do(null, "Fazer compras", "Comprar frutas, legumes e produtos de limpeza", dateform.parse("08-20-2025"), To_DoStatus.DONE, To_DoPriority.LOW, true);
        To_Do to_do4 = new To_Do(null, "Enviar relatório", "Finalizar e enviar relatório mensal para o gerente", dateform.parse("08-21-2025"), To_DoStatus.IN_PROGRESS, To_DoPriority.HIGH, false);
        To_Do to_do5 = new To_Do(null, "Agendar consulta médica", "Marcar consulta com o dermatologista", dateform.parse("08-22-2025"), To_DoStatus.WAITING, To_DoPriority.MEDIUM, false);

        tDoRepository.saveAll(Arrays.asList(to_do1,to_do2,to_do3,to_do4,to_do5));

        // Subtask...
        SubTask subtask1 = new SubTask(null, "Limpar o quarto", "Fazer uma limpeza geral no quarto",
                dateform.parse("08-18-2025"), To_DoStatus.TO_DO, To_DoPriority.HIGH, false, to_do1);
        SubTask subtask2 = new SubTask(null, "Limpar o banheiro", "Fazer limpeza no banheiro",
                dateform.parse("08-19-2025"), To_DoStatus.TO_DO, To_DoPriority.HIGH, false, to_do1);
        SubTask subtask3 = new SubTask(null, "Limpar a cozinha", "Fazer limpeza na cozinha",
                dateform.parse("08-19-2025"), To_DoStatus.TO_DO, To_DoPriority.HIGH, false, to_do1);
        subTaskRepository.saveAll(Arrays.asList(subtask1, subtask2, subtask3));
    }

}
