package tellabsxcomtelindo.android.klikcoaching.di

import PreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tellabsxcomtelindo.android.klikcoaching.data.AppDatabase


val appModule = module{
    single{PreferencesHelper(androidContext())}
}

val viewModelModule = module {

}

val repositoryModule = module {

}
val databaseModule = module {
single { AppDatabase.getInstance(androidContext()) }

}

val myModules = listOf(appModule, viewModelModule, repositoryModule, databaseModule)