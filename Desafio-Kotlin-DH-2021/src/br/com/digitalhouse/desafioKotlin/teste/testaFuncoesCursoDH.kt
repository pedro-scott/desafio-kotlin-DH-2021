package br.com.digitalhouse.desafioKotlin.teste

import br.com.digitalhouse.desafioKotlin.modelo.DigitalHouseManager

fun testaFuncoesCursoDH() {
    val dh = DigitalHouseManager()

    println("\n\n\n****CRIANDO PROFESSORES****\n")

    dh.registrarTItular(
        nometitular = "Pedro",
        sobrenomeTitular = "Scott",
        especialidade = "Mobile Android"
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

    println("\n\n\n****CRIANDO CURSOS E TESTANDO POSSIBILIDADES****\n")

    dh.registrarCurso(
        nome = "Java",
        qtdMaxAlunos = null
    )
    println()

    dh.registrarCurso(
        nome = "Kotlin",
        qtdMaxAlunos = 5
    )
    println()

    dh.registrarCurso(
        nome = "Java",
        qtdMaxAlunos = 5
    )
    println()

    dh.registrarCurso(
        nome = "JavaScript",
        qtdMaxAlunos = 10
    )
    println()

    println("\n\n\n****ALOCANDO PROFESSORES E TESTANDO POSSIBILIDADES****\n")

    dh.alocarProfessores(
        codigoCurso = null,
        codigoTitular = 1,
        codigoAdjunto = 2
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 1,
        codigoTitular = null,
        codigoAdjunto = 2
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 1,
        codigoTitular = 1,
        codigoAdjunto = null
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 9,
        codigoTitular = 1,
        codigoAdjunto = 2
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 1,
        codigoTitular = 2,
        codigoAdjunto = 2
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 1,
        codigoTitular = 9,
        codigoAdjunto = 2
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 1,
        codigoTitular = 1,
        codigoAdjunto = 1
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 1,
        codigoTitular = 1,
        codigoAdjunto = 9
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 1,
        codigoTitular = 1,
        codigoAdjunto = 2
    )
    println()

    dh.alocarProfessores(
        codigoCurso = 3,
        codigoTitular = 3,
        codigoAdjunto = 4
    )
    println()

    println("\n\n\n****REMOVENDO CURSOS E TESTANDO POSSIBILIDADES****\n")

    dh.excluirCurso(codigoCurso = null)
    println()

    dh.excluirCurso(codigoCurso = 4)
    println()

    dh.excluirCurso(codigoCurso = 2)
    println()

    println("\n\n\n****LISTANDO CURSOS****\n")

    dh.imprimirCursos
}