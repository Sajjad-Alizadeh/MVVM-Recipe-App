package com.sajjad.mvvmrecipeapp.domain.utils

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(entity: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
    fun toDomainModelList(initial: List<T>): List<DomainModel>
    fun fromDomainModelList(initial: List<DomainModel>): List<T>
}