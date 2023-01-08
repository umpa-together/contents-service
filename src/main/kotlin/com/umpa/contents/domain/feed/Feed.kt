package com.umpa.contents.domain.feed

import com.umpa.contents.common.enums.FeedType
import com.umpa.contents.storage.feed.FeedEntity

data class Feed(
    val playlistId: Long?,
    val dailyId: Long?,
    val type: FeedType,
    val userId: Long,
    val active: Boolean
) {
    constructor(entity: FeedEntity) : this(
        playlistId = entity.playlistId,
        dailyId = entity.dailyId,
        type = entity.type,
        userId = entity.userId,
        active = entity.active
    )
}
