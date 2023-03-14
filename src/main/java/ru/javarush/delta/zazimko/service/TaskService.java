package ru.javarush.delta.zazimko.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.delta.zazimko.domain.Status;
import ru.javarush.delta.zazimko.domain.Task;
import ru.javarush.delta.zazimko.repositories.TaskDAO;

import java.util.List;


import static java.util.Objects.isNull;

@Service
public class TaskService {

    private  final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }
    public List<Task> getAll(int offset, int limit){
        return taskDAO.getAll(offset,limit);
    }
    public int getAllCount(){
        return taskDAO.getAllCount();
    }
    @Transactional
    public Task update(int id, String description, Status status){
        Task daoById = taskDAO.getById(id);
        if(isNull(daoById)){
            throw new RuntimeException("Not found");
        }
        taskDAO.update(daoById);
        return daoById;
    }
    public Task create(String description, Status status){
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskDAO.save(task);
        return task;
    }
    @Transactional
    public void delete(int id){
        Task daoById = taskDAO.getById(id);
        if(isNull(daoById)) {
            throw new RuntimeException("Not found");
        }
        taskDAO.remove(daoById);
    }
}
