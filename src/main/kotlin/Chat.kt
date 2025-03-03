data class Chat(
    private val idChatPartner: Long // Идентификатор собеседника
) {
    private var messageList: MutableList<Message> = mutableListOf() // Список сообщений в чате
    private var idMessage: Long = 1
    private var readMessage: Boolean = false // True, если все сообщения в чате прочитаны и false, если нет

    fun addMessage(mess: String) {
        val message = Message(
            mess,
            idMessage
        )
        idMessage += 1
        messageList.add(message)
    }

    override fun toString(): String {
        return "Cобеседник $idChatPartner$messageList\n"
    }

    fun getIdChat(): Long {
        return idChatPartner
    }

    fun getChatMessage(): MutableList<Message> {
        return messageList
    }
}
