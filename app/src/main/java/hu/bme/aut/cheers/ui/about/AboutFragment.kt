package hu.bme.aut.cheers.ui.about

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import hu.bme.aut.cheers.R
import hu.bme.aut.cheers.ui.list.ListFragment
import kotlinx.android.synthetic.main.fragment_about.*
import java.time.LocalDateTime

class AboutFragment : RainbowCakeFragment<AboutViewState, AboutViewModel>() {

    private lateinit var navDrawer: Drawer
    private lateinit var drawerHeader: AccountHeader

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_about

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navDrawer = drawer {
            hasStableIds = true
            savedInstance = savedInstanceState
            showOnFirstLaunch = false

            drawerHeader = accountHeader {
                savedInstance = savedInstanceState
                translucentStatusBar = true
                profile("Test User", "test@test.hu")
            }

            sectionHeader("Menu") {
                divider = false
            }
            primaryItem("Coctails") {
                iicon = GoogleMaterial.Icon.gmd_local_drink
                onClick(menuItemClicked("List"))
            }
            primaryItem("About") {
                iicon = GoogleMaterial.Icon.gmd_info
                onClick(menuItemClicked("About"))
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun render(viewState: AboutViewState) {
        when(viewState) {
            Loading -> {
                progressBar.isVisible = true
                aboutLayout.isVisible = false
            }
            is InfoReady -> {
                creatorName.text = getString(R.string.creator_name)
                appVersion.text = getString(R.string.app_version)
                date.text = LocalDateTime.now().toString()

                progressBar.isVisible = false
                aboutLayout.isVisible = true
            }
        }.exhaustive
    }

    private fun menuItemClicked(title: String): (View?) -> Boolean = {
        /*if (title == "List")
            // TODO
        if (title == "About")
            // TODO*/
        false
    }
}