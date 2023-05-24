package com.fftools.projectorremote.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "brandList", primaryKeys = ["brand"])
class ProjectorBrandEntity(
    @ColumnInfo(name = "brand") var brand: String = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ProjectorBrandEntity
        if (brand != other.brand) return false
        // ... kiểm tra các trường khác
        return true
    }

    override fun hashCode(): Int {
        // ... tính toán hashCode cho các trường khác
        return brand.hashCode()
    }
}