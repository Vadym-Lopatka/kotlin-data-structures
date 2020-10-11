package trie

interface Trie {
    fun add(word: String)
    fun remove(word: String):Boolean
    fun isPresent(word: String):Boolean
    fun getAllByPrefix(prefix: String): Set<String>
}
