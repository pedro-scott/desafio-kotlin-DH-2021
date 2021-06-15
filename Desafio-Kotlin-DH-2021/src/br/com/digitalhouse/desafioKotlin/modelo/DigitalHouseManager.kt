package br.com.digitalhouse.desafioKotlin.modelo

import br.com.digitalhouse.desafioKotlin.funcao.divisor

class DigitalHouseManager {
    private val alunos = mutableListOf<Aluno>()
    private val alunosExcluidos = mutableListOf<Aluno>()
    private val professores = mutableListOf<Professor>()
    private val professoresExcluidos = mutableListOf<Professor>()
    private val cursos = mutableListOf<Curso>()
    private val cursosExcluidos = mutableListOf<Curso>()
    private val matriculas = mutableListOf<Matricula>()
    private val matriculasExcluidas = mutableListOf<Matricula>()

    //Registra um curso na lista cursos da classe atual com base nos dados informados
    fun registrarCurso(
        nome: String?,
        qtdMaxAlunos: Int?
    ) =
        when {
            nome == null -> {
                println("Nome informado para o Curso é inválido!")
                divisor
            }
            qtdMaxAlunos == null -> {
                println("Quantidade máxima de alunos informada para o Curso é inválida!")
                divisor
            }
            else -> {
                cursos.add(
                    Curso(
                        nomeCurso = nome,
                        qtdMaxAlunos = qtdMaxAlunos
                    )
                )
                println(cursos.last())
                println("Registrado com sucesso :)")
            }
        }

    //Exclui um curso na lista cursos da classe atual com base no código informado
    fun excluirCurso(codigoCurso: Int?) {
        codigoCurso ?: kotlin.run {
            println("Código informado para o Curso é inválido!")
            divisor
            return
        }

        val curso = cursos.find { it.codigoCurso == codigoCurso } ?: kotlin.run {
            println("Curso inexistente!")
            divisor
            return
        }

        curso.removerDeCodigosCursosAtivos(codigo = codigoCurso)
        cursos.remove(element = curso)
        if (alunosExcluidos.size == 10) alunosExcluidos.removeAt(index = 0)
        cursosExcluidos.add(element = curso)
        println(curso)
        println("Excluído com sucesso :)")
    }

    //Registra um Professor Adjunto na lista professores da classe atual com base nos dados informados
    fun registrarAdjunto(
        nomeAdjunto: String?,
        sobrenomeAdjunto: String?,
        horasMonitoria: Int?
    ) =
        when {
            nomeAdjunto == null -> {
                println("Nome informado para o Professor Adjunto é inválido!")
                divisor
            }
            sobrenomeAdjunto == null -> {
                println("Sobrenome informado para o Professor Adjunto é inválido!")
                divisor
            }
            horasMonitoria == null -> {
                println("Quantidade disponível de horas para monitoria informada para o Professor Adjunto é inválida!")
                divisor
            }
            else -> {
                professores.add(
                    ProfessorAdjunto(
                        nomeProfessor = nomeAdjunto,
                        sobrenomeProfessor = sobrenomeAdjunto,
                        horasMonitoria = horasMonitoria
                    )
                )
                println(professores.last())
                println("Registrado com sucesso :)")
            }
        }

    //Registra um Professor Titular na lista professores da classe atual com base nos dados informados
    fun registrarTItular(
        nometitular: String?,
        sobrenomeTitular: String?,
        especialidade: String?
    ) =
        when {
            nometitular == null -> {
                println("Nome informado para o Professor Titular é inválido!")
                divisor
            }
            sobrenomeTitular == null -> {
                println("Sobrenome informado para o Professor TItular é inválido!")
                divisor
            }
            especialidade == null -> {
                println("Especialidade informada para o Professor Titular é invpalida!")
                divisor
            }
            else -> {
                professores.add(
                    ProfessorTitular(
                        nomeProfessor = nometitular,
                        sobrenomeProfessor = sobrenomeTitular,
                        especialidade = especialidade
                    )
                )
                println(professores.last())
                println("Registrado com sucesso :)")
            }
        }

    //Exclui um Professor na lista professores da classe atual com base no código informado
    fun excluirProfessor(codigoProfessor: Int?) {
        codigoProfessor ?: kotlin.run {
            println("Código informado para o Professor é inválido!")
            divisor
            return
        }

        val professor = professores.find { it.codigoProfessor == codigoProfessor } ?: kotlin.run {
            println("Professor inexistente!")
            divisor
            return
        }

        professor.removerDeCodigosProfessoresAtivos(codigo = codigoProfessor)
        professores.remove(element = professor)
        if (professoresExcluidos.size == 10) professoresExcluidos.removeAt(index = 0)
        professoresExcluidos.add(element = professor)
        when (professor) {
            is ProfessorTitular -> println(professor)
            is ProfessorAdjunto -> println(professor)
        }
        println("Excluído com sucesso :)")
    }

