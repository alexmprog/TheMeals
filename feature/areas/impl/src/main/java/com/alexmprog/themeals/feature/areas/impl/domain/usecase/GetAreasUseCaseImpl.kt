package com.alexmprog.themeals.feature.areas.impl.domain.usecase

import com.alexmprog.themeals.feature.area.api.domain.repository.AreasRepository
import com.alexmprog.themeals.feature.area.api.domain.model.Area
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.area.api.domain.usecase.GetAreasUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
internal class GetAreasUseCaseImpl(
    private val areasRepository: AreasRepository
) : GetAreasUseCase {

    override operator fun invoke(): Flow<Resource<List<Area>>> = areasRepository.getAreas()
}