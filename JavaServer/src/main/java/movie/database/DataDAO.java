package movie.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import movie.Test;

import java.util.List;

@Transactional
@Repository
public class DataDAO implements IDataDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DataDAO(){}

    public List<Test> testFetch(){
        String query = "SELECT o.name as owner, p.name as pet, p.age as age" +
                " FROM ex1.pet p " +
                " INNER JOIN ex1.owner o ON o.id=p.owner_id";
        return jdbcTemplate.query(query, new TestRowMapper());
    }


}
