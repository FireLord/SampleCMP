package com.firelord.samplecmp.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import io.github.firelord.sharedpreference.SharedPreference

class HomeViewModel(
    private val sharedPreference: SharedPreference
): ScreenModel {
    var name by mutableStateOf("")
    var textFieldText by mutableStateOf("")

    fun saveName(name: String) {
        sharedPreference.putString("name", name)
    }

    fun getName() {
        name = sharedPreference.getString("name", "not set") ?: "null"
    }
}