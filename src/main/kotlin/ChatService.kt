class ChatService(
    private var listOfChat: MutableList<Chat> = mutableListOf()
) {
    fun readChatList(): MutableList<Chat> { // Возвращает список всех чатов
        return listOfChat
    }

    fun sendMessage(idChatPartner: Long, mess: String): Boolean { //Создает новый чат и добавляет
        for (chat in listOfChat) {                                //первое сообщение или
            if (chat.getIdChat() == idChatPartner) {              //добавляет сообщение к существующему чату
                chat.addMessage(mess)
                return true
            }
        }
        val chat = Chat(idChatPartner)
        chat.addMessage(mess)
        listOfChat.add(chat)
        return false
    }

    fun deleteMessage(idChatPartner: Long, idMessage: Long): Boolean { // Удаляет сообщение в конкретном
        for (chat in listOfChat) {                                     // чате
            if (chat.getIdChat() == idChatPartner) {
                return chat.delMessage(idMessage)
            }
        }
        return false
    }
}