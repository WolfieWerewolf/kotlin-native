import kotlinx.interop.wasm.dom.*
import kotlinx.wasm.jsinterop.*

fun main(args: Array<String>) {

    val canvas = document.getElementById("myCanvas").asCanvas
    val gl = canvas.getContext("webgl")
    //var a: Double = 1.0
    //gl.clearColor(0, 1, 2, a)
    //gl.clear(gl.COLOR_BUFFER_BIT)
    doClear(gl)
}

fun doClear(gl: WebGLRenderingContext){
    //var a: Double = 1.0
    gl.clearColor(0.0, 1.0, 2.0, 1.0)
    gl.clear(gl.COLOR_BUFFER_BIT)

}



//var a: Double = 56.3
//gl.clearColor(0, 1, 2, 1)

//val myabs = abs(-100)
//println(myabs)


//val resultF1 = f1()

//val resultF2 = f2()
//println(resultF2)
//println("-----")


//@Used
//public fun f2(): Double {
//    var a: Double = 56.3
//    return a
//}


//    val rect = canvas.getBoundingClientRect()
//    val rectLeft = rect.left
//    val rectTop = rect.top
//
//    var mouseX: Int = 0
//    var mouseY: Int = 0
//    var draw: Boolean = false
//
//    document.setter("onmousemove") { arguments: ArrayList<JsValue> ->
//        val event = MouseEvent(arguments[0])
//        mouseX = event.getInt("clientX") - rectLeft
//        mouseY = event.getInt("clientY") - rectTop
//
//        if (mouseX < 0) mouseX = 0
//        if (mouseX > 639) mouseX = 639
//        if (mouseY < 0) mouseY = 0
//        if (mouseY > 479) mouseY = 479
//    }
//
//    document.setter("onmousedown") {
//        draw = true
//    }
//
//    document.setter("onmouseup") {
//        draw = false
//    }
//
//    setInterval(10) {
//        if (draw) {
//            ctx.strokeStyle = "#222222"
//            ctx.lineTo(mouseX, mouseY)
//            ctx.stroke()
//        } else {
//            ctx.moveTo(mouseX, mouseY)
//            ctx.stroke()
//        }
//    }
