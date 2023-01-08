package com.umpa.contents.storage.playlist

import com.umpa.contents.storage.BaseEntity
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "playlist")
class PlaylistEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "view")
    val view: Int = 0,

    @Column(name = "image")
    val image: String = "",

    @Column(name = "accessed_ts")
    val accessedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "youtube_url")
    val youtubeUrl: String = "",

    @Column(name = "active")
    val active: Boolean = true
) : BaseEntity()

// likes : [{
//    type: mongoose.Schema.Types.ObjectId,
//    ref: 'User',
// }],
