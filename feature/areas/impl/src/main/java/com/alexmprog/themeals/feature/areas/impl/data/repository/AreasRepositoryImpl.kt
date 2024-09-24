package com.alexmprog.themeals.feature.areas.impl.data.repository

import com.alexmprog.themeals.core.database.dao.AreaDao
import com.alexmprog.themeals.core.database.model.AreaEntity
import com.alexmprog.themeals.feature.area.api.domain.repository.AreasRepository
import com.alexmprog.themeals.feature.area.api.domain.model.Area
import com.alexmprog.themeals.feature.areas.impl.data.network.AreaDTO
import com.alexmprog.themeals.feature.areas.impl.data.network.AreasService
import com.alexmprog.themeals.core.common.dispatcher.CommonIoDispatcher
import com.alexmprog.themeals.core.common.model.ErrorType
import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
internal class AreasRepositoryImpl(
    private val areaDao: AreaDao,
    private val areasService: AreasService,
    @Named(CommonIoDispatcher) private val dispatcher: CoroutineDispatcher
) : AreasRepository {

    override fun getAreas(): Flow<Resource<List<Area>>> = flow {
        val localFlow = areaDao.getAreaEntities()
        runCatching {
            areaDao.saveAreaEntities(
                areasService.getAreas().areas.map { it.toEntity() }
            )
        }.onSuccess {
            emit(localFlow.first())
        }.onFailure {
            val localData = localFlow.firstOrNull()
            if (!localData.isNullOrEmpty()) emit(localData) else throw it
        }
    }.map { it -> Resource.Success(it.map { it.toModel() }) as Resource<List<Area>> }
        .catch { emit(Resource.Error(ErrorType.Network)) }
        .flowOn(dispatcher)

}

internal fun AreaDTO.toEntity(): AreaEntity = AreaEntity(name)

internal fun AreaEntity.toModel(): Area = Area(name)