package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import tacos.Order;

public class JdbcOrderRepository implements OrderRepository{
    private JdbcTemplate jdbc;
    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    @Override
    public Order save(Order order) {
        jdbc.update("insert into Taco_Order (id, placedAt, name, street, city, state, zip, ccNumber, ccExpiration, ccCVV) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                order.getId().toString(),
                order.getPlacedAt().toString(),
                order.getName(),
                order.getStreet(),
                order.getCity(),
                order.getState(),
                order.getZip(),
                order.getCcNumber(),
                order.getCcExpiration(),
                order.getCcCVV()
                );
        return order;
    }
}
