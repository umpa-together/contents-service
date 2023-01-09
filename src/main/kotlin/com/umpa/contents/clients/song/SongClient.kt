package com.umpa.contents.clients.song

import com.umpa.contents.support.enums.SongType
import com.umpa.contents.support.error.FeignClientException
import com.umpa.user.support.error.ApplicationException
import com.umpa.user.support.error.DefaultErrorType
import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SongClient(
    private val songApi: SongApi
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun createSongs(
        playlistId: Long? = null,
        dailyId: Long? = null,
        songs: List<Any>,
        type: SongType
    ): List<String> {
        val body = SongCreateRequest(
            playlistId = playlistId,
            dailyId = dailyId,
            songs = songs,
            type = type
        )
        logger.info("[createSongs] request => $body")
        try {
            return songApi.createSongs(body)?.body
                ?.let { it } ?: throw ApplicationException(DefaultErrorType.INTERNAL_SERVER_ERROR)
        } catch (e: FeignException) {
            throw FeignClientException(e.message)
        }
        throw ApplicationException(DefaultErrorType.INTERNAL_SERVER_ERROR)
    }
}
