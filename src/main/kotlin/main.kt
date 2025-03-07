fun main() {
    val chat = ChatService()
    chat.sendMessage(1, "Привет")
    chat.sendMessage(1, "И тебе привет")
    chat.sendMessage(1, "Как дела?")
    chat.sendMessage(1, "Все хорошо, спасибо")
    chat.sendMessage(2, "Где деньги?")
    chat.deleteMessage(2, 1)
    println( chat.getListOfSomeMessage(2, 2))
    //chat.getListOfLastMessages()
    //println(chat.getUnreadChatsCount())
    //val chatNew = Chat(1)
    //println(chatNew.toString())

}