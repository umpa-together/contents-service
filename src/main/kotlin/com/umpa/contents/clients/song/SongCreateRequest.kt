package com.umpa.contents.clients.song

import com.umpa.contents.support.enums.SongType

data class SongCreateRequest(
    val playlistId: Long? = null,
    val dailyId: Long? = null,
    val songs: List<Any>,
    val type: SongType
)
