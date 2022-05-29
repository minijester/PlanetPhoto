package com.miharu.planetphoto.core.extension

import android.view.View
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow

fun View.clickAsFlow(): Flow<View> {
    return Channel<View>(capacity = Channel.UNLIMITED).also { channel ->
        this.setOnClickListener {
            channel.trySend(it).isSuccess
        }
    }.consumeAsFlow()
        .throttleFirst()
}