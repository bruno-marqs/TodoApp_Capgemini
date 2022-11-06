package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


    public void removeById(int taskId) throws SQLException{
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
        return null;
    }
}
