package com.achmadabrar.accenturetest.di.module

import com.achmadabrar.accenturetest.ui.fragments.DetailFragment
import com.achmadabrar.accenturetest.ui.fragments.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

}