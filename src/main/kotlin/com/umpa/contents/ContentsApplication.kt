package com.umpa.contents

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContentsApplication

fun main(args: Array<String>) {
	runApplication<ContentsApplication>(*args)
}
