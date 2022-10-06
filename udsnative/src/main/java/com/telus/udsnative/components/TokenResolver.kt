package com.telus.udsnative.components


interface Tokens
interface Variant

interface TokenResolver {
    fun resolveTokens(_variant: Variant): Tokens
}