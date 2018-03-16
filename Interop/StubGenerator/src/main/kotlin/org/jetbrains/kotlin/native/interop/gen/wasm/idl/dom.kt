package org.jetbrains.kotlin.native.interop.gen.wasm.idl

// This shall be an output of Web IDL parser.
val idlDom = listOf(
//    Interface("CanvasRenderingContext2D",
//        Attribute("lineWidth", idlInt),
//        Attribute("fillStyle", idlString),
//        Attribute("strokeStyle", idlString),
//
//        Operation("lineTo", idlVoid, Arg("x", idlInt), Arg("y", idlInt)),
//        Operation("moveTo", idlVoid, Arg("x", idlInt), Arg("y", idlInt)),
//        Operation("beginPath", idlVoid),
//        Operation("stroke", idlVoid),
//        Operation("fillRect", idlVoid, Arg("x", idlInt), Arg("y", idlInt), Arg("width", idlInt), Arg("height", idlInt)),
//        Operation("fillText", idlVoid, Arg("test", idlString), Arg("x", idlInt),  Arg("y", idlInt), Arg("maxWidth", idlInt)),
//        Operation("fill", idlVoid),
//        Operation("closePath", idlVoid)
//    ),
        Interface("WebGLRenderingContext",
                Attribute("COLOR_BUFFER_BIT", idlInt),
                //Operation("clearColor", idlVoid, false, Arg("r", idlInt), Arg("g", idlInt), Arg("b", idlInt), Arg("a", idlInt)),

                Operation("clearColor", idlVoid, false, Arg("r", idlInt), Arg("g", idlInt), Arg("b", idlInt), Arg("a", idlDouble)),
                //Operation("clearColor", idlVoid, false, Arg("r", idlDouble), Arg("g", idlDouble), Arg("b", idlDouble), Arg("a", idlDouble)),

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
    Interface("__Global",
        Attribute("document", idlInterfaceRef("Document"), readOnly = true),

        Operation("fetch", idlInterfaceRef("Promise"), Arg("url", idlString)),
        Operation("setInterval", idlVoid, Arg("lambda", idlFunction), Arg("interval", idlInt))
    )
)

   
