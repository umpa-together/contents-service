package com.umpa.contents.domain.hashtag

import com.umpa.contents.storage.hashtag.HashtagEntity
import com.umpa.contents.storage.hashtag.HashtagRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class HashtagWriter(
    private val hashtagRepository: HashtagRepository
) {
    @Transactional
    fun createHashtag(hashtag: String, playlistId: Long? = null, dailyId: Long? = null): HashtagEntity {
        return hashtagRepository.save(
            HashtagEntity(
                hashtag = hashtag,
                playlistId = playlistId,
                dailyId = dailyId
            )
        )
    }
}
