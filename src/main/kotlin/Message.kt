data class Message(
    private val idMessage: Long, // Идентификатор сообщения
    private val isMine: Boolean, // Сообщение мое(true) или собеседника(false)
    private var message: String // Текст сообщения
) {
    var read: Boolean = false // True если сообщение прочитано и False, если нет

    fun editMessage(message: String) { // Редактирование текста сообщения
        this.message = message
    }

    fun getId(message: Message): Long{ // Возвращает id сообщения
        return idMessage
    }

    override fun toString(): String { // Возвращает текст сообщения
        return message
    }

}