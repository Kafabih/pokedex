package com.svck.mobile.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.svck.mobile.pokedexapp.ui.composables.PokemonDetail
import com.svck.mobile.pokedexapp.ui.composables.MainListScreen
import com.svck.mobile.pokedexapp.ui.composables.SplashScreen
import com.svck.mobile.pokedexapp.ui.theme.PokedexTheme
import com.svck.mobile.pokedexapp.ui.viewmodel.PokeDetailViewModel
import com.svck.mobile.pokedexapp.ui.viewmodel.PokeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash_screen") {
                    composable("main_screen") {
                        val viewModel: PokeViewModel = hiltViewModel()
                        MainListScreen(
                            viewModel.getPokeList,
                            viewModel::eventCall,
                            viewModel::searchEventCall,
                            viewModel
                                .searchState
                        ) { color, name ->
                            navController.navigate("poke_detail/$color/$name")
                        }
                    }
                    composable(
                        "poke_detail/{color}/{name}",
                        arguments = listOf(navArgument("color") {
                            type = NavType.IntType
                        }, navArgument("name") {
                            type = NavType.StringType
                        })
                    ) {
                        val remColor = remember {
                            val color = it.arguments?.getInt("color")
                            color?.let { colour -> Color(colour) } ?: Color.White
                        }
                        val remName = remember {
                            it.arguments?.getString("name");
                        }
                        val pokeDetailViewModel: PokeDetailViewModel = hiltViewModel()
                        PokemonDetail(remColor,pokeDetailViewModel::getPokemonInfo,remName){
                            navController.popBackStack()
                        }
                    }

                    composable(
                        "splash_screen"
                    ) {
                        SplashScreen(
                            navigateToHome = {
                                navController.navigate("main_screen")
                            }
                        )
                    }
                }
            }
        }
    }
}

