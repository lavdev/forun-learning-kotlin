package br.com.nuone.forun.mapper

interface Mapper<T, U> {
    fun map(t: T ): U
}
