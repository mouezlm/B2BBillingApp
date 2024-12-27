package dao;

import database.DatabaseConnection;
import models.Invoice;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private Connection connection;

    public InvoiceDAO(Connection connection) { // Change the parameter type
        this.connection = connection;
    }

    public boolean addInvoice(Invoice invoice) {
        String query = "INSERT INTO invoice (invoice_type, date, total_amount, client_id, supplier_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, invoice.getInvoiceType());
            stmt.setDate(2, Date.valueOf(invoice.getDate()));
            stmt.setBigDecimal(3, invoice.getTotalAmount());
            stmt.setObject(4, invoice.getClientId(), Types.BIGINT);
            stmt.setObject(5, invoice.getSupplierId(), Types.BIGINT);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException(e);
        }
        return false;
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoice";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                invoices.add(mapRowToInvoice(rs));
            }
        } catch (SQLException e) {
            logSQLException(e);
        }
        return invoices;
    }

    public boolean deleteInvoice(long id) {
        String query = "DELETE FROM invoice WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException(e);
        }
        return false;
    }

    private Invoice mapRowToInvoice(ResultSet rs) throws SQLException {
        return new Invoice(
                rs.getLong("id"),
                rs.getString("invoice_type"),
                rs.getDate("date").toLocalDate(),
                rs.getBigDecimal("total_amount"),
                (Long) rs.getObject("client_id"),
                (Long) rs.getObject("supplier_id")
        );
    }

    private void logSQLException(SQLException e) {
        e.printStackTrace();
    }
}
