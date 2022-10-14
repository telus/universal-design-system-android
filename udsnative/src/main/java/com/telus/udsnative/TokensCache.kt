package com.telus.udsnative

import com.telus.udsnative.models.Tokens

class TokensCache {
    private val storage: MutableMap<Int, Tokens> = mutableMapOf()

    fun updateCache(key: Int, tokens: Tokens) {
        storage[key] = tokens
    }

    fun tokens(key: Int): Tokens? {
        return storage[key]
    }
}