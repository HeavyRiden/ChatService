data class Chat(
    private val idChatPartner: Long // Идентификатор собеседника
) {
    private var messageList: MutableList<Message> = mutableListOf() // Список сообщений в чате
    private var idMessage: Long = 1L
    private var readMessage: Boolean = false // True, если все сообщения в чате прочитаны и false, если нет

    fun addMessage(mess: String) {
        val message = Message(
            mess,
            idMessage
        )
        idMessage += 1L
        messageList.add(message)
    }

    override fun toString(): String {
        return messageList.toString()
    }

    fun getIdChatPartner(): MutableList<Message> {
        return messageList
    }
}
