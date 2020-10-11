package trie

class Trie {
    private val root = Node(content = '*')

    fun add(word: String) {
        var current = root
        var children = root.children

        for (i in word.indices) {
            val ch = word[i]

            val node = if (current.children.containsKey(ch)) {
                current = current.children[ch]!!
                current
            } else {
                val newNode = Node(content = ch)
                children[ch] = newNode
                newNode
            }

            children = node.children

            if (i == (word.length - 1)) {
                node.isTheEndOfWord = true
            }
        }
    }

    fun remove(word: String): Boolean {
        TODO("Not yet implemented")
    }

    fun isPresent(word: String): Boolean {
        return findNode(word)?.takeIf { it.isTheEndOfWord }
            ?.let { true }
            ?: kotlin.run { false }
    }

    private fun findNode(word: String): Node? {
        var children = root.children
        var lastNode: Node? = null

        for (i in word.indices) {
            val ch = word[i]
            if (children.containsKey(ch)) {
                lastNode = children[ch]!!
                children = lastNode.children
            } else {
                return null
            }
        }

        return lastNode
    }

    fun getAllByPrefix(prefix: String): Set<String> {
        TODO("Not yet implemented")
    }

    fun isEmpty(): Boolean {
        return root.children.isEmpty()
    }
}

data class Node(
    val children: MutableMap<Char, Node> = mutableMapOf(),
    var content: Char,
    var isTheEndOfWord: Boolean = false
)
