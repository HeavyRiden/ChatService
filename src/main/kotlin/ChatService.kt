class ChatService(
    private var listOfChat: MutableList<Chat> = mutableListOf()
) {
    fun readChatList(): MutableList<Chat> {
        return listOfChat
    }

    fun sendMessage(idChatPartner: Long, mess: String) {
    }

}