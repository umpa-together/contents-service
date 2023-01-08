package com.umpa.contents.storage.feed

import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository : JpaRepository<FeedEntity, Long>
