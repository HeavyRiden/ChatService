data class Chat(
    private val idChatPartner: Long // Идентификатор собеседника
) {
    private var messageList: MutableList<Message> = mutableListOf() // Список сообщений в чате
    private var idMessage: Long = 1 // Начальный идентификатор сообщения
    private var readMessage: Boolean = false // True, если все сообщения в чате прочитаны и false, если нет

    fun addMessage(mess: String): Boolean { // Добавление сообщения в чат
        messageList.add(Message(mess, idMessage))
        idMessage++
        readMessage = false
        return true
    }

    fun deleteMessage(idMessage: Long): Boolean { //Удаляет сообщение по его идентификатору
        return messageList.removeAll { it.getId() == idMessage }
    }

    fun getIdChat(): Long { // Возвращает идентификатор собеседника
        return idChatPartner
    }

    fun editMessage(idMessage: Long, mess: String): Boolean { // Редактирует сообщение по id
        return messageList.find { it.getId() == idMessage }?.let {
            it.editMess(mess)
            it.setReadStatus()
            true
        } == true
    }

    fun getListOfMessage(numberOfMessage: Int): List<Message> { // Возвращает список последних n сообщений
        val listOfMess = messageList.takeLast(numberOfMessage)
        listOfMess.forEach { it.setReadStatus() }
        return if (listOfMess.isEmpty()) listOf(Message("Сообщений нет", 1))
        else listOfMess
    }

    fun getLastMessage(): String { // Возвращает последнее сообщение в чате и "Сообщений нет", если чат пуст
        val lastMessage = messageList.lastOrNull()
        return if (lastMessage != null) {
            lastMessage.setReadStatus()
            lastMessage.toString()
        } else {
            "Сообщений нет"
        }
    }

    fun getReadChatStatus(): Boolean {
        if (messageList.all { it.readStatus() }) readMessage = true // Обновляем состояние, если все сообщения прочитаны
        return readMessage
    }

    fun readChat(): Boolean { // Помечает чат как "прочитанный"
        readMessage = true
        return true
    }


    override fun toString(): String { // Возвращает список сообщений в чате
        return "Собеседник $idChatPartner - " +
                if (messageList.isNotEmpty()) messageList.toString() + "\n"
                else "Сообщений нет\n"
    }
}
