//package com.alina.web.productproject.repositories.jdbc;
//
//import com.alina.web.productproject.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//@Component
//public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
//
//    //language=SQL
//    private static final String SQL_INSERT = "insert into users (display_name, nick_name, email, description) " +
//            "values (?, ?, ?, ?)";
//
//    //language=SQL
//    private static final String SQL_SELECT_ALL = "select * from users";
//
//    //language=SQL
//    private static final String SQL_DELETE_BY_ID = "delete from users where id = ?";
//
//    //language=SQL
//    private static final String SQL_SELECT_BY_ID = "select * from users where id = ?";
//
//    //language=SQL
//    private static final String SQL_UPDATE_BY_ID = "update users SET display_name = ?, nick_name = ?, email = ?, description = ? WHERE id = ?";
//
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource){
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    private static final RowMapper<User> userRowMapper = (row, rowNumber) -> {
//        long id = row.getLong("id");
//        String displayName = row.getString("display_name");
//        String nickName = row.getString("nick_name");
//        String email = row.getString("email");
//        String description = row.getString("description");
//
//        return new User(id, displayName, nickName, email, description);
//    };
//
//    @Override
//    public List<User> findAll() {
//        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
//    }
//
//    @Override
//    public void save(User user){
//        jdbcTemplate.update(SQL_INSERT, user.getDisplayName(), user.getNickName(), user.getEmail(), user.getDescription());
//    }
//
//    @Override
//    public void delete(Long userId) {
//        jdbcTemplate.update(SQL_DELETE_BY_ID, userId);
//    }
//
//    @Override
//    public User findById(Long userId) {
//        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, userId);
//    }
//
//    @Override
//    public void updateById(Long userId, User user) {
//        jdbcTemplate.update(SQL_UPDATE_BY_ID, user.getDisplayName(), user.getNickName(), user.getEmail(), user.getDescription(), userId);
//    }
//}
