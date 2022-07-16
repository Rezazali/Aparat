package com.navin.aparat.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.navin.aparat.models.Video;

import java.util.List;

@Dao
public interface IDAO {

    @Insert
    long insert(Video video);

    @Query("select * from tbl_video")
    List<Video> videoList();

    @Update
    void update(Video video);

    @Delete
    void delete(Video video);

    @Query("delete from tbl_video  where id = :videoId")
    void deleteVideo(int videoId);

    @Query("SELECT EXISTS(SELECT * FROM tbl_video where id = :videoId)")
    boolean isExists(int videoId);

}
