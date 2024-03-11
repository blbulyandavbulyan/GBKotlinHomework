package commandinterpreter

class Person(val name: String) {
    private val phones: MutableCollection<String> = mutableSetOf()
    private val emails: MutableCollection<String> = mutableSetOf()
    fun addPhone(phone: String) = phones.add(phone)
    fun addEmail(email: String) = emails.add(email)
    fun containsPhone(phone: String): Boolean = phone in phones
    fun containsEmail(email: String): Boolean = email in emails
    override fun toString(): String {
        return "Person(name='$name', phones=$phones, emails=$emails)"
    }
}
