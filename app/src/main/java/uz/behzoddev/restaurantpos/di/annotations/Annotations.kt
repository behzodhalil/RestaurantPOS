package uz.behzoddev.restaurantpos.di.annotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RepositoryBinds

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DatasourceBinds

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class InteractorBinds