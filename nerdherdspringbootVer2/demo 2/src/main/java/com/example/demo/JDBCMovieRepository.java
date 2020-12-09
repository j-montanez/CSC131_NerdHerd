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

//	@Override
//	public int count() {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.queryForObject("select count(*) from kaggle_data", Integer.class);
//	}
//
//	@Override
//	public int save(Movie movie) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.update("insert into kaggle_data (year_film, film) values(?, ?)", movie.getYear(), movie.getTitle());
//	}
//
//	@Override
//	public int update(Movie movie) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.update(
//                "update kaggle_data set year_film = ? where film = ?",
//                movie.getYear(), movie.getTitle());	
//		}
//
//	@Override
//	public int deleteById(Long id) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.update(
//                "delete kaggle_data where id = ?",
//                id);
//	}
//
//	@Override
//	public List<Movie> findAll() {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query(
//                "select * from kaggle_data",
//                (rs, rowNum) ->
//                        new Movie(
//                                rs.getInt("id"),
//                                rs.getString("film"),
//                                rs.getInt("year_film"), null, null, null
//                        )
//        );
//	}

//	@Override
//	public List<Movie> findByNameAndYear(String name, Integer year) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query(
//                "select * from kaggle_data where film = "+ name +" and year_film = " + year.toString(),
//                new Object[]{"%" + name + "%" , year},
//                (rs, rowNum) ->
//                        new Movie(
//                        		rs.getInt("id"),
//                                rs.getString("film"),
//                                rs.getInt("year_film"), null, null, null
//                        )
//        );
//	}
	@Override
	public List<Movie> findAllByYear(String year) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "SELECT * FROM imdb_data WHERE year = ?",
                new Object[]{year},
                (rs, rowNum) ->
                        new Movie(
                        		rs.getString("Title"),null,null,null,null,null,null,null,null,null,null,null,null,null
                                    
                        )
        );
	}
	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "SELECT * FROM imdb_data WHERE title iLIKE ?",
                new Object[]{"%"+name+"%"},
                (rs, rowNum) ->
                        new Movie(
                                rs.getString("Title"),
                                rs.getString("Year"),
                                rs.getString("Rated"),
                                rs.getString("Released"),
                                rs.getString("Runtime"),
                                rs.getString("Genre"),
                                rs.getString("Director"),
                                rs.getString("Writer"),
                                rs.getString("Actors"),
                                rs.getString("Plot"),
                                rs.getString("Poster"),
                                rs.getString("Metascore"),
                                rs.getString("imdbRating"),
                                rs.getString("imdbVotes")
                                
                        )
        );
	}
	
	@Override
	public List<Movie> generalSearch(String keyWord) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "SELECT\n" +
                "    kaggle_data.*, imdb_data.*\n" + 
                "FROM\n" + 
                "	kaggle_data INNER JOIN imdb_data ON kaggle_data.film=imdb_data.title\n" + 
                "WHERE\n" + 
                "	title iLIKE ? OR\n" + 
                "	genre iLIKE ? OR\n" + 
                "	director iLIKE ? OR\n" + 
                "	writer iLIKE ? OR\n" + 
                "	actors iLIKE ? OR\n" + 
                "	plot iLIKE ? OR\n" + 
                "	imdb_data.language iLIKE ? OR\n" + 
                "	country iLIKE ? OR\n" + 
                "	category iLIKE ? OR\n" + 
                "	kaggle_data.name iLIKE ? \n", 
                new Object[]{"%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%"},
                (rs, rowNum) ->
                        new Movie(
                                rs.getString("Title"),
                                rs.getString("Year"),
                                rs.getString("Rated"),
                                rs.getString("Released"),
                                rs.getString("Runtime"),
                                rs.getString("Genre"),
                                rs.getString("Director"),
                                rs.getString("Writer"),
                                rs.getString("Actors"),
                                rs.getString("Plot"),
                                rs.getString("Poster"),
                                rs.getString("Metascore"),
                                rs.getString("imdbRating"),
                                rs.getString("imdbVotes")
                                
                        )
        );
	}

	
	
	@Override
	public List<MovieAwards> findAwards(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "SELECT * FROM kaggle_data WHERE winner='True' AND film iLIKE ?",
                new Object[]{"%"+name+"%"},
                (rs, rowNum) ->
                        new MovieAwards(
                                rs.getString("Film"),
                                rs.getString("Category")
                        )
        );
	}
	@Override
	public List<Movie> findByOscar(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
                "SELECT imdb_data.* FROM imdb_data,kaggle_data WHERE imdb_data.title = kaggle_data.film AND kaggle_data.winner = 'True' AND kaggle_data.category iLike ?",
                new Object[]{"%"+name+"%"},
                (rs, rowNum) ->
                new Movie(
                		rs.getString("Title"),null,null,null,null,null,null,null,null,null,null,null,null,null
                )
        );
	}
	
//	@Override
//	public Optional<Movie> findById(Long id) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.queryForObject(
//                "select * from kaggle_data where id = ?",
//                new Object[]{id},
//                (rs, rowNum) ->
//                        Optional.of(new Movie(
//                                rs.getInt("id"),
//                                rs.getString("film"),
//                                rs.getInt("year_film"), null,null, null
//                        ))
//        );
//	}
	


//	@Override
//	public String getNameById(Long id) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.queryForObject(
//                "select film from kaggle_data where id = ?",
//                new Object[]{id},
//                String.class
//        );
//	}

//	@Override
//	public int increaseVoteCount(int id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
