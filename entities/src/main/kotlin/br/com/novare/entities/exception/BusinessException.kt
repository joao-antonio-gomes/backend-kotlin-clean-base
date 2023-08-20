package br.com.novare.entities.exception

open class BusinessException(
    override val message: String,
    open val status: Int = 400
) : RuntimeException() {
}
