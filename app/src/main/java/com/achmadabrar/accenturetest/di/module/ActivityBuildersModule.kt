package com.achmadabrar.accenturetest.di.module

import com.achmadabrar.accenturetest.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesContactActivity(): MainActivity
}