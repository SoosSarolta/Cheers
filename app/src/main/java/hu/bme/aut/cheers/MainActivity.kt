package hu.bme.aut.cheers

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import hu.bme.aut.cheers.ui.list.ListFragment

class MainActivity : SimpleNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null)
            navigator.add(ListFragment())
    }
}