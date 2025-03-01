data class Chat(
    var messageList: MutableList<Message> = mutableListOf(), // Список сообщений в чате
    val idChatPartner: Long // Идентификатор собеседника
)
{
    var readMessage: Boolean = false // True, если все сообщения в чате прочитаны и false, если нет

}
