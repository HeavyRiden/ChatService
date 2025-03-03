data class Chat(
    private val idChatPartner: Long // Идентификатор собеседника
) {
    private var messageList: MutableList<Message> = mutableListOf() // Список сообщений в чате
    private var idMessage: Long = 1
    private var readMessage: Boolean = false // True, если все сообщения в чате прочитаны и false, если нет

    fun addMessage(mess: String): Boolean { // Добавление сообщения в чат
        messageList.add(Message(mess, idMessage))
        idMessage++
        return true
    }

    fun deleteMessage(idMessage: Long): Boolean { //Удаляет сообщение по его идентификатору
        return messageList.removeAll { it.getId() == idMessage }
    }

    fun getIdChat(): Long { // Возвращает идентификатор собеседника
        return idChatPartner
    }

    override fun toString(): String { // Возвращает список сообщений в чате
        return "Собеседник $idChatPartner - " +
                if (messageList.isNotEmpty()) messageList.toString() + "\n"
                else "Сообщений нет\n"
    }
}
