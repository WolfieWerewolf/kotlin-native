import kotlinx.interop.wasm.dom.*
import kotlinx.wasm.jsinterop.*

fun main(args: Array<String>) {

    val canvas = document.getElementById("glCanvas").asCanvas
    val gl = canvas.getContext("webgl")
    doClear(gl)
}

fun doClear(gl: WebGLRenderingContext){
    gl.clearColor(0.0, 1.0, 2.0, 1.0)
    gl.clear(gl.COLOR_BUFFER_BIT)
}