    //Registra um Aluno na lista alunos da classe atual com base nos dados informados
    fun registrarAluno(
        nomeAluno: String?,
        sobrenomeAluno: String?
    ) =
        when {
            nomeAluno == null -> {
                println("Nome informado para o Aluno é inválido!")
                divisor
            }
            sobrenomeAluno == null -> {
                println("Sobrenome informado para o Aluno é inválido!")
                divisor
            }
            else -> {
                alunos.add(
                    Aluno(
                        nomeAluno = nomeAluno,
                        sobrenomeAluno = sobrenomeAluno
                    )
                )
                println(alunos.last())
                println("Registrado com sucesso :)")
            }
        }

    //Exclui um Aluno na lista alunos da classe atual com base nos dados informados
    fun excluirAlunoDH(codigoAluno: Int?) {
        codigoAluno ?: kotlin.run {
            println("Código informado para o Aluno é inválido!")
            divisor
            return
        }

        val aluno = alunos.find { it.codigoAluno == codigoAluno } ?: kotlin.run {
            println("Aluno inexistente!")
            divisor
            return
        }

        println(aluno)

        //Verifica se o aluno está matriculado e caso não esteja exclui ele do sistema
        matriculas.find { it.aluno == aluno } ?: kotlin.run {
            aluno.removerDeCodigosAlunosAtivos(codigo = codigoAluno)
            alunos.remove(element = aluno)
            if (alunosExcluidos.size == 10) alunosExcluidos.removeAt(index = 0)
            alunosExcluidos.add(element = aluno)
            println("Excluído com sucesso :)")
            return
        }

        println("Aluno encontra-se matrículado e não é possível excluí-lo do sistema antes de cancelar sua matrícula!")
    }

    //Cria uma matricula para um aluno e add a lista matriculas da classe atual ou apenas add um curso a sua matricula existente.
    fun matricularAluno(
        codigoAluno: Int?,
        codigoCurso: Int?
    ) {
        codigoAluno ?: kotlin.run {
            println("Codigo informado para o Aluno é inválido!")
            divisor
            return
        }

        codigoCurso ?: kotlin.run {
            println("Codigo informado para o Curso é inválido!")
            divisor
            return
        }

        val aluno = alunos.find { it.codigoAluno == codigoAluno } ?: kotlin.run {
            println("Aluno inexistente!")
            divisor
            return
        }

        val curso = cursos.find { it.codigoCurso == codigoCurso } ?: kotlin.run {
            println("Curso inexistente!")
            divisor
            return
        }

        //Verifica se o curso está cheio ou se o aluno já está matriculado no curso, caso contrário add o aluno ao curso.
        if (!curso.addUmAluno(umAluno = aluno)) {
            divisor
            return
        }

        //Verifica se o aluno já tem uma matrícula.
        val matriculaExistente = matriculas.find { it.aluno == aluno }

        //Caso exista uma matrícula para o aluno, apenas add mais um curso a lista de cursos da matricula do aluno.
        if (matriculaExistente != null) {
            matriculaExistente.addCurso(umCurso = curso)

            println(matriculaExistente)
        } else {
            matriculas.add(Matricula(aluno = aluno))

            matriculas.last().addCurso(umCurso = curso)

            println(matriculas.last())
        }

        println("${aluno.nomeAluno} ${aluno.sobrenomeAluno} matriculado com sucesso no curso ${curso.nomeCurso} :)")
    }

    //Fornece as informações da matrícula do aluno informado, caso seja possível.
    fun consultarMatricula(codigoAluno: Int?) {
        codigoAluno ?: kotlin.run {
            println("Codigo informado para o Aluno é inválido!")
            divisor
            return
        }

        val aluno = alunos.find { it.codigoAluno == codigoAluno } ?: kotlin.run {
            println("Aluno inexistente!")
            divisor
            return
        }

        val matricula = matriculas.find { it.aluno == aluno } ?: kotlin.run {
            println("Aluno não matriculado na Digital House!")
            divisor
            return
        }

        println(matricula)
    }

    /*
        Desmatricula um aluno de um curso e caso ele não esteja matriculado em mais nenhum curso, exclui sua matricula
        da lista matriculas da classe atual.
    */
    fun desmatricularAluno(
        codigoAluno: Int?,
        codigoCurso: Int?
    ) {
        codigoAluno ?: kotlin.run {
            println("Codigo informado para o Aluno é inválido!")
            divisor
            return
        }

        codigoCurso ?: kotlin.run {
            println("Codigo informado para o Curso é inválido!")
            divisor
            return
        }

        val aluno = alunos.find { it.codigoAluno == codigoAluno } ?: kotlin.run {
            println("Aluno inexistente!")
            divisor
            return
        }

        val curso = cursos.find { it.codigoCurso == codigoCurso } ?: kotlin.run {
            println("Curso inexistente!")
            divisor
            return
        }

        val matricula = matriculas.find { it.aluno == aluno } ?: kotlin.run {
            println("Matrícula não encontrada!")
            divisor
            return
        }

        //Verifica se o aluno está matriculado no curso.
        if (!matricula.verificarCurso(umCurso = curso)) {
            println("Aluno não matriculado no curso ${curso.nomeCurso}!")
            divisor
            return
        }

        curso.excluirAluno(umAluno = aluno)
        matricula.removerCurso(umCurso = curso)

        println(matricula)
        println("Desmatriculado com sucesso do curso ${curso.nomeCurso} :)")

        //Verifica se o aluno possui mais cursos e exclui ele da DHManager, caso não tenha.
        if (matricula.nenhumCursoMatriculado) {
            matricula.removerDeCodigosMatriculasAtivas(codigo = matricula.codigoMatricula)
            matriculas.remove(matricula)
            if (matriculasExcluidas.size == 10) matriculasExcluidas.removeAt(index = 0)
            matriculas.add(element = matricula)
            println("Matrícula excluída com sucesso :)")
        }
    }

