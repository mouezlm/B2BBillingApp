package dao;

import database.DatabaseConnection;
import models.Article;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    private Connection connection;

    public ArticleDAO(Connection connection) { // Change the parameter type
        this.connection = connection;
    }

    public boolean addArticle(Article article) {
        String sql = "INSERT INTO article (name, category, price, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, article.getName());
            stmt.setString(2, article.getCategory());
            stmt.setDouble(3, article.getPrice());
            stmt.setInt(4, article.getStock());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException(e);
        }
        return false;
    }

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM article";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                articles.add(mapRowToArticle(rs));
            }
        } catch (SQLException e) {
            logSQLException(e);
        }
        return articles;
    }

    public boolean updateArticle(Article article) {
        String sql = "UPDATE article SET name = ?, category = ?, price = ?, stock = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, article.getName());
            stmt.setString(2, article.getCategory());
            stmt.setDouble(3, article.getPrice());
            stmt.setInt(4, article.getStock());
            stmt.setLong(5, article.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException(e);
        }
        return false;
    }

    public boolean deleteArticle(long articleId) {
        String sql = "DELETE FROM article WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, articleId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException(e);
        }
        return false;
    }

    private Article mapRowToArticle(ResultSet rs) throws SQLException {
        return new Article(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getDouble("price"),
                rs.getInt("stock")
        );
    }

    private void logSQLException(SQLException e) {
        e.printStackTrace();
        // Optionally log to a file or monitoring system.
    }
}
