package com.example.hw5_3pixabay

data class PixabayModel (
    val hits : List<ImageModel>
    )

data class ImageModel(
    val largeImageURL:String
)
