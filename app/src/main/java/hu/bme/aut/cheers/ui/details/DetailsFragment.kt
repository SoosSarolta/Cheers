package hu.bme.aut.cheers.ui.details

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import hu.bme.aut.cheers.R
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : RainbowCakeFragment<DetailsViewState, DetailsViewModel>() {

    companion object {
        private const val COCTAIL_ID = "COCTAIL_ID"

        fun newInstance(coctailId: String): DetailsFragment {
            return DetailsFragment().applyArgs {
                putString(COCTAIL_ID, coctailId)
            }
        }
    }

    private lateinit var coctailId: String

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgs()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCoctailById(coctailId)
    }

    override fun render(viewState: DetailsViewState) {
        when(viewState) {
            Loading -> {
                progressBar.isVisible = true
                detailsLayout.isVisible = false
            }
            is DetailsReady -> {
                fillDetails(viewState.result)
                progressBar.isVisible = false
                detailsLayout.isVisible = true
            }
            NetworkError -> {
                progressBar.isVisible = false
                detailsLayout.isVisible = false
                showNetworkError()
            }
        }.exhaustive
    }

    private fun initArgs() {
        coctailId = requireArguments().requireString(COCTAIL_ID)
    }

    private fun fillDetails(coctail: DetailsPresenter.DetailedCoctail) {
        coctailName.text = coctail.name
        coctailType.text = coctail.type
        coctailAlcoholicFlag.text = if (coctail.alcoholic) "Alcoholic" else "Non-alcoholic"
        coctailInstructions.text = coctail.instructions

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, coctail.ingredients)
        ingredientsList.adapter = adapter

        Glide.with(coctailImage)
            .load(coctail.thumbnailUrl)
            .into(coctailImage)
    }

    private fun showNetworkError() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Error querying coctail details!")
            .setPositiveButton("Retry") { dialog, _ ->
                dialog.dismiss()
                viewModel.loadCoctailById(coctailId)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
    }
}