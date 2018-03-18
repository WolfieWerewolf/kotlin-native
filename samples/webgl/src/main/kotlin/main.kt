import kotlinx.interop.wasm.dom.*
import kotlinx.wasm.jsinterop.*

fun getVertShaderSource(): String {
    return "attribute vec3 aVertexPosition;\n"+
            "void main(void) {\n"+
            "   gl_Position = vec4(aVertexPosition, 1.0);\n"+
            "}"
}

fun getFragShaderSource(): String {
    return "precision highp float;\n"+
            "void main(void) {\n"+
            "   gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n"+
            "}"
}

fun doClear(gl: WebGLRenderingContext){
    gl.clearColor(0.0, 1.0, 2.0, 1.0)
    gl.clear(gl.COLOR_BUFFER_BIT)
}

fun main(args: Array<String>) {
    val canvas = document.getElementById("glCanvas").asCanvas
    val gl = canvas.getContext("webgl").asWebGLRenderingContext

    //println(gl.VERTEX_SHADER)
    //println(gl.FRAGMENT_SHADER)

    /** Compile Vertex Sader */
    val vertShader = gl.createShader(gl.VERTEX_SHADER)
    val vertSource = getVertShaderSource()

    println(vertShader)

    //console.log(vertShader)

    //gl.shaderSource(vertShader, vertSource)

    //gl.compileShader(vertShader)


    //println(vertShader)

    //println("getVertShaderSource---------------------")
    //println(getVertShaderSource())

    //println("getFragShaderSource---------------------")
    //println(getFragShaderSource())

    doClear(gl)

    //val hello = HelloWebGL(canvas, gl)
    //hello.draw()
}