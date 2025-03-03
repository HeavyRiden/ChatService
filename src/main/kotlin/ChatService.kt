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
        return listOfChat.find { it.getIdChat() == idChatPartner }?.deleteMessage(messageId) == true
    }

    fun editMessage(idChatPartner: Long, messageId: Long, mess: String): Boolean { // Редактирует сообщение по id
        return listOfChat.find { it.getIdChat() == idChatPartner }?.editMessage(messageId, mess) == true
    }

    fun deleteChat(idChatPartner: Long): Boolean { // Удаляет чат по id собеседника
        return listOfChat.removeAll { it.getIdChat() == idChatPartner }
    }

    fun getListOfMessage(idChatPartner: Long, numberOfMessage: Int): List<Message> { // Возвращает список последних n сообщений
        return listOfChat.find { it.getIdChat() == idChatPartner }?.getListOfMessage(numberOfMessage) ?: emptyList()
    }
}