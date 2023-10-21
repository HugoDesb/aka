package io.aka.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

class CLI: CliktCommand() {

    override fun run() {
        TODO("Not yet implemented")
    }
}

class Server: CliktCommand(){
    override fun run() {
        TODO("Not yet implemented")
    }
}

fun main(vararg args: String) = CLI().subcommands(Server()).main(args)