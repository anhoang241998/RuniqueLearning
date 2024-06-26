package com.annguyenhoang.runique

import android.app.Application
import com.anguyenhoang.auth.presentation.di.authViewModelModule
import com.annguyenhoang.auth.data.di.authDataModule
import com.annguyenhoang.core.data.networking.di.coreDataModule
import com.annguyenhoang.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule
            )
        }
    }

}