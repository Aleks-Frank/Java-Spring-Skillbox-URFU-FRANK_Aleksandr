package com.example.demo_MVC.repository;

import com.example.demo_MVC.UserContact;
import com.example.demo_MVC.exception.ContactFoundException;
import com.example.demo_MVC.repository.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class DatabaseContactRepository implements ContactRepository{

    private final JdbcTemplate jdbcTemplate;

    public DatabaseContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserContact> findAll() {

        String sql = "SELECT * FROM contact";

        return jdbcTemplate.query(sql, new ContactMapper());
    }

    @Override
    public Optional<UserContact> findById(Long id) {

        String sql = "SELECT * FROM contact WHERE id = ?";
        UserContact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sql,
                        new ArgumentPreparedStatementSetter(new Object[]{id}),
                        new RowMapperResultSetExtractor<>(new ContactMapper(), 1)
                )
        );

        return Optional.ofNullable(contact);
    }

    @Override
    public UserContact save(UserContact contact) {

        contact.setId(System.currentTimeMillis());
        String sql = "INSERT INTO contact (firstName, lastName, email, phone, id) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(),
                contact.getEmail(), contact.getPhone(), contact.getId());

        return contact;
    }

    @Override
    public UserContact update(UserContact contact) {

        UserContact existedContact = findById(contact.getId()).orElse(null);
        if (existedContact != null){
            String sql = "UPDATE contact SET firstName = ?, lastName = ?, email = ?, phone = ? WHERE id = ?";
            jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(),
                    contact.getEmail(), contact.getPhone(), contact.getId());
            return contact;
        }

        throw new ContactFoundException("Contact not found" + contact.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM contact WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    public void batchInsert(List<UserContact> contacts) {
        String sql = "INSERT INTO contact (firstName, lastName, email, phone, id) VALUES(?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                UserContact contact = contacts.get(i);
                ps.setString(1, contact.getFirstName());
                ps.setString(2, contact.getLastName());
                ps.setString(3, contact.getEmail());
                ps.setInt(4, contact.getPhone());
                ps.setLong(5, contact.getId());
            }

            @Override
            public int getBatchSize() {
                return contacts.size();
            }
        });
    }
}
