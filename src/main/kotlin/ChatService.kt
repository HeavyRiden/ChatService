class ChatService(
    private var listOfChat: MutableList<Chat> = mutableListOf()
) {

    fun readChatList(): MutableList<Chat> { // Возвращает список всех чатов
        return listOfChat
    }

    fun sendMessage(idChatPartner: Long, mess: String): Boolean { // Создает новый чат или добавляет сообщение в существующий
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

    fun getListOfSomeMessage(idChatPartner: Long, numberOfMessage: Int): List<Message> { // Возвращает список последних n сообщений
        return listOfChat.find { it.getIdChat() == idChatPartner }!!.getListOfMessage(numberOfMessage)
    }

    fun getListOfLastMessages(): List<String> { // Возвращает список последних сообщений во всех чатах
        return listOfChat.map { it.getLastMessage() }
    }
}