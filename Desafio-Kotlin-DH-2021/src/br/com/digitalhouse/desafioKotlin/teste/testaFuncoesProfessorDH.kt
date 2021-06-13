package br.com.digitalhouse.desafioKotlin.teste

import br.com.digitalhouse.desafioKotlin.modelo.DigitalHouseManager

fun testaFuncoesProfessorDH() {
    val dh = DigitalHouseManager()

    println("\n\n\n****CRIANDO PROFESSORES E TESTANDO POSSIBILIDADES****\n")

    dh.registrarTItular(
        nometitular = "Pedro",
        sobrenomeTitular = "Scott",
        especialidade = "Mobile Android"
    )
    println()

    dh.registrarAdjunto(
        nomeAdjunto = "João",
        sobrenomeAdjunto = "Scott",
        horasMonitoria = null
    )
    println()

    dh.registrarAdjunto(
        nomeAdjunto = "João",
        sobrenomeAdjunto = "Scott",
        horasMonitoria = 4
    )
    println()

    dh.registrarTItular(
        nometitular = "Augusto",
        sobrenomeTitular = "Scott",
        especialidade = "Mobile IOS"
    )
    println()

    dh.registrarAdjunto(
        nomeAdjunto = "Paula",
        sobrenomeAdjunto = "Scott",
        horasMonitoria = 2
    )
    println()

    println("\n\n\n****REMOVENDO PROFESSORES E TESTANDO POSSIBILIDADES****\n")

    dh.excluirProfessor(codigoProfessor = null)
    println()

    dh.excluirProfessor(codigoProfessor = 5)
    println()

    dh.excluirProfessor(codigoProfessor = 2)
    println()

    dh.excluirProfessor(codigoProfessor = 4)
    println()

    println("\n\n\n****LISTANDO PROFESSORES****\n")

    dh.imprimirProfessores
}