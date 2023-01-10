package com.umpa.contents.controller.v1

import com.umpa.contents.controller.v1.request.PlaylistCreateRequest
import com.umpa.contents.controller.v1.response.PlaylistDetailResponse
import com.umpa.contents.domain.playlist.PlaylistService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/playlists")
class PlaylistController(
    private val playlistService: PlaylistService
) {
    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createPlaylist(
        @RequestBody body: PlaylistCreateRequest
    ): ResponseEntity<PlaylistDetailResponse> {
        val playlist = playlistService.createPlaylist(body.userId, body.title, body.content, body.songs, body.hashtags)
        return ResponseEntity.ok(PlaylistDetailResponse(playlist, emptyList()))
    }
}
