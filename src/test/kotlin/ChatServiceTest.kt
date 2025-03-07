import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    val chatService = ChatService()

    @Test
    fun addMessage() {
        assertTrue(chatService.sendMessage(1, "Привет"))
    }

    @Test
    fun addMessageForExistingChat() {
        chatService.sendMessage(1, "Привет")
        assertTrue(chatService.sendMessage(1, "Пока"))
    }

    @Test
    fun addMessageForNewChat() {
        chatService.sendMessage(1, "Привет")
        assertTrue(chatService.sendMessage(8, "Привет"))
    }

    @Test
    fun getListOfChat() {
        chatService.sendMessage(1, "Привет")
        assertEquals(
            chatService.getChatList(), listOf(
                Chat(1).apply
                { this.addMessage("Привет") })
        )
    }

    @Test
    fun deleteMessage() {
        chatService.sendMessage(1, "Привет")
        assertTrue(chatService.deleteMessage(1, 1))
    }

    @Test
    fun deleteMessageTwo() {
        chatService.sendMessage(1, "Привет")
        assertFalse(chatService.deleteMessage(2, 1))
    }

    @Test
    fun deleteMessageThree() {
        chatService.sendMessage(1, "Привет")
        assertFalse(chatService.deleteMessage(2, 2))
    }

    @Test
    fun deleteMessageFour() {
        chatService.sendMessage(1, "Привет")
        assertFalse(chatService.deleteMessage(1, 2))
    }

    @Test
    fun editMessage() {
        chatService.sendMessage(1, "Привет")
        assertTrue(chatService.editMessage(1, 1, "Hello"))
    }

    @Test
    fun editMessageTwo() {
        chatService.sendMessage(1, "Привет")
        assertFalse(chatService.editMessage(1, 2, "Hello"))
    }

    @Test
    fun editMessageThree() {
        chatService.sendMessage(1, "Привет")
        assertFalse(chatService.editMessage(2, 1, "Hello"))
    }

    @Test
    fun editMessageFour() {
        chatService.sendMessage(1, "Привет")
        assertFalse(chatService.editMessage(2, 2, "Hello"))
    }

    @Test
    fun deleteChat() {
        chatService.sendMessage(1, "Привет")
        assertTrue(chatService.deleteChat(1))
    }

    @Test
    fun deleteChatTwo() {
        chatService.sendMessage(1, "Привет")
        assertFalse(chatService.deleteChat(2))
    }

    @Test
    fun getListOfSomeMessages() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(1, "И тебе")
        assertEquals(
            chatService.getListOfSomeMessage(1, 2),
            listOf(Message("Привет", 1), Message("И тебе", 2))
        )
    }

    @Test
    fun getListOfSomeMessagesTwo() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(1, "И тебе")
        assertEquals(
            chatService.getListOfSomeMessage(1, 3),
            listOf(Message("Привет", 1), Message("И тебе", 2))
        )
    }

    @Test
    fun getListOfSomeMessagesThree() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(1, "И тебе")
        assertEquals(
            chatService.getListOfSomeMessage(1, 1),
            listOf(Message("И тебе", 2))
        )
    }

    @Test
    fun getListOfSomeMessagesFour() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(1, "И тебе")
        assertEquals(
            chatService.getListOfSomeMessage(2, 1),
            listOf(Message("Чат не найден", 1))
        )
    }

    @Test
    fun getListOfSomeMessagesFive() {
        chatService.sendMessage(1, "Привет")
        chatService.deleteMessage(1, 1)
        assertEquals(
            chatService.getListOfSomeMessage(1, 1),
            listOf(Message("Сообщений нет", 1))
        )
    }

    @Test
    fun getListOfSomeMessageSix() {
        chatService.sendMessage(1, "Привет")
        assertEquals(
            chatService.getListOfSomeMessage(1, 4),
            listOf(Message("Привет", 1))
        )
    }

    @Test
    fun getListOfLastMessages() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(1, "И тебе")
        assertEquals(
            chatService.getListOfLastMessages(),
            listOf("И тебе")
        )
    }

    @Test
    fun getUnreadChates() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(2, "И тебе")
        assertEquals(
            chatService.getUnreadChatsCount(), 2
        )
    }

    @Test
    fun getUnreadChatesTwo() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(2, "И тебе")
        chatService.getChatList()
        assertEquals(
            chatService.getUnreadChatsCount(), 0
        )
    }

    @Test
    fun getUnreadChatesThree() {
        chatService.sendMessage(1, "Привет")
        chatService.sendMessage(2, "И тебе")
        chatService.getListOfSomeMessage(1, 1)
        assertEquals(
            chatService.getUnreadChatsCount(), 1
        )
    }


}