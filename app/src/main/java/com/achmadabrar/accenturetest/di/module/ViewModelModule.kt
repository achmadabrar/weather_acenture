package com.achmadabrar.accenturetest.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.achmadabrar.accenturetest.di.ViewModelFactory
import com.achmadabrar.accenturetest.di.ViewModelKey
import com.achmadabrar.accenturetest.ui.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    internal abstract fun mainViewModel(viewModel: WeatherViewModel): ViewModel

}