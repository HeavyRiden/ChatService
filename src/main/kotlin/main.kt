fun main() {
    val chat = ChatService()
    chat.sendMessage(1, "Привет")
    chat.sendMessage(1, "И тебе привет")
    chat.sendMessage(1, "Как дела?")
    chat.sendMessage(1, "Все хорошо, спасибо")
    chat.sendMessage(2, "Где деньги?")
    chat.sendMessage(2, "Какие деньги?")
    chat.deleteMessage(2, 1)
    chat.deleteMessage(2, 2)
    chat.editMessage(2, 2, "Пока")
    chat.readChatList()
    println(chat.readChatStatus())
}