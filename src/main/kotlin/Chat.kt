data class Chat(
    private val idChatPartner: Long // Идентификатор собеседника
) {
    private var messageList: MutableList<Message> = mutableListOf() // Список сообщений в чате
    private var idMessage: Long = 1
    private var readMessage: Boolean = false // True, если все сообщения в чате прочитаны и false, если нет

    fun addMessage(mess: String) { // Добавление сообщения в чат
        val message = Message(
            mess,
            idMessage
        )
        idMessage += 1
        messageList.add(message)
    }

    fun delMessage(idMessage: Long): Boolean { //Удаляет сообщение по его идентификатору
        return messageList.removeAll { it.getId() == idMessage }
    }

    fun getIdChat(): Long { // Возвращает идентификатор собеседника
        return idChatPartner
    }

    override fun toString(): String { // Возвращает список сообщений в чате
        return "Собеседник $idChatPartner " +if (messageList.size != 0) messageList.toString() + "\n"
        else "Сообщений нет\n"
    }
}
