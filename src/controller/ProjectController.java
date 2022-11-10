package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import util.ConnectionFactory;

public class ProjectController {
    
    public void save(Project project){
        String sql = "INSERT INTO projects (name," 
                        + "description," 
                        + "createAt," 
                        + "updateAt) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date (project.getCreateAt().getTime()));
            statement.setDate(4, new Date (project.getUpdateAt().getTime()));

            statement.execute();
        } 
        
        catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar projeto"
                                        + ex.getMessage(), ex); 
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public void update(Project project){
        String sql = "UPDATE projects SET " 
                        + "name = ?, "
                        + "description = ?, "
                        + "createAt = ?, "
                        + "updateAt = ? "
                        + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setNString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date (project.getCreateAt().getTime()));
            statement.setDate(4, new Date (project.getUpdateAt().getTime()));
            statement.setInt(5, project.getId());

            statement.execute();

        } 
        catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar o projeto"
                                    + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public void removeById(int idprojects){
        String sql = "DELETE FROM projects WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, idprojects);
            statement.execute();
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa", ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public List<Project> getAll(){
        
        String sql = "SELECT * FROM projects";
        
        List<Project> projects = new ArrayList<Project>();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            resultset = statement.executeQuery();

            while(resultset.next()){

                Project project = new Project();

                project.setId(resultset.getInt("id"));
                project.setName(resultset.getString("name"));
                project.setDescription(resultset.getString("description"));
                project.setCreateAt(resultset.getDate("createAt"));
                project.setUpdateAt(resultset.getDate("updateAt"));
                
                projects.add(project);

            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao chamar o projeto", ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement, resultset);
        }

        return projects;
    }

}
