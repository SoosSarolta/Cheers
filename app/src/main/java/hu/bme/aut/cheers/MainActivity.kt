package hu.bme.aut.cheers

import android.os.Bundle
import androidx.fragment.app.ListFragment
import co.zsmb.rainbowcake.navigation.SimpleNavActivity

class MainActivity : SimpleNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_list)

        if (savedInstanceState == null)
            navigator.add(ListFragment())
    }
}