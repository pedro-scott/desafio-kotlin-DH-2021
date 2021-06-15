package br.com.digitalhouse.desafioKotlin

import br.com.digitalhouse.desafioKotlin.modelo.DigitalHouseManager
import br.com.digitalhouse.desafioKotlin.funcao.*

fun main() {
    val dh = DigitalHouseManager()

    var opcao1: Int?
    var opcao2: Int?

    do {
        menu1
        opcao1 = readLine()?.toIntOrNull()
        divisor
        espacos

        if (opcao1 == null || opcao1 < 1 || opcao1 > 5) {
            println("Opção Inválida :(")
            divisor
            espacos
        }

        when (opcao1) {
            1 -> {
                do {
                    menu2
                    opcao2 = readLine()?.toIntOrNull()
                    divisor
                    espacos

                    if (opcao2 == null || opcao2 < 1 || opcao2 > 5) {
                        println("Opção Inválida :(")
                        divisor
                        espacos
                    }

                    when (opcao2) {
                        1 -> {
                            println("*** Registrar um Aluno no sistema ***\n")

                            print("Informe o nome do aluno: ")
                            val nome = readLine()

                            print("Informe o sobrenome do aluno: ")
                            val sobrenome = readLine()

                            println()
                            dh.registrarAluno(
                                nomeAluno = nome,
                                sobrenomeAluno = sobrenome
                            )
                            espacos
                        }

                        2 -> {
                            println("*** Excluir um Aluno registrado no sistema ***\n")

                            print("Informe o código do aluno: ")
                            val codigo = readLine()?.toIntOrNull()

                            println()
                            dh.excluirAlunoDH(codigoAluno = codigo)
                            espacos
                        }

                        3 -> {
                            println("*** Listar os Alunos registrados no sistema ***\n")

                            dh.imprimirAlunos
                            espacos
                        }

                        4 -> {
                            println("*** Listar os últimos 10 Alunos excluidos do sistema ***\n")

                            dh.imprimirAlunosExcluidos
                            espacos
                        }
                    }

                } while (opcao2 != 5)
            }

            2 -> {
                do {
                    menu3
                    opcao2 = readLine()?.toIntOrNull()
                    espacos

                    if (opcao2 == null || opcao2 < 1 || opcao2 > 6) {
                        println("Opção Inválida :(")
                        divisor
                        espacos
                    }

                    when (opcao2) {
                        1 -> {
                            println("*** Registrar um Professor Titular no sistema ***\n")

                            print("Informe o nome do professor titular: ")
                            val nome = readLine()

                            print("Informe o sobrenome do professor titular: ")
                            val sobrenome = readLine()

                            print("Informe a especialidade do professor titular: ")
                            val especialidade = readLine()

                            println()
                            dh.registrarTItular(
                                nometitular = nome,
                                sobrenomeTitular = sobrenome,
                                especialidade = especialidade
                            )
                            espacos
                        }

                        2 -> {
                            println("*** Registrar um Professor Adjunto no sistema ***\n")

                            print("Informe o nome do professor adjunto: ")
                            val nome = readLine()

                            print("Informe o sobrenome do professor adjunto: ")
                            val sobrenome = readLine()

                            print("Informe a quantidade disponível de horas de monitoria do professor adjunto: ")
                            val horasMonitoria = readLine()?.toIntOrNull()

                            println()
                            dh.registrarAdjunto(
                                nomeAdjunto = nome,
                                sobrenomeAdjunto = sobrenome,
                                horasMonitoria = horasMonitoria
                            )
                            espacos
                        }

                        3 -> {
                            println("*** Excluir um Professor registrado no sistema ***\n")

                            print("Informe o código do aluno: ")
                            val codigo = readLine()?.toIntOrNull()

                            println()
                            dh.excluirProfessor(codigoProfessor = codigo)
                            espacos
                        }

                        4 -> {
                            println("*** Listar os Professores registrados no sistema ***\n")

                            dh.imprimirProfessores
                            espacos
                        }

                        5 -> {
                            println("*** Listar os últimos 10 Professores excluídos do sistema ***\n")

                            dh.imprimirProfessoresExcluidos
                            espacos
                        }
                    }

                } while (opcao2 != 6)
            }

            3 -> {
                do {
                    menu4
                    opcao2 = readLine()?.toIntOrNull()
                    espacos

                    if (opcao2 == null || opcao2 < 1 || opcao2 > 6) {
                        println("Opção Inválida :(")
                        divisor
                        espacos
                    }

                    when (opcao2) {
                        1 -> {
                            println("*** Registrar um Curso no sistema ***\n")

                            print("Informe o nome do Curso: ")
                            val nome = readLine()

                            print("Informe a quantidade máxima de alunos do curso: ")
                            val qtdMaxAlunos = readLine()?.toIntOrNull()

                            println()
                            dh.registrarCurso(
                                nome = nome,
                                qtdMaxAlunos = qtdMaxAlunos
                            )
                            espacos
                        }

                        2 -> {
                            println("*** Alocar Professores para um Curso registrado no sistema ***\n")

                            print("Informe o código do curso: ")
                            val codigoCurso = readLine()?.toIntOrNull()

                            print("Informe o código do professor titular: ")
                            val codigoTitular = readLine()?.toIntOrNull()

                            print("Informe o código do professor adjunto: ")
                            val codigoAdjunto = readLine()?.toIntOrNull()

                            println()
                            dh.alocarProfessores(
                                codigoCurso = codigoCurso,
                                codigoTitular = codigoTitular,
                                codigoAdjunto = codigoAdjunto
                            )
                            espacos
                        }

                        3 -> {
                            println("*** Excluir um Curso registrado no sistema ***\n")

                            print("Informe o código do curso: ")
                            val codigo = readLine()?.toIntOrNull()

                            println()
                            dh.excluirCurso(codigoCurso = codigo)
                            espacos
                        }

                        4 -> {
                            println("*** Listar os Cursos registrados no sistema ***\n")

                            dh.imprimirCursos
                            espacos
                        }

                        5 -> {
                            println("*** Listar os últimos 10 Cursos excluídos do sistema ***\n")

                            dh.imprimirCursosExcluidos
                            espacos
                        }
                    }

                } while (opcao2 != 6)
            }

            4 -> {
                do {
                    menu5
                    opcao2 = readLine()?.toIntOrNull()
                    espacos

                    if (opcao2 == null || opcao2 < 1 || opcao2 > 6) {
                        println("Opção Inválida :(")
                        divisor
                        espacos
                    }

                    when (opcao2) {
                        1 -> {
                            println("*** Matricular um Aluno no sistema ***\n")

                            print("Informe o código do aluno: ")
                            val codigoAluno = readLine()?.toIntOrNull()

                            print("Informe o código do curso: ")
                            val codigoCurso = readLine()?.toIntOrNull()

                            println()
                            dh.matricularAluno(
                                codigoAluno = codigoAluno,
                                codigoCurso = codigoCurso
                            )
                            espacos
                        }

                        2 -> {
                            println("*** Consultar a Matrícula de um Aluno registrado no sistema ***\n")

                            print("Informe o código do aluno: ")
                            val codigo = readLine()?.toIntOrNull()

                            println()
                            dh.consultarMatricula(codigoAluno = codigo)
                            espacos
                        }

                        3 -> {
                            println("*** Desmatricular um Aluno registrado no sistema ***\n")

                            print("Informe o código do aluno: ")
                            val codigoAluno = readLine()?.toIntOrNull()

                            print("Informe o código do curso: ")
                            val codigoCurso = readLine()?.toIntOrNull()

                            println()
                            dh.desmatricularAluno(
                                codigoAluno = codigoAluno,
                                codigoCurso = codigoCurso
                            )
                            espacos
                        }

                        4 -> {
                            println("*** Listar as Matrículas registradas no sistema ***\n")

                            dh.imprimirMatriculas
                            espacos
                        }

                        5 -> {
                            println("*** Listar as últimas 10 Matrículas excluídas do sistema ***\n")

                            dh.imprimirMatriculasExcluidas
                            espacos
                        }
                    }

                } while (opcao2 != 6)
            }

            5 -> {
                val despedidas = listOf(
                    "Adios",
                    "Bye Bye",
                    "Xau",
                    "Até mais",
                    "Até logo"
                )

                println("${despedidas.random()} :D")
                divisor
            }
        }
    } while (opcao1 != 5)
}