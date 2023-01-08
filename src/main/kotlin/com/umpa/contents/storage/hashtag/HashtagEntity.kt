package com.umpa.contents.storage.hashtag

import com.umpa.contents.storage.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "hashtag")
class HashtagEntity(
    @Column(name = "hashtag")
    val hashtag: String,

    @Column(name = "ref_playlist_id")
    val playlistId: Long? = null,

    @Column(name = "ref_daily_id")
    val dailyId: Long? = null
) : BaseEntity()
