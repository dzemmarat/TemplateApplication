@file:Suppress("unused")

package ru.mrz.core.common.extensions

fun <T> zip(vararg lists: List<T>): List<List<T>> {
    return zip(*lists, transform = { it })
}

private inline fun <T, V> zip(vararg lists: List<T>, transform: (List<T>) -> V): List<V> {
    val minSize = lists.minOfOrNull(List<T>::size) ?: return emptyList()

    val list = ArrayList<V>(minSize)
    val iterators = lists.map { it.iterator() }

    repeat(minSize) {
        list.add(transform(iterators.map { it.next() }))
    }

    return list
}
