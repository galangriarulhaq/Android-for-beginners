package com.example.projectakhir

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProgrammingLanguage(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable
