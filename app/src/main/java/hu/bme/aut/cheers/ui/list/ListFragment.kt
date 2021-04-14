package hu.bme.aut.cheers.ui.list

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import hu.bme.aut.cheers.R
import hu.bme.aut.cheers.ui.about.AboutFragment
import hu.bme.aut.cheers.ui.details.DetailsFragment
import hu.bme.aut.cheers.ui.list.adapter.CoctailsAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : RainbowCakeFragment<ListViewState, ListViewModel>() {

    private lateinit var coctailsAdapter: CoctailsAdapter
    private var firstLetter = "y"

    private lateinit var navDrawer: Drawer
    private lateinit var drawerHeader: AccountHeader

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coctailsAdapter = CoctailsAdapter(requireContext(), ::onCoctailClicked)
        recyclerView.adapter = coctailsAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

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

    override fun onStart() {
        super.onStart()
        viewModel.loadCoctailsByFirstLetter(firstLetter)
    }

    override fun render(viewState: ListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Loading -> {
                progressBar.isVisible = true
                recyclerView.isVisible = false
            }
            is ListReady -> {
                coctailsAdapter.submitList(viewState.result)
                progressBar.isVisible = false
                recyclerView.isVisible = true
            }
            NetworkError -> {
                progressBar.isVisible = false
                recyclerView.isVisible = false
                showNetworkError()
            }
        }.exhaustive
    }

    private fun onCoctailClicked(coctail: ListPresenter.CoctailItem) {
        navigator?.add(DetailsFragment.newInstance(coctail.id))
    }

    private fun showNetworkError() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Error querying coctails!")
            .setPositiveButton("Retry") { dialog, _ ->
                dialog.dismiss()
                viewModel.loadCoctailsByFirstLetter(firstLetter)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
    }

    private fun menuItemClicked(title: String): (View?) -> Boolean = {
        if (title == "List")
            navigator?.add(ListFragment())
        if (title == "About")
            navigator?.add(AboutFragment())
        false
    }
}