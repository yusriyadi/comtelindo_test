package tellabsxcomtelindo.android.klikcoaching

import android.app.Application
import com.github.ajalt.timberkt.Timber
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tellabsxcomtelindo.android.klikcoaching.di.myModules

class App():Application() {

    override fun onCreate() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        super.onCreate()
            startKoin{
                androidContext(this@App)
                modules(myModules)
            }
    }
}