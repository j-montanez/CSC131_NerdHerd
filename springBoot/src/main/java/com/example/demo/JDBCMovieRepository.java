package com.example.demo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCMovieRepository implements MovieRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public JDBCMovieRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from kaggle_data", Integer.class);
	}

	@Override
	public int save(Movie movie) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into kaggle_data (year_film, film) values(?, ?)", movie.getYear(), movie.getName());
	}

	@Override
	public int update(Movie movie) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "update kaggle_data set year_film = ? where film = ?",
                movie.getYear(), movie.getName());	
		}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "delete kaggle_data where id = ?",
                id);
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "select * from kaggle_data",
                (rs, rowNum) ->
                        new Movie(
                                rs.getInt("id"),
                                rs.getString("film"),
                                rs.getInt("year_film"), null, null, null
                        )
        );
	}

	@Override
	public List<Movie> findByNameAndYear(String name, Integer year) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "select * from kaggle_data where film = "+ name +" and year_film = " + year.toString(),
                new Object[]{"%" + name + "%" , year},
                (rs, rowNum) ->
                        new Movie(
                        		rs.getInt("id"),
                                rs.getString("film"),
                                rs.getInt("year_film"), null, null, null
                        )
        );
	}

	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "SELECT kaggle_data.*, imdb_data.* FROM kaggle_data INNER JOIN imdb_data ON kaggle_data.film=imdb_data.title WHERE film = ?",
                new Object[]{name},
                (rs, rowNum) ->
                        new Movie(
                        		rs.getInt("id"),
                                rs.getString("film"),
                                rs.getInt("year_film"),
                                rs.getString("poster"),
                                rs.getString("plot"),
                                rs.getString("genre")
                        )
        );
	}
	@Override
	public Optional<Movie> findById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
                "select * from kaggle_data where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Movie(
                                rs.getInt("id"),
                                rs.getString("film"),
                                rs.getInt("year_film"), null,null, null
                        ))
        );
	}
	


	@Override
	public String getNameById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
                "select film from kaggle_data where id = ?",
                new Object[]{id},
                String.class
        );
	}

	@Override
	public int increaseVoteCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
