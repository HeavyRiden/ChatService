data class Message(
    private val idMessage: Long, // Идентификатор сообщения
    private val isMine: Boolean, // Сообщение мое(true) или собеседника(false)
    private var message: String // Текст сообщения
) {
    var visible: Boolean = false

    fun editMessage(message: String) {
        this.message = message
    }

    fun getId(message: Message): Long{
        return idMessage
    }

}