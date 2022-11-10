package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskController {
    
    public void save(Task task) {
        String sql = "INSERT INTO tasks (idprojects," 
                        + "name," 
                        + "description,"  
                        + "completed," 
                        + "notes," 
                        + "deadline," 
                        + "createAt," 
                        + "updateAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, task.getIdproject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date (task.getCreateAt().getTime()));
            statement.setDate(8, new Date (task.getUpdateAt().getTime()));
            
            statement.execute();
        } 
        
        catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar tarefa"
                                        + ex.getMessage(), ex); 
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }


    public void update(Task task){
        String sql = "UPDATE tasks SET (idprojects," 
                        + "name," 
                        + "description,"  
                        + "completed," 
                        + "notes," 
                        + "deadline," 
                        + "createAt," 
                        + "updateAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, task.getIdproject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date (task.getCreateAt().getTime()));
            statement.setDate(8, new Date (task.getUpdateAt().getTime()));
            statement.setInt(9, task.getId());

            statement.execute();
        } 
        catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa"
                                    + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }


    public void removeById(int taskId){
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, taskId);
            statement.execute();
        } 
        catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa"
                                    + ex.getMessage(), ex);
        } 
        finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public List<Task> getAll(int idproject){
        
        String sql = "SELECT * FROM tasks WHERE idproject = ?";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        // Lista de tarefas que será devolvida quando a chamadado método
        List<Task> tasks = new ArrayList<Task>();

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, idproject);
            resultset = statement.executeQuery();

            while(resultset.next()){

                Task task = new Task();

                task.setId(resultset.getInt("id"));
                task.setIdproject(resultset.getInt("idproject"));
                task.setName(resultset.getString("name"));
                task.setDescription(resultset.getString("description"));
                task.setNotes(resultset.getString("notes"));
                task.setIsCompleted(resultset.getBoolean("completed"));
                task.setDeadline(resultset.getDate("deadline"));
                task.setCreateAt(resultset.getDate("createAt"));
                task.setUpdateAt(resultset.getDate("updateAt"));

                tasks.add(task);

            }

        } 
        catch (Exception ex) {
            throw new RuntimeException("Erro ao chamar a tarefa"
            + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement, resultset);
        }

        // Lista de tarefas que foi criada e carregada pelo banco de dados
        return tasks;
    }

}
