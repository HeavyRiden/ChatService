import org.junit.Test

import org.junit.Assert.*

class ChatTest {

    private val chat = Chat(1)

    @Test
    fun addMessage() {
        assertTrue(chat.addMessage("Привет"))
    }

    @Test
    fun deleteMessage() {
        assertFalse(chat.deleteMessage(1))
    }

    @Test
    fun deleteMessageTrue() {
        chat.addMessage("Привет")
        assertTrue(chat.deleteMessage(1))
    }

    @Test
    fun getChatId() {
        assertEquals(chat.getIdChat(), 1)
    }

    @Test
    fun editMessage() {
        assertFalse(chat.editMessage(1, "Пока"))
    }

    @Test
    fun editMessageTrue() {
        chat.addMessage("Привет")
        assertTrue(chat.editMessage(1, "Пока"))
    }

    @Test
    fun getListOfMessage() {
        chat.addMessage("Привет")
        assertEquals(chat.getListOfMessage(1), listOf(Message("Привет", 1)))
    }

    @Test
    fun getListOfMessageEmptyList() {
        assertEquals(chat.getListOfMessage(1), listOf(Message("Сообщений нет", 1)))
    }

    @Test
    fun getLastMessage() {
        chat.addMessage("Привет")
        assertEquals(chat.getLastMessage(),"Привет")
    }

    @Test
    fun getLastMessageEmptyList() {
        assertEquals(chat.getLastMessage(),"Сообщений нет")
    }

    @Test
    fun readChatStatus() {
        chat.addMessage("Привет")
        assertFalse(chat.getReadChatStatus())
    }

    @Test
    fun readChatStatusTrue() {
        chat.addMessage("Привет")
        chat.readChat()
        assertTrue(chat.getReadChatStatus())
    }

    @Test
    fun chatToString() {
        assertEquals(chat.toString(), "Собеседник 1 - Сообщений нет\n")
    }

    @Test
    fun chatToStringWithText() {
        chat.addMessage("Привет")
        assertEquals(chat.toString(), "Собеседник 1 - [Привет]\n")
    }
}