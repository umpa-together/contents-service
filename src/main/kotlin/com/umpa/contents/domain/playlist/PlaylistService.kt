package com.umpa.contents.domain.playlist

import com.umpa.contents.domain.feed.FeedWriter
import com.umpa.contents.domain.hashtag.HashtagWriter
import org.springframework.stereotype.Service

@Service
class PlaylistService(
    private val playlistWriter: PlaylistWriter,
    private val feedWriter: FeedWriter,
    private val hashtagWriter: HashtagWriter
) {
    fun createPlaylist(userId: Long, title: String, content: String, songs: List<Any>, hashtags: List<String>) {
        val playlist = Playlist(playlistWriter.createPlaylist(userId, title, content, songs))
        // TODO s3에 image 업로드
        // TODO songs 도메인 서버 호출 (몽고디비에 저장)
        feedWriter.createFeed(playlist.id, userId)
        hashtags.forEach {
            hashtagWriter.createHashtag(it, playlistId = playlist.id)
        }
    }
}
