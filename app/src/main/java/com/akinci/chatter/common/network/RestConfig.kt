package com.akinci.chatter.common.network

import com.akinci.chatter.BuildConfig

class RestConfig {
    companion object {
        const val API_BASE_URL = BuildConfig.CHATTER_BASE_URL
        const val MESSAGE_HISTORY_URL = BuildConfig.CHATTER_MESSAGE_HISTORY_URL
    }
}