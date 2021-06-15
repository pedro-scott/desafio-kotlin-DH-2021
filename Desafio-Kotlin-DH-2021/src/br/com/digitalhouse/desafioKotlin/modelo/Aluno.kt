package br.com.digitalhouse.desafioKotlin.modelo

class Aluno(
    val nomeAluno: String,
    val sobrenomeAluno: String,
    registrarCodigoAluno: Boolean = true
) {
    //Companion responsável por controlar os códigos fornecidos aos alunos, armazenando os ativos e excluídos.
    companion object {
        private var codigoAlunoDisponivel = 1
        private val codigosAlunosAtivos = mutableListOf<Int>()
        private val codigosAlunosExcluidos = mutableListOf<Int>()

//        fun imprimirCodigosAlunosAtivos() = codigosAlunosAtivos.forEach { print("$it ") }
//        fun imprimirCodigosAlunosExcluidos() = codigosAlunosExcluidos.forEach { print("$it ") }
    }

    // Remove o código informado da lista codigosAlunosAtivos.
    fun removerDeCodigosAlunosAtivos(codigo: Int) : Boolean =
        if (codigosAlunosAtivos.contains(element = codigo)) {
            codigosAlunosAtivos.remove(element = codigo)
            codigosAlunosExcluidos.add(element = codigo)
            true
        } else false

    var codigoAluno = codigoAlunoDisponivel
        private set

    init {
        // Verificação para inclusão na lista do companion.
        // Por padrão o código de um objeto Aluno sempre será adicionado a lista do companion.
        if (registrarCodigoAluno) {
            codigosAlunosAtivos.add(codigoAlunoDisponivel)
            codigoAlunoDisponivel++
        }
    }

    //Sobrescreve o equals da classe atual.
    override fun equals(other: Any?): Boolean =
        when (other) {
            is Aluno -> {
                when {
                    this.nomeAluno != other.nomeAluno -> false
                    this.sobrenomeAluno != other.sobrenomeAluno -> false
                    this.codigoAluno != other.codigoAluno -> false
                    else -> true
                }
            }
            else -> false
        }

    //Sobrescreve o hashCode da classe atual.
    override fun hashCode(): Int {
        var result = nomeAluno.hashCode()

        result = 31 * result + sobrenomeAluno.hashCode()
        result = 31 * result + codigoAluno

        return result
    }

    //Sobrescreve o toString da classe atual.
    override fun toString(): String =
        """
            |Aluno - ${codigoAluno.toString().padStart(length = 5, padChar = '0')}
            |   Nome: $nomeAluno
            |   Sobrenome: $sobrenomeAluno
            |----------------------------------------
        """.trimMargin()

    //Formata uma string da classe atual para ser usada na classe Curso.
    val toStringCurso: String get() =
        """
            |       Aluno - ${codigoAluno.toString().padStart(length = 5, padChar = '0')}
            |           Nome: $nomeAluno
            |           Sobrenome: $sobrenomeAluno
        """.trimMargin()

    //Formata uma string da classe atual para ser usada na classe Curso em toStringAlunosMatriculadosMatricula.
    val toStringCursoAlunosMatriculados: String get() =
        """
            |               Aluno - ${codigoAluno.toString().padStart(length = 5, padChar = '0')}
            |                   Nome: $nomeAluno
            |                   Sobrenome: $sobrenomeAluno
        """.trimMargin()

    //Formata uma string da classe atual para ser usada na classe Matricula.
    val toStringMatricula: String get() =
        """
            |   Aluno Matriculado - ${codigoAluno.toString().padStart(length = 5, padChar = '0')}
            |       Nome: $nomeAluno
            |       Sobrenome: $sobrenomeAluno
        """.trimMargin()
}