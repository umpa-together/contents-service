package com.umpa.contents.controller.v1.response

import com.umpa.contents.domain.playlist.Playlist

data class PlaylistDetailResponse(
    val playlist: Playlist,
    val comments: List<Any>
)
