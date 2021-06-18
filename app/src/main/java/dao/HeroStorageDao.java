package dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import rpg.heros.HeroStorage;

@Dao
public interface HeroStorageDao {

    @Query("SELECT * FROM HeroStorage")
    List<HeroStorage> findAll();

    @Query("SELECT * FROM HeroStorage ORDER BY level DESC LIMIT 10")
    List<HeroStorage> findBestScores();

    @Insert
    void insertHeroStorage(HeroStorage HeroStorage);

}
