package com.example.demo_MVC.repository.mapper;

import com.example.demo_MVC.UserContact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<UserContact> {
    @Override
    public UserContact mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserContact contact = new UserContact();

        contact.setId(rs.getLong(UserContact.Fields.id));
        contact.setFirstName(rs.getString(UserContact.Fields.firstName));
        contact.setLastName(rs.getString(UserContact.Fields.lastName));
        contact.setEmail(rs.getString(UserContact.Fields.email));
        contact.setPhone(rs.getInt(UserContact.Fields.phone));

        return contact;
    }
}
