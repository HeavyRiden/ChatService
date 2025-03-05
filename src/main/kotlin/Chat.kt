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

    fun editMessage(idMessage: Long, mess: String): Boolean { // Редактирует сообщение по id
        return messageList.find { it.getId() == idMessage }?.let {
            it.editMess(mess)
            it.read = true
            true
        } == true
    }

    fun getListOfMessage(numberOfMessage: Int): List<Message> { // Возвращает список последних n сообщений
        val listOfMess = messageList.takeLast(numberOfMessage)
        return if(listOfMess.isEmpty()) listOf(Message("Сообщений нет", 1))
        else listOfMess
    }

    fun getLastMessage(): String { // Возвращает последнее сообщение в чате и "Сообщений нет", если чат пуст
        val mess = messageList.lastOrNull() ?: "Сообщений нет"
        return mess.toString()
    }

    fun readChat(): Boolean {
        readMessage = true
        return true
    }

    fun getReadChat(): Boolean {
        return readMessage
    }

    override fun toString(): String { // Возвращает список сообщений в чате
        return "Собеседник $idChatPartner - " +
                if (messageList.isNotEmpty()) messageList.toString() + "\n"
                else "Сообщений нет\n"
    }
}