    //Aloca professores para cursos ja existentes na lista cursos da classe atual.
    fun alocarProfessores(
        codigoCurso: Int?,
        codigoTitular: Int?,
        codigoAdjunto: Int?
    ) {
        codigoCurso ?: kotlin.run {
            println("Codigo informado para o Curso é inválido!")
            divisor
            return
        }

        codigoTitular ?: kotlin.run {
            println("Código informado para o Professor Titular é inválido!")
            divisor
            return
        }

        codigoAdjunto ?: kotlin.run {
            println("Código informado para o Professor Adjunto é inválido!")
            divisor
            return
        }

        val curso = cursos.find { it.codigoCurso == codigoCurso } ?: kotlin.run {
            println("Curso inexistente!")
            divisor
            return
        }

        val titular = professores.find { it.codigoProfessor == codigoTitular } ?: kotlin.run {
            println("Professor Titular inexistente!")
            divisor
            return
        }

        if (titular is ProfessorAdjunto) {
            println("Professor passado como Titular é Adjunto!")
            divisor
            return
        }

        val adjunto = professores.find { it.codigoProfessor == codigoAdjunto } ?: kotlin.run {
            println("Professor Adjunto inexistente!")
            divisor
            return
        }

        if (adjunto is ProfessorTitular) {
            println("Professor passado como Adjunto é Titular!")
            divisor
            return
        }

        curso.atualizarTitularCurso(titular = titular as ProfessorTitular)
        curso.atualizarAdjuntoCurso(adjunto = adjunto as ProfessorAdjunto)
        println(curso)
        println("Professores alocados com sucesso :)")
    }

    //Imprime a lista alunos da classe atual.
    val imprimirAlunos: Unit get() {
        if (alunos.isEmpty()) {
            println("Nenhum aluno foi registrado!")
            divisor
            return
        }

        alunos.forEach {
            println("$it")
            if (it != alunos.last()) println()
        }
    }

    //Imprime a lista alunosExcluidos da classe atual, que contém as últimas 10 exclusões.
    val imprimirAlunosExcluidos: Unit get() {
        if (alunosExcluidos.isEmpty()) {
            println("Nenhum aluno foi excluido!")
            divisor
            return
        }

        alunosExcluidos.forEach {
            println("$it")
            if (it != alunosExcluidos.last()) println()
        }
    }

    //Imprime a lista professores da classe atual.
    val imprimirProfessores: Unit get() {
        if (professores.isEmpty()) {
            println("Nenhum professor foi registrado!")
            divisor
            return
        }

        professores.forEach {
            println("$it")
            if (it != professores.last()) println()
        }
    }

    //Imprime a lista professoresExcluidos da classe atual, que contém as últimas 10 exclusões.
    val imprimirProfessoresExcluidos: Unit get() {
        if (professoresExcluidos.isEmpty()) {
            println("Nenhum professor foi excluido!")
            divisor
            return
        }

        professoresExcluidos.forEach {
            println("$it")
            if (it != professoresExcluidos.last()) println()
        }
    }

    //Imprime a lista cursos da classe atual.
    val imprimirCursos: Unit get() {
        if (cursos.isEmpty()) {
            println("Nenhum curso foi registrado!")
            divisor
            return
        }

        cursos.forEach {
            println("$it")
            if (it != cursos.last()) println()
        }
    }

    //Imprime a lista cursosExcluidos da classe atual, que contém as últimas 10 exclusões.
    val imprimirCursosExcluidos: Unit get() {
        if (cursosExcluidos.isEmpty()) {
            println("Nenhum curso foi excluido!")
            divisor
            return
        }

        cursosExcluidos.forEach {
            println("$it")
            if (it != cursosExcluidos.last()) println()
        }
    }

    //Imprime a lista matriculas da classe atual.
    val imprimirMatriculas: Unit get() {
        if (matriculas.isEmpty()) {
            println("Nenhuma matrícula foi registrada!")
            divisor
            return
        }

        matriculas.forEach {
            println("$it")
            if (it != matriculas.last()) println()
        }
    }

    //Imprime a lista matriculasExcluidas da classe atual, que contém as últimas 10 exclusões.
    val imprimirMatriculasExcluidas: Unit get() {
        if (matriculasExcluidas.isEmpty()) {
            println("Nenhuma matrícula foi excluida!")
            divisor
            return
        }

        matriculasExcluidas.forEach {
            println("$it")
            if (it != matriculasExcluidas.last()) println()
        }
    }
}