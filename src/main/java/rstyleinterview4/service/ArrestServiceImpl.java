package rstyleinterview4.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import rstyleinterview4.model.Arrest;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ArrestServiceImpl implements ArrestService{
    private static final AtomicInteger ARREST_ID = new AtomicInteger();
    private final JdbcTemplate jdbcTemplate;

    public ArrestServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int create(Arrest arrest) {
        final int arrestId=ARREST_ID.incrementAndGet();
        if (jdbcTemplate.update("INSERT INTO arrest VALUES(?,?,?,?,?,?,?,?)", arrestId, arrest.getOrganCode(), arrest.getDocDate(), arrest.getDocNumber(), arrest.getPurpose(), arrest.getAmount(), arrest.getRefDocNumber(), arrest.getStatus())!=0){
            return arrestId;
        }
        return 0;
    }

    @Override
    public List<Arrest> readAll() {
        List<Arrest> resultList = jdbcTemplate.query("SELECT * FROM arrest", new ArrestRowMapper());
        return resultList;
    }

    @Override
    public Arrest read(int arrestId) {
        return jdbcTemplate.query("SELECT * FROM arrest WHERE id=?", new ArrestRowMapper(), arrestId).stream().findAny().orElse(null);
    }

    @Override
    public int update(int arrestId, String newPurpose, long newAmount, int newStatus) {
        return jdbcTemplate.update("UPDATE arrest SET purpose=?, amount=?, status=?  WHERE id=?",newPurpose, newAmount, newStatus, arrestId);
    }

    @Override
    public Arrest read(String refDocNumber) {
        return jdbcTemplate.query("SELECT * FROM arrest WHERE refdocnum=?",new ArrestRowMapper(),refDocNumber).stream().findAny().orElse(null);
    }
}
