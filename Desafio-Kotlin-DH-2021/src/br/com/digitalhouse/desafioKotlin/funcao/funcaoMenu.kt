package br.com.digitalhouse.desafioKotlin.funcao

val menu1: Unit get() =
    print(
        """
            |Olá :D Seja bem-vindo a Digital House Manager!
            |
            |O que deseja fazer hoje?
            |
            |1 - Registrar/Excluir/Listar Alunos
            |2 - Registrar/Excluir/Listar Professores
            |3 - Registrar/Modificar/Excluir/Listar Cursos
            |4 - Matricular/Consultar/Desmatricular/Listar Alunos
            |5 - Fazer Logout
            |
            |Escolha uma opção: 
        """.trimMargin()
    )

val menu2: Unit get() =
    print(
        """
            |Muito bom! O que deseja fazer agora?
            |
            |1 - Registrar um Aluno no sistema
            |2 - Excluir um Aluno registrado no sistema
            |3 - Listar os Alunos registrados no sistema
            |4 - Voltar ao menu anterior
            |
            |Escolha uma opção: 
        """.trimMargin()
    )

val menu3: Unit get() =
    print(
        """
            |Ótimo! O que deseja fazer agora?
            |
            |1 - Registrar um Professor Titular no sistema
            |2 - Registrar um Professor Adjunto no sistema
            |3 - Excluir um Professor registrado no sistema
            |4 - Listar os Professores registrados no sistema
            |5 - Voltar ao menu anterior
            |
            |Escolha uma opção: 
        """.trimMargin()
    )

val menu4: Unit get() =
    print(
        """
            |Perfeito! O que deseja fazer agora?
            |
            |1 - Registrar um Curso no sistema
            |2 - Alocar Professores para um Curso registrado no sistema
            |3 - Excluir um Curso registrado no sistema
            |4 - Listar os Cursos registrados no sistema
            |5 - Voltar ao menu anterior
            |
            |Escolha uma opção: 
        """.trimMargin()
    )

val menu5: Unit get() =
    print(
        """
            |Muito bem! O que deseja fazer agora?
            |
            |1 - Matricular um Aluno no sistema
            |2 - Consultar a Matrícula de um Aluno registrado no sistema
            |3 - Desmatricular um Aluno registrado no sistema
            |4 - Listar as Matrículas registradas no sistema
            |5 - Voltar ao menu anterior
            |
            |Escolha uma opção: 
        """.trimMargin()
    )