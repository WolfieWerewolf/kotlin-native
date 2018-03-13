import platform.iconv.*
import kotlinx.cinterop.*

fun main(args: Array<String>) {

    val source = "Hello!"
    val sourceByteArray = source.toUtf8()

    val golden = listOf(0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x21)

    memScoped {

        val sourceLength = alloc<LongVar>()
        val destLength = alloc<LongVar>()

        val sourceBytes = allocArrayOf(sourceByteArray)
        val destBytes = allocArray<ByteVar>(golden.size)

        val sourcePtr = alloc<CArrayPointerVar<ByteVar>>()
        sourcePtr.value = sourceBytes

        val destPtr = alloc<CArrayPointerVar<ByteVar>>()
        destPtr.value = destBytes

        sourceLength.value = sourceByteArray.size.toLong();
        destLength.value = golden.size.toLong();

        val conversion = iconv_open("UTF-8", "LATIN1")

        iconv(conversion, sourcePtr.ptr, sourceLength.ptr, destPtr.ptr, destLength.ptr)

        golden.forEachIndexed { index, it ->
            println("$it ${destBytes[index]}")
            it == destBytes[index].toInt()
        }

        iconv_close(conversion)
    }
}
