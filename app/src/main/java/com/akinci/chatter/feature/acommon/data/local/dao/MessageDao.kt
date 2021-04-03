package com.akinci.chatter.feature.acommon.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.akinci.chatter.feature.acommon.data.local.entities.MessageEntity
import com.akinci.chatter.feature.acommon.data.local.entities.relations.MessageWithUser

@Dao
interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllMessages(messages : List<MessageEntity>)

    @Transaction
    @Query("SELECT * FROM messageTable WHERE dataOwnerId = :dataOwnerId")
    suspend fun getAllMessages(dataOwnerId: Long): List<MessageWithUser>

}