package com.umpa.contents.controller.v1.request

data class PlaylistCreateRequest(
    val userId: Long,
    val title: String,
    val content: String,
    val songs: List<Any>,
    val hashtags: List<String>
)
