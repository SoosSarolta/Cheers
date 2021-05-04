package hu.bme.aut.cheers

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import hu.bme.aut.cheers.ui.list.ListFragment

class MainActivity : SimpleNavActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null)
            navigator.add(ListFragment())

        firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.setUserProperty("user_name", "Test User")
    }
}