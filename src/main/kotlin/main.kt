fun main() {
    val chat = ChatService()
    chat.sendMessage(1, "Привет")
    chat.sendMessage(1, "И тебе привет")
    chat.sendMessage(2, "Привет, как дела?")
    chat.sendMessage(2, "Все хорошо, спасибо")
    chat.sendMessage(3, "Где деньги?")
    chat.sendMessage(3, "Какие деньги?")
    println(chat.readChatList())
}