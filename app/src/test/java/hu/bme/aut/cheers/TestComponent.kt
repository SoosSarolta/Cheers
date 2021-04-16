package hu.bme.aut.cheers

import dagger.Component
import hu.bme.aut.cheers.mock.MockNetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MockNetworkModule::class,
    ]
)
class TestComponent