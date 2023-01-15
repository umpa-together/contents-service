package com.umpa.contents.domain.feed

import com.umpa.contents.storage.feed.FeedEntity
import com.umpa.contents.storage.feed.FeedRepository
import com.umpa.contents.support.enums.FeedType
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class FeedWriter(
    private val feedRepository: FeedRepository
) {
    @Transactional
    fun createFeed(playlistId: Long, userId: Long): FeedEntity {
        return feedRepository.save(
            FeedEntity(
                playlistId = playlistId,
                userId = userId,
                type = FeedType.Playlist
            )
        )
    }
}
