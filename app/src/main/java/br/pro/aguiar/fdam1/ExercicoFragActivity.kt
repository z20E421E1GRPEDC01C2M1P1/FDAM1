package br.pro.aguiar.fdam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_exercico_frag.*

class ExercicoFragActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercico_frag) // Interface

        bottomNavigationMain                            // Componente BottomNavigaton
            .setupWithNavController(
                findNavController(R.id.navHostMain)     // Componente NavHostFragment
            )
    }
}