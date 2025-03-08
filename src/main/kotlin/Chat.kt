data class Chat(
    private val idChatPartner: Long // Идентификатор собеседника
) {
    private var messageList: MutableList<Message> = mutableListOf() // Список сообщений в чате
    private var idMessage: Long = 1 // Начальный идентификатор сообщения
    private var readChat: Boolean = false // True, если все сообщения в чате прочитаны и false, если нет

    fun addMessage(mess: String): Boolean { // Добавление сообщения в чат
        messageList.add(Message(mess, idMessage))
        idMessage++
        readChat = false
        return true
    }

    fun deleteMessage(idMessage: Long): Boolean { //Удаляет сообщение по его идентификатору
        return messageList.removeAll { it.getId() == idMessage }
    }

    fun getIdChat(): Long { // Возвращает идентификатор собеседника
        return idChatPartner
    }

    fun editMessage(idMessage: Long, mess: String): Boolean { // Редактирует сообщение по id
        return messageList.find { it.getId() == idMessage }
            ?.run {
                this.editMess(mess)
                this.setReadStatus()
            } ?: false
    }

    fun getListOfMessage(numberOfMessage: Int): List<Message> { // Возвращает список последних n сообщений
        return messageList
            .reversed()
            .asSequence()
            .take(numberOfMessage)
            .onEach { it.setReadStatus() }
            .toList()
            .ifEmpty { listOf(Message("Сообщений нет", 1)) }
    }

    fun getLastMessage(): String { // Возвращает последнее сообщение в чате и "Сообщений нет", если чат пуст
        return messageList.lastOrNull()?.let {
            it.setReadStatus()
            it.toString()
        } ?: "Сообщений нет"
    }

    fun getReadChatStatus(): Boolean { // Обновляем состояние, если все сообщения прочитаны
        readChat = messageList
            .asSequence()
            .all { it.readStatus() }
        return readChat
    }

    fun readChat(): Boolean { // Помечает чат как "прочитанный"
        readChat = true
        return true
    }


    override fun toString(): String { // Возвращает список сообщений в чате
        return "Собеседник $idChatPartner - " +
                if (messageList.isNotEmpty()) messageList.toString() + "\n"
                else "Сообщений нет\n"
    }
}
