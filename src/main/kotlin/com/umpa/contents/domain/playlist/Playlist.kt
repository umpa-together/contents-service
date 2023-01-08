package com.umpa.contents.domain.playlist

import com.umpa.contents.storage.playlist.PlaylistEntity
import java.time.LocalDateTime

data class Playlist(
    val id: Long,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val userId: Long,
    val title: String,
    val content: String,
    val view: Int,
    val image: String,
    val accessedAt: LocalDateTime,
    val youtubeUrl: String,
//    val songs: List<Any>,
    val active: Boolean
) {
    constructor(entity: PlaylistEntity) : this(
        id = entity.id,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt,
        userId = entity.userId,
        title = entity.title,
        content = entity.content,
        view = entity.view,
        image = entity.image,
        accessedAt = entity.accessedAt,
        youtubeUrl = entity.youtubeUrl,
//        songs = entity.songs,
        active = entity.active
    )
}
