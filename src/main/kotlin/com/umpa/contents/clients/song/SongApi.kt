package com.umpa.contents.clients.song

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "song-api",
    url = "\${clients.song.url}"
)
interface SongApi {
    @PostMapping(
        value = ["/api/v1/songs"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createSongs(
        @RequestBody body: SongCreateRequest
    ): ResponseEntity<Boolean>
}
