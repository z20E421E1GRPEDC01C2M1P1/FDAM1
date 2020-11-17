package br.pro.aguiar.fdam1.carro.ui.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.pro.aguiar.fdam1.R
import br.pro.aguiar.fdam1.carro.database.AppDatabase
import br.pro.aguiar.fdam1.carro.model.Carro
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.lista_carro_fragment.*

class ListaCarroFragment : Fragment() {

    private lateinit var listaCarroViewModel: ListaCarroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater
            .inflate(
                R.layout.lista_carro_fragment,
                container, false)

        listaCarroViewModel =
            ViewModelProvider(
                    this,
                    ListaCarroViewModelFactory(AppDatabase.getInstance()))
                .get(ListaCarroViewModel::class.java)

        listaCarroViewModel
            .carros
            .observe(viewLifecycleOwner) {
                if (!it.isNullOrEmpty())
                    adaptarListView(it)
                else
                    showSnackbar("Nenhum carro encontrado na base.")
            }

        return view
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(
            lista_carro_layout_root,
            msg,
            Snackbar.LENGTH_LONG
        ).show()
    }
    private fun adaptarListView(listaDeCarros: List<Carro>) {
        listViewCarros.adapter =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                listaDeCarros
            )
    }
}