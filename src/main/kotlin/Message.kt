data class Message(
    private var message: String, // Текст сообщения
    private val idMessage: Long // Идентификатор сообщения
) {
    var read: Boolean = false // True если сообщение прочитано и false, если нет

    override fun toString(): String { // Возвращает текст сообщения
        return message
    }

    fun getId(): Long {
        return idMessage
    }

}