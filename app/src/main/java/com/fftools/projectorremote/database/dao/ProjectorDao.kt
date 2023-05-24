package com.fftools.projectorremote.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fftools.projectorremote.model.ProjectorBrandEntity

@Dao
interface ProjectorDao {

    @Query("Select brand from brandList")
    fun getAllProjectorBrand(): List<ProjectorBrandEntity>

}