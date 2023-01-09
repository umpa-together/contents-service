package com.umpa.contents.storage.feed

import com.umpa.contents.storage.BaseEntity
import com.umpa.contents.support.enums.FeedType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Entity
@Table(name = "feed")
class FeedEntity(
    @Column(name = "ref_playlist_id")
    val playlistId: Long? = null,

    @Column(name = "ref_daily_id")
    val dailyId: Long? = null,

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    val type: FeedType,

    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "active")
    val active: Boolean = true
) : BaseEntity()
