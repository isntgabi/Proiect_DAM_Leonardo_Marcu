package com.example.proiectdam_leonardo_marcu.Databases;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {
    @TypeConverter
    public Long fromTimestamp(Date data){
        return data==null?null:data.getTime();
    }

    @TypeConverter
    public Date toTimestamp(Long data){
        return data==null?null:new Date(data);
    }
}
