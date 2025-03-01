fun main() {
    var message = Message(1, 1, "Первое сообщение")
    println(message)
    message.editMessage("Редактирование")
    println(message)
}