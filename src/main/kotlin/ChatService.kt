class ChatService(
    private var listOfChat: MutableList<Chat> = mutableListOf()
) {

    fun sendMessage( // Создает новый чат или добавляет сообщение в существующий
        idChatPartner: Long,
        mess: String
    ): Boolean {
        return listOfChat.find { it.getIdChat() == idChatPartner }
            ?.addMessage(mess)
            ?: listOfChat.add(
                Chat(idChatPartner)
                    .apply { this.addMessage(mess) })
    }

    fun getChatList(): MutableList<Chat> { // Возвращает список всех чатов
        listOfChat
            .asSequence()
            .forEach { it.setReadChat() }
        return listOfChat
    }

    fun deleteMessage(idChatPartner: Long, messageId: Long): Boolean { // Удаляет сообщение в чате с собеседником
        return listOfChat
            .find { it.getIdChat() == idChatPartner }
            ?.deleteMessage(messageId)
            ?: false
    }

    fun editMessage(idChatPartner: Long, messageId: Long, mess: String): Boolean { // Обновляет сообщение
        return listOfChat
            .find { it.getIdChat() == idChatPartner }
            ?.run {
                if (this.editMessage(messageId, mess)) {
                    this.getReadChatStatus()
                } else {
                    false
                }
            } ?: false
    }

    fun deleteChat(idChatPartner: Long): Boolean { // Удаляет чат по id собеседника
        return listOfChat
            .removeAll { it.getIdChat() == idChatPartner }
    }

    fun getListOfSomeMessage( // Возвращает список последних n сообщений
        idChatPartner: Long,
        numberOfMessage: Int
    ): List<Message> {
        return listOfChat
            .find { it.getIdChat() == idChatPartner }
            ?.getListOfMessage(numberOfMessage)
            ?: listOf(
                Message("Чат не найден", 1)
            )
    }

    fun getListOfLastMessages(): List<String> { // Возвращает список последних сообщений во всех чатах
        return listOfChat
            .map { it.getLastMessage() }
    }

    fun getUnreadChatsCount(): Long { // Возвращает количество непрочитанных чатов
        return listOfChat
            .count { !it.getReadChatStatus() }.toLong()
    }
}