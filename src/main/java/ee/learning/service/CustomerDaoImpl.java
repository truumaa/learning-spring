package ee.learning.service;

import ee.learning.dao.CustomerDao;
import ee.learning.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(Customer customer) {
        String sql = "INSERT INTO customer (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, customer.getCustId(), customer.getName(), customer.getAge());
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Customer> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Customer cus = new Customer();
            cus.setCustId((Long) row.get("cust_id"));
            cus.setName((String) row.get("name"));
            cus.setAge((Integer) row.get("age"));
            result.add(cus);
        }

        return result;
    }
}