package dao;

import database.DatabaseConnection;
import models.InvoiceLine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceLineDAO {
    private final Connection connection;

    public InvoiceLineDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addInvoiceLine(InvoiceLine line) {
        String sql = "INSERT INTO invoiceline (invoice_id, article_id, quantity, unit_price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, line.getInvoiceId());
            stmt.setLong(2, line.getArticleId());
            stmt.setInt(3, line.getQuantity());
            stmt.setDouble(4, line.getUnitPrice());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException(e);
        }
        return false;
    }

    public List<InvoiceLine> getInvoiceLinesByInvoiceId(long invoiceId) {
        List<InvoiceLine> lines = new ArrayList<>();
        String sql = "SELECT * FROM invoiceline WHERE invoice_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, invoiceId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lines.add(mapRowToInvoiceLine(rs));
                }
            }
        } catch (SQLException e) {
            logSQLException(e);
        }
        return lines;
    }

    private InvoiceLine mapRowToInvoiceLine(ResultSet rs) throws SQLException {
        return new InvoiceLine(
                rs.getLong("id"),
                rs.getLong("invoice_id"),
                rs.getLong("article_id"),
                rs.getInt("quantity"),
                rs.getDouble("unit_price"),
                rs.getDouble("line_total")
        );
    }

    private void logSQLException(SQLException e) {
        e.printStackTrace();
    }
}
