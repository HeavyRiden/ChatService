fun main() {
    val chat = Chat(1)
    chat.addMessage("Привет")
    chat.addMessage("И тебе")
    chat.addMessage("Как дела?")
    chat.addMessage("Нормально")

    println(chat.getIdChatPartner())
}