package com.fftools.projectorremote.database.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.fftools.projectorremote.database.dao.ProjectorDao
import com.fftools.projectorremote.model.ProjectorBrandEntity


class ProjectorRepository(private val projectorDao: ProjectorDao) {

    fun getAllBrandProjector(): List<ProjectorBrandEntity> {
        return projectorDao.getAllProjectorBrand()
    }

//    val getAllBrandProjector: List<ProjectorBrandEntity> = projectorDao.getAllProjectorBrand()
}