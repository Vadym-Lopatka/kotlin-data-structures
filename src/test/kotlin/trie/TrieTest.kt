package trie

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TrieTest {

    @Test
    fun `should create trie with root element`() {
        // given
        val trie = Trie()

        // when
        val result = trie.isEmpty()

        // then
        assertTrue(result)
    }

    @Test
    fun `should answere false when trie is not empty`() {
        // given
        val trie = Trie()
        val testWord = "Hello"

        // when
        trie.add(testWord)

        // then
        assertFalse(trie.isEmpty())
    }

    @Test
    fun `should find added word`() {
        // given
        val trie = Trie()
        val testWord = "Hello"

        // when
        trie.add(testWord)

        // then
        assertTrue(trie.isPresent(testWord))
    }
}
