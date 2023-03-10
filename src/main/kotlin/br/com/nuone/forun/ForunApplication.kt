package br.com.nuone.forun

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForunApplication

fun main(args: Array<String>) {
	runApplication<ForunApplication>(*args)
}
