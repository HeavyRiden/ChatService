fun main() {
    val chat = ChatService()
    chat.sendMessage(1, "Привет")
    chat.sendMessage(1, "И тебе привет")
    chat.sendMessage(1, "Как дела?")
    chat.sendMessage(1, "Все хорошо, спасибо")
    chat.sendMessage(2, "Где деньги?")
    chat.deleteMessage(1, 2)
    chat.deleteMessage(1, 1)
    chat.deleteMessage(1, 5)
    chat.getListOfSomeMessage(1, 3)
    chat.getListOfLastMessages()
    println(chat.getUnreadChatsCount())
}