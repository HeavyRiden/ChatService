class ChatService(
    private var listOfChat: MutableList<Chat> = mutableListOf()
) {
    fun readChatList(): MutableList<Chat> {
        return listOfChat
    }

    fun sendMessage(idChatPartner: Long, mess: String): Boolean {
        for (chat in listOfChat) {
            if (chat.getIdChat() == idChatPartner) {
                chat.addMessage(mess)
                return true
            }
        }
        val chat = Chat(idChatPartner)
        chat.addMessage(mess)
        listOfChat.add(chat)
        return false
    }
}