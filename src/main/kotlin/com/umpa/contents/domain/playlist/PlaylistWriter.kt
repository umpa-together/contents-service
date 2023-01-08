package com.umpa.contents.domain.playlist

import com.umpa.contents.storage.playlist.PlaylistEntity
import com.umpa.contents.storage.playlist.PlaylistRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class PlaylistWriter(
    private val playlistRepository: PlaylistRepository
) {
    @Transactional
    fun createPlaylist(userId: Long, title: String, content: String, songs: List<Any>): PlaylistEntity {
        return playlistRepository.save(
            PlaylistEntity(
                userId = userId,
                title = title,
                content = content,
//                songs = songs
            )
        )
    }
}
