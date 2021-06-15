package br.com.digitalhouse.desafioKotlin.modelo

class Curso(
    val nomeCurso: String,
    val qtdMaxAlunos: Int,
    registrarCodigoCurso: Boolean = true
) {
    var titular: ProfessorTitular? = null
        private set
    var adjunto: ProfessorAdjunto? = null
        private set
    private val alunosMatriculados = mutableListOf<Aluno>()

    //Companion responsável por controlar os códigos fornecidos aos cursos, armazenando os ativos e excluídos.
    companion object {
        private var codigoCursoDisponivel = 1
        private val codigosCursosAtivos = mutableListOf<Int>()
        private val codigosCursosExcluidos = mutableListOf<Int>()

//        fun imprimirCodigosCursosAtivos() = codigosCursosAtivos.forEach { print("$it ") }
//        fun imprimirCodigosCursosExcluidos() = codigosCursosExcluidos.forEach { print("$it ") }
    }

    // Remove o código informado da lista codigosCursosAtivos e add na lista codigosCursosExcluidos.
    fun removerDeCodigosCursosAtivos(codigo: Int) : Boolean =
        if (codigosCursosAtivos.contains(element = codigo)) {
            codigosCursosAtivos.remove(element = codigo)
            codigosCursosExcluidos.add(element = codigo)
            true
        } else false

    var codigoCurso = codigoCursoDisponivel
        private set

    init {
        // Verificação para inclusão na lista do companion.
        // Por padrão o código de um objeto Curso sempre será adicionado a lista do companion.
        if (registrarCodigoCurso) {
            codigosCursosAtivos.add(codigoCursoDisponivel)
            codigoCursoDisponivel++
        }
    }

    //Sobrescreve o equals da classe atual.
    override fun equals(other: Any?): Boolean =
        when (other) {
            is Curso -> {
                when {
                    this.nomeCurso != other.nomeCurso -> false
                    this.codigoCurso != other.codigoCurso -> false
                    this.titular != other.titular -> false
                    this.adjunto != other.adjunto -> false
                    else -> true
                }
            }
            else -> false
        }

    //Sobrescreve o hashCode da classe atual.
    override fun hashCode(): Int {
        var result = nomeCurso.hashCode()

        result = 31 * result + titular.hashCode()
        result = 31 * result + adjunto.hashCode()
        result = 31 * result + codigoCurso

        return result
    }

    //Constroi uma string que representa os alunos matriculados e será usada na toString da classe atual.
    private val toStringAlunosMatriculados: String get() {
        if (alunosMatriculados.isEmpty()) return "      Nenhum Aluno Matriculado no momento!"

        val string = StringBuilder()

        alunosMatriculados.forEach {
            string.append(it.toStringCurso)
            if (it != alunosMatriculados.last()) string.append("\n\n")
        }

        return string.toString()
    }

    //Sobrescreve o toString da classe atual
    override fun toString(): String =
        """
            |Curso $nomeCurso - ${codigoCurso.toString().padStart(length = 5, padChar = '0')}
            |${titular?.toStringCurso ?: "   Professor Titular ainda não definido!"}
            |
            |${adjunto?.toStringCurso ?: "   Professor Adjunto ainda não definido!"}
            |
            |   Quantidade Máxima de Alunos: $qtdMaxAlunos
            |
            |   Alunos Matriculados:
            |$toStringAlunosMatriculados
            |----------------------------------------
        """.trimMargin()

    //Constroi uma string que representa os alunos matriculados e será usada na toStringMatricula da classe atual.
    private val toStringAlunosMatriculadosMatricula: String get() {
        if (alunosMatriculados.isEmpty()) return "              Nenhum Aluno Matriculado no momento!"

        val string = StringBuilder()

        alunosMatriculados.forEach {
            string.append(it.toStringCursoAlunosMatriculados)
            if (it != alunosMatriculados.last()) string.append("\n\n")
        }

        return string.toString()
    }

    //Formata uma string da classe atual para ser usada na classe Matricula.
    val toStringMatricula: String get() =
        """
            |       Curso $nomeCurso - ${codigoCurso.toString().padStart(length = 5, padChar = '0')}
            |${titular?.toStringMatricula ?: "           Professor Titular ainda não definido!"}
            |
            |${adjunto?.toStringMatricula ?: "           Professor Adjunto ainda não definido!"}
            |
            |           Quantidade Máxima de Alunos: $qtdMaxAlunos
            |   
            |           Alunos Matriculados:
            |$toStringAlunosMatriculadosMatricula
        """.trimMargin()

    //Add o aluno informado em alunosMatriculados da classe atual.
    fun addUmAluno(umAluno: Aluno) : Boolean =
        when {
            alunosMatriculados.contains(umAluno) -> {
                println("Aluno já matriculado no curso $nomeCurso!")
                false
            }
            alunosMatriculados.size == qtdMaxAlunos -> {
                println("Não há vagas para o curso $nomeCurso!")
                false
            }
            else -> {
                alunosMatriculados.add(element = umAluno)
                true
            }
        }

    //Remove o aluno informado de alunosMatriculados da classe atual.
    fun excluirAluno(umAluno: Aluno) : Boolean = alunosMatriculados.remove(element = umAluno)

    //Atualiza o Professor Titular da classe atual.
    fun atualizarTitularCurso(titular: ProfessorTitular) { this.titular = titular }

    //Atualiza o Professor Adjunto da classe atual.
    fun atualizarAdjuntoCurso(adjunto: ProfessorAdjunto) { this.adjunto = adjunto }
}