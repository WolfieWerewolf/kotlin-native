package org.jetbrains.kotlin.native.interop.gen.wasm.idl

/** This shall be an output of Web IDL parser. */
val idlDom = listOf(
//        Interface("CanvasRenderingContext2D",
//                Attribute("lineWidth", idlInt),
//                Attribute("fillStyle", idlString),
//                Attribute("strokeStyle", idlString),
//
//                Operation("lineTo", idlVoid, Arg("x", idlInt), Arg("y", idlInt)),
//                Operation("moveTo", idlVoid, Arg("x", idlInt), Arg("y", idlInt)),
//                Operation("beginPath", idlVoid),
//                Operation("stroke", idlVoid),
//                Operation("fillRect", idlVoid, Arg("x", idlInt), Arg("y", idlInt), Arg("width", idlInt), Arg("height", idlInt)),
//                Operation("fillText", idlVoid, Arg("test", idlString), Arg("x", idlInt),  Arg("y", idlInt), Arg("maxWidth", idlInt)),
//                Operation("fill", idlVoid),
//                Operation("closePath", idlVoid)
//        ),
        Interface("WebGLShader"),
        Interface("WebGLRenderingContext",
                Attribute("COLOR_BUFFER_BIT", idlInt, readOnly = true),
                Attribute("VERTEX_SHADER", idlInt, readOnly = true),
                Attribute("FRAGMENT_SHADER", idlInt, readOnly = true),
                Operation("createShader", idlInterfaceRef("WebGLShader"), false, Arg("type", idlInt)),
                //Operation("shaderSource", idlVoid, Arg("shader", idlInterfaceRef("WebGLShader")), Arg("source", idlString)),
                //Operation("compileShader", idlVoid, Arg("shader", idlObject)),

                Operation("clearColor", idlVoid, false, Arg("r", idlDouble), Arg("g", idlDouble), Arg("b", idlDouble), Arg("a", idlDouble)),
                Operation("clear", idlVoid, Arg("mask", idlInt))
        ),
        Interface("DOMRect",
                Attribute("left", idlInt),
                Attribute("right", idlInt),
                Attribute("top", idlInt),
                Attribute("bottom", idlInt)
        ),
        Interface("Canvas",
                //Operation("getContext", idlInterfaceRef("CanvasRenderingContext2D"), Arg("context", idlString)),
                Operation("getContext", idlInterfaceRef("WebGLRenderingContext"), Arg("context", idlString)),
                Operation("getBoundingClientRect", idlInterfaceRef("DOMRect"))
        ),
        Interface("Document",
                Operation("getElementById", idlObject, Arg("id", idlString))
        ),
        Interface("MouseEvent",
                Attribute("clientX", idlInt, readOnly = true),
                Attribute("clientY", idlInt, readOnly = true)
        ),
        Interface("Response",
                Operation("json", idlObject)
        ),
        Interface("Promise",
                Operation("then", idlInterfaceRef("Promise"), Arg("lambda", idlFunction))
        ),
        Interface("Console",
                Operation("log", idlVoid, Arg("msg", idlString))
                //Operation("log", idlVoid, Arg("msg", idlInterfaceRef))
        ),

        Interface("__Global",
                Attribute("document", idlInterfaceRef("Document"), readOnly = true),
                Operation("fetch", idlInterfaceRef("Promise"), Arg("url", idlString)),
                Attribute("console", idlInterfaceRef("Console"), readOnly = true),
                Operation("setInterval", idlVoid, Arg("lambda", idlFunction), Arg("interval", idlInt))
        )
)