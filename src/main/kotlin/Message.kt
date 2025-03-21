data class Message(
    private var message: String, // Текст сообщения
    private val idMessage: Long // Идентификатор сообщения
) {
    private var read: Boolean = false // True если сообщение прочитано и false, если нет

    override fun toString(): String { // Возвращает текст сообщения
        return message
    }

    fun getId(): Long { // Возвращает id сообщения
        return idMessage
    }

    fun editMess(mess: String) { // Редактирует сообщение
        message = mess
    }

    fun setReadStatus(): Boolean {
        read = true
        return read
    }

    fun readStatus(): Boolean {
        return read
    }
}