package br.com.nuone.forum.mapper

interface Mapper<T, U> {
    fun map(t: T ): U
}
