package org.jorgma.athome.sl.dao;

import org.jorgma.athome.sl.domain.Station;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jorgma on 2017-12-12.
 */
@Repository
public class StationDaoImpl implements StationDao {

    private JdbcTemplate jdbcTemplate;

    public StationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveStation(Station station) {
        String query = "INSERT INTO stations(name, site_id, type, x, y) VALUES(?,?,?,?,?);";
        jdbcTemplate.update(query, new Object[]{station.getName(),
                station.getSiteId(), station.getType(), station.getX(), station.getY()});
    }


    @Override
    public Station getStation(int id) {
        String query = "SELECT * FROM stations WHERE id=?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<>(Station.class));
    }


    @Override
    public List<Station> getStations() {
        String query = "SELECT * FROM stations;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Station.class));
    }

    @Override
    public void deleteStation(int id) {
        String query = "DELETE FROM stations WHERE id=?;";
        jdbcTemplate.update(query, new Object[]{id});
    }
}
