package com.umpa.contents.domain.playlist

import com.umpa.contents.clients.song.SongClient
import com.umpa.contents.domain.feed.FeedWriter
import com.umpa.contents.domain.hashtag.HashtagWriter
import com.umpa.contents.support.enums.SongType
import org.springframework.stereotype.Service

@Service
class PlaylistService(
    private val playlistWriter: PlaylistWriter,
    private val feedWriter: FeedWriter,
    private val hashtagWriter: HashtagWriter,
    private val songClient: SongClient
) {
    fun createPlaylist(userId: Long, title: String, content: String, songs: List<Any>, hashtags: List<String>): Playlist {
        val playlist = playlistWriter.createPlaylist(userId, title, content, songs)
        // TODO s3에 image 업로드
        songClient.createSongs(
            playlistId = playlist.id,
            songs = songs,
            type = SongType.Playlist
        )
        feedWriter.createFeed(playlist.id, userId)
        hashtags.forEach {
            hashtagWriter.createHashtag(it, playlistId = playlist.id)
        }
        return Playlist(playlist, songs)
    }
}
