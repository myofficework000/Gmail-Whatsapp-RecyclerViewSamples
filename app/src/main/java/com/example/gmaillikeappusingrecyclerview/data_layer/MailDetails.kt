package com.example.gmaillikeappusingrecyclerview.data_layer

import java.io.Serializable

data class MailDetails(
    val sender: String,
    val title: String,
    val body: String,
    val time: String,
    val isFavourite: Boolean
) : Serializable
