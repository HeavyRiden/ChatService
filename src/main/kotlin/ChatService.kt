class ChatService(
    private var listOfChat: MutableList<Chat> = mutableListOf()
) {
    fun readChatList(): MutableList<Chat> { // Возвращает список всех чатов
        return listOfChat
    }

    fun sendMessage(idChatPartner: Long, mess: String): Boolean {
        return listOfChat.find { it.getIdChat() == idChatPartner }?.addMessage(mess) ?:
        listOfChat.add(Chat(idChatPartner).apply { addMessage(mess) })
    }

    fun deleteMessage(idChatPartner: Long, messageId: Long): Boolean { // Удаляет сообщение в чате с собеседником
        return listOfChat.find { it.getIdChat() == idChatPartner }?.deleteMessage(messageId) ?: false
    }
}