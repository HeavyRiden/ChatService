
fun main() {
    val chat = ChatService()
    chat.sendMessage(1, "Привет")
    chat.sendMessage(1, "И тебе привет")
    chat.sendMessage(1, "Как дела?")
    chat.sendMessage(1, "Все хорошо, спасибо")
    chat.sendMessage(2, "Где деньги?")
    chat.editMessage(2, 1, "Какие деньги?")
    val ch = Chat(5)
    //ch.addMessage("Привет")
    println( ch.getReadChatStatus())
}