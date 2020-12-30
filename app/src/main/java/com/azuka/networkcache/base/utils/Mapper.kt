package com.azuka.networkcache.base.utils


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

abstract class Mapper<Entity, Domain, Response> {
    abstract fun mapEntityToDomain(entity: Entity): Domain
    fun mapEntitiesToDomains(entities: List<Entity>): List<Domain> =
        entities.map { entity ->
            mapEntityToDomain(entity)
        }

    abstract fun mapDomainToEntity(dto: Domain): Entity
    fun mapDomainsToEntities(dtos: List<Domain>): List<Entity> =
        dtos.map { dto -> mapDomainToEntity(dto) }

    abstract fun mapResponseToEntity(response: Response): Entity
    fun mapResponsesToEntities(responses: List<Response>): List<Entity> =
        responses.map { response ->
            mapResponseToEntity(response)
        }

    abstract fun mapResponseToDomain(response: Response): Domain
    fun mapResponsesToDomains(responses: List<Response>): List<Domain> =
        responses.map { response ->
            mapResponseToDomain(response)
        }
}