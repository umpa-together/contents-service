package com.umpa.contents.domain.playlist

import com.umpa.contents.storage.playlist.PlaylistEntity
import com.umpa.contents.storage.playlist.PlaylistRepository
import com.umpa.user.support.error.BadRequestException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PlaylistReader(
    private val playlistRepository: PlaylistRepository
){
    fun findById(id: Long): PlaylistEntity {
        return playlistRepository.findByIdOrNull(id)
            ?: throw BadRequestException()
    }
}