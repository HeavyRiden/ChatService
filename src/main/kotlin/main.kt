fun main() {
    var message = Message(1, false, "Первое сообщение")
    println(message)
    message.editMessage("Редактирование")
    println(message)
    println(message.getId(message))
}