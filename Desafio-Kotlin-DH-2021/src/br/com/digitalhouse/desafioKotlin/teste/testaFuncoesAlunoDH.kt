package br.com.digitalhouse.desafioKotlin.teste

import br.com.digitalhouse.desafioKotlin.modelo.DigitalHouseManager

fun testaFuncoesAlunoDH() {
    val dh = DigitalHouseManager()

    println("****CRIANDO ALUNOS E TESTANDO POSSIBILIDADES****\n")

    dh.registrarAluno(
        nomeAluno = "Pedro",
        sobrenomeAluno = "Scott"
    )
    println()

    dh.registrarAluno(
        nomeAluno = "Pedro",
        sobrenomeAluno = "Scott"
    )
    println()

    dh.registrarAluno(
        nomeAluno = "Pedro",
        sobrenomeAluno = "Scott"
    )
    println()

    dh.registrarAluno(
        nomeAluno = "Pedro",
        sobrenomeAluno = "Scott"
    )
    println()

    dh.registrarAluno(
        nomeAluno = "Pedro",
        sobrenomeAluno = "Scott"
    )
    println()

    println("\n\n\n****REMOVENDO ALUNOS E TESTANDO POSSIBILIDADES****\n")

    dh.excluirAlunoDH(codigoAluno = null)
    println()

    dh.excluirAlunoDH(codigoAluno = 6)
    println()

    dh.excluirAlunoDH(codigoAluno = 3)
    println()

    dh.registrarCurso(
        nome = "Kotlin",
        qtdMaxAlunos = 5
    )
    println()

    dh.matricularAluno(
        codigoAluno = 1,
        codigoCurso = 1
    )
    println()

    dh.excluirAlunoDH(codigoAluno = 1)
    println()

    println("\n\n\n****LISTANDO ALUNOS****\n")

    dh.imprimirAlunos
}