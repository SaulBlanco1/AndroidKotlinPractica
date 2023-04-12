package com.saulblanco.androidmaster.settings

data class SettingsModel(
    var volume: Int,
    var bluetooth: Boolean,
    var darkmode: Boolean,
    var vibration: Boolean
) {

}