package com.example.aula7exercicio4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
   // neste exercicio foi utilizado um NestedScrollView e uma View chamada fadeInOutView.
   // À medida que o usuário rola, a altura da fadeInOutView é usada para calcular o fator de escala.
   // A animação de fade-in/fade-out é então aplicada com base nesse fator de escala.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nestedScrollView = findViewById<View>(R.id.nestedScrollView)
        val fadeInOutView = findViewById<View>(R.id.fadeInOutView)

        nestedScrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY = nestedScrollView.scrollY
            val viewHeight = fadeInOutView.height.toFloat()
            val scale = 1 - scrollY / viewHeight

            animateFadeInOut(fadeInOutView, scale)
        }
    }

    private fun animateFadeInOut(view: View, scale: Float) {
        ViewCompat.animate(view)
            .scaleX(scale)
            .scaleY(scale)
            .alpha(scale)
            .setDuration(0)
            .start()
    }
}
