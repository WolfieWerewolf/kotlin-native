package org.jetbrains.kotlin.native.interop.gen.wasm.idl

// This is (as of now) !a poor man's IDL representation.

interface Type 
interface  Member {
    val isStatic: Boolean get() = false
}

object idlVoid: Type
object idlInt: Type
object idlFloat: Type
object idlDouble: Type
object idlString: Type
object idlObject: Type
object idlFunction: Type

data class Attribute(val name: String, val type: Type,
                     val readOnly: Boolean = false,
                     override val isStatic: Boolean = false): Member

interface IArg{
    val name: String
    val type: Type
}

data class Arg(override val name: String, override val type: Type): IArg

data class FakeArg(override val name: String="", override val type: Type): IArg

class Operation(val name: String, val returnType: Type,
                override val isStatic: Boolean = false,
                vararg val args: IArg): Member {

    constructor(name: String, returnType: Type, vararg args: IArg) :
            this(name, returnType, false, *args)
}

data class idlInterfaceRef(val name: String): Type

class Interface(val name: String, vararg val members: Member) {
    val isGlobal = (name == "__Global")
}
