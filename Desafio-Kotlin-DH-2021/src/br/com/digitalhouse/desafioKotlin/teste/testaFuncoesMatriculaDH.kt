package br.com.digitalhouse.desafioKotlin.teste

import br.com.digitalhouse.desafioKotlin.modelo.DigitalHouseManager

fun testaFuncoesMatriculaDH() {
    val dh = DigitalHouseManager()

    println("****CRIANDO ALUNOS****\n")

    dh.registrarAluno(
        nomeAluno = "Pedro",
        sobrenomeAluno = "Scott"
    )
    println()

    dh.registrarAluno(
        nomeAluno = "João",
        sobrenomeAluno = "Scott"
    )
    println()

    dh.registrarAluno(
        nomeAluno = "Paula",
        sobrenomeAluno = "Scott"
    )
    println()

    println("\n\n\n****CRIANDO CURSOS****\n")

    dh.registrarCurso(
        nome = "Java",
        qtdMaxAlunos = 2
    )
    println()

    dh.registrarCurso(
        nome = "Kotlin",
        qtdMaxAlunos = 5
    )
    println()

    println("\n\n\n****MATRICULANDO ALUNOS E TESTANDO POSSIBILIDADES****\n")

    dh.matricularAluno(
        codigoCurso = null,
        codigoAluno = 1
    )
    println()

    dh.matricularAluno(
        codigoCurso = 1,
        codigoAluno = null
    )
    println()

    dh.matricularAluno(
        codigoCurso = 3,
        codigoAluno = 1
    )
    println()

    dh.matricularAluno(
        codigoCurso = 1,
        codigoAluno = 5
    )
    println()

    dh.matricularAluno(
        codigoCurso = 1,
        codigoAluno = 1
    )
    println()

    dh.matricularAluno(
        codigoCurso = 1,
        codigoAluno = 1
    )
    println()

    dh.matricularAluno(
        codigoCurso = 1,
        codigoAluno = 2
    )
    println()

    dh.matricularAluno(
        codigoCurso = 2,
        codigoAluno = 1
    )
    println()

    dh.matricularAluno(
        codigoCurso = 2,
        codigoAluno = 2
    )
    println()

    dh.matricularAluno(
        codigoCurso = 2,
        codigoAluno = 3
    )
    println()

    println("\n\n\n****REMOVENDO MATRICULAS E TESTANDO POSSIBILIDADES****\n")

    dh.desmatricularAluno(
        codigoCurso = null,
        codigoAluno = 1
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 1,
        codigoAluno = null
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 5,
        codigoAluno = 1
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 1,
        codigoAluno = 9
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 1,
        codigoAluno = 3
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 1,
        codigoAluno = 1
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 1,
        codigoAluno = 2
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 1,
        codigoAluno = 1
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 2,
        codigoAluno = 1
    )
    println()

    dh.desmatricularAluno(
        codigoCurso = 2,
        codigoAluno = 2
    )
    println()

    println("\n\n\n****CONSULTANDO MATRÍCULAS E TESTANDO POSSIBILIDADES****\n")

    dh.consultarMatricula(codigoAluno = null)
    println()

    dh.consultarMatricula(codigoAluno = 9)
    println()

    dh.consultarMatricula(codigoAluno = 1)
    println()

    dh.consultarMatricula(codigoAluno = 2)
    println()

    dh.consultarMatricula(codigoAluno = 3)
    println()
